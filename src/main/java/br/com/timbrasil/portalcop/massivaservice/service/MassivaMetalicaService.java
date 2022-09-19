package br.com.timbrasil.portalcop.massivaservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.Relatorio;
import br.com.timbrasil.portalcop.massivaservice.form.MassivaForm;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaMetal;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaMetalServiceId;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaMetalicaMsg;
import br.com.timbrasil.portalcop.massivaservice.model.OttMassivaMetalica;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaMetalServiceIdRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaMetalicaMsgRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaMetalRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.OttMassivaMetalicaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.AppLogSql;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaMetalicaMsgSql;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MassivaMetalicaService {
  @Autowired
  MassivaMetalRepository massivaMetalRepository;

  @Autowired
  OttMassivaMetalicaRepository ottMassivaMetalicaRepository;

  @Autowired
  MassivaMetalicaMsgRepository massivaMetalicaMsgRepository;

  @Autowired
  MassivaMetalServiceIdRepository massivaMetalServiceIdRepository;

  @Autowired
  EntityManager entityManager;

  public Optional<List<MassivaMetalicaDto>> getMassivasMetalica() {
    log.trace("Buscando massivas metalicas");
    Optional<List<MassivaMetalicaDto>> massivasMetalica = massivaMetalRepository.getMassivasMetalica();
    return massivasMetalica;
  }

  public List<OttMassivaMetalica> getOttsMassivasMetalica() {
    log.trace("Buscando otts relacionadas a massivas metalicas");
    List<OttMassivaMetalica> otts = ottMassivaMetalicaRepository.findAll();
    return otts;
  }

  @Transactional
  public void newMassiva(MassivaForm massivaForm, String matricula) throws Exception {
    log.debug("Consultando se Massiva Metálica já está aberta: Msan " + massivaForm.getMsan());
    Long idTpAcao;
    switch (massivaForm.getTipoAcao()) {
      case "Massiva de Rede Metálica":
        idTpAcao = 1L;
        break;
      case "Manutenção Programada Rede Primária":
        idTpAcao = 2L;
        break;
      case "Manutenção Programada Rede Secundária":
        idTpAcao = 3L;
        break;
      default:
        log.error("Tipo Ação invalido");
        throw new Exception("Tipo de não conformidade inválida ou inativa.");
    }

    boolean checkMassiva = checkMassiva(idTpAcao, massivaForm.getMsan(), massivaForm.getParInicio(),
        massivaForm.getParFim());
    if (checkMassiva) {
      log.debug("Massiva Já cadastrada");
      throw new Exception("Essa massiva já foi aberta: ");
    }
    Optional<MassivaMetal> optionalMassiva = massivaMetalRepository.findByMsanAndParInicioAndParFim(massivaForm.getMsan(),
        massivaForm.getParInicio(), massivaForm.getParFim());
    if (optionalMassiva.isPresent()) {
      throw new Exception("A %s já contempla a MSAN: %s, inicio %f e fim %f ".formatted(
          optionalMassiva.get().getIdMassiva(), optionalMassiva.get().getMsan(),
          optionalMassiva.get().getParInicio(), optionalMassiva.get().getParFim()));
    }
    MassivaMetal massiva = new MassivaMetal(idTpAcao, matricula, massivaForm.getTipo(), massivaForm.getMsan(),
        massivaForm.getParInicio(),
        massivaForm.getParFim(), massivaForm.getUf(), massivaForm.getCidade(), massivaForm.getIdTpFalha(),
        massivaForm.getIdTpArea(), massivaForm.getPrazo(), massivaForm.getEmpreiteira(), massivaForm.getObservacao(),
        massivaForm.getIdTpManutencao(), massivaForm.getDtIniManutencao(), massivaForm.getFileId(),
        massivaForm.getDataIniIndisp(), massivaForm.getDataFimIndisp());

    MassivaMetal save = massivaMetalRepository.save(massiva);
    if (idTpAcao.equals(1L)) {
      save.setIdMassiva("RMT_" + save.getId());
    } else if (idTpAcao.equals(2L)) {
      save.setIdMassiva("MPP_" + save.getId());
    } else if (idTpAcao.equals(3L)) {
      save.setIdMassiva("MPS_" + save.getId());
    } else {
      save.setIdMassiva("RMT_" + save.getId());
    }
    regMsgMetalMassiva(save.getIdMassiva(), matricula, "Incluir");
    atualizarMassivaMetalica(save.getIdMassiva(), save.getEmpreiteira(), save.getObservacao(), matricula,
        save.getParInicio(), save.getParFim(), save.getMsan(), save.getIdTpAcao(), false);
  }

  public boolean checkMassiva(Long idTpAcao, String msan, @NotNull String parInicio, @NotNull String parFim) {
    Optional<MassivaMetal> optionalMassiva = massivaMetalRepository.findByIdTpAcaoAndMsanAndParInicioAndParFim(idTpAcao, msan,
        parInicio, parFim);
    if (optionalMassiva.isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  @Transactional
  public void regMsgMetalMassiva(String idMassiva, String matricula, String acao) {
    try {
      MassivaMetalicaMsg massivaMetalicaMsg = new MassivaMetalicaMsg();
      massivaMetalicaMsg.setIdMassiva(idMassiva);
      massivaMetalicaMsg.setDataAcao(LocalDateTime.now());
      massivaMetalicaMsg.setUsuario(matricula);
      massivaMetalicaMsg.setAcaoExec(acao);
      massivaMetalicaMsgRepository.save(massivaMetalicaMsg);
    } catch (Exception e) {
      log.error("regMsgMetalMassiva(" + idMassiva + ", " + matricula + ", " + acao + ") - " + e.getLocalizedMessage());
    }
  }

  @Transactional
  public void atualizarMassivaMetalica(String idMassiva, String empreiteira, String observacao, String matricula,
      String parInicio, String parFim, String msan, Long idTpAcao, boolean reg) {
    int qtdClientes = atualizarClientesImpactados(msan, parInicio, parFim, idTpAcao, idMassiva);
    Optional<MassivaMetal> massiva = massivaMetalRepository.findByIdMassiva(idMassiva);
    if (massiva.isPresent()) {
      massiva.get().setDataAtualizado(LocalDateTime.now());
      massiva.get().setQuantClientes(Long.valueOf(qtdClientes));
      massiva.get().setEmpreiteira(empreiteira);
      massiva.get().setObservacao(observacao);
    }
    if (reg) {
      regMsgMetalMassiva(idMassiva, matricula, "Atualizar");
    }
  }

  @Transactional
  public int atualizarClientesImpactados(String gabinete, String parInicio, String parFim, Long tipoAcao,
      String idMassiva) {
    log.trace("Iniciando atualizarClientesImpactados('" + gabinete + "', '" + parInicio + "', '"
        + parFim + "', '" + tipoAcao + "', '" + idMassiva + "')");
    Long id = Long.parseLong(idMassiva.split("_")[1]);
    Optional<MassivaMetalServiceId> massivaMetalServiceId = massivaMetalServiceIdRepository.findbyFkMetalMassiva(id);
    if (massivaMetalServiceId.isPresent()) {
      massivaMetalServiceIdRepository.delete(massivaMetalServiceId.get());
    }

    String sql;
    if (tipoAcao.equals(2L)) {
      sql = MassivaMetalicaMsgSql.CONTAGEM_CLIENTES_NRM;
    } else {
      sql = MassivaMetalicaMsgSql.CONTAGEM_CLIENTES_SGF;
    }
    int qtdClientes;
    try {
      qtdClientes = entityManager.createNativeQuery(sql)
          .setParameter("id", id)
          .setParameter("gabinete", gabinete)
          .setParameter("parInicio", Long.parseLong(parInicio))
          .setParameter("parFim", Long.parseLong(parFim))
          .executeUpdate();
    } catch (Exception e) {
      log.error("Nao foi possivel contar os clientes impactados: ");
      qtdClientes = 0;
    }
    return qtdClientes;
  }

  @Transactional
  public void closeMassivaMetalica(String user, Long idMotivo, String idMassiva) {
    Optional<MassivaMetal> massiva = massivaMetalRepository.findByIdMassiva(idMassiva);
    if (massiva.isPresent()) {
      massiva.get().setDataFim(LocalDateTime.now());
      massiva.get().setStatus(1L);
      massiva.get().setIdMotivoFechamento(idMotivo);
      massiva.get().setUsuarioFim(user);

      regMsgMetalMassiva(idMassiva, user, "Fechar");

      // TODO: terminar essa parte
      // chamaServico(idMassiva, "close", null);
      // enviarEmailMassivaMetalica(idMassiva, "fechada", user);

      gravarLogTelaUnica(user, user.substring(1), "GESTÃO - Massiva Metálica", "FECHAR MASSIVA METALICA", null, "OK", null, idMassiva, "MASSIVA METALICA FECHADA COM SUCESSO");
    }
  }

  @Transactional
  public void gravarLogTelaUnica(String matricula, String idLg, String perfil, String acao, String id, String status,
      String serviceId, String ntt, String resultado) {
    try {
      log.info("Insert do LOG do Tela Única");
      String sql = AppLogSql.SQL_INS_COP_APP_LOG;
      entityManager.createNativeQuery(sql)
          .setParameter("acao", acao)
          .setParameter("matricula", matricula)
          .setParameter("perfil", perfil)
          .setParameter("idLg", idLg)
          .setParameter("ordem", id)
          .setParameter("status", status)
          .setParameter("serviceId", serviceId)
          .setParameter("ntt", ntt)
          .setParameter("resultado", resultado)
          .executeUpdate();
    } catch (Exception e) {
      log.error("CicopDao.setLog(" + matricula + ", " + idLg + ", " + perfil + ", " + acao + ", " + id + ", "
					+ status + ", " + serviceId + ", " + ntt + ", " + resultado + ") - " + e.getLocalizedMessage());
    }
  }

  public List<Relatorio> getRelatorio(Long id) {
    log.info("Buscando relatorio para a massiva de id: " + id);
    List<Relatorio> relatorio = massivaMetalRepository.getRelatorio(id);
    if(relatorio.isEmpty()) {
      return List.of();
    }
    return relatorio;
  }
}
