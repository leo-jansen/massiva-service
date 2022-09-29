package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.AgregadorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.AnelDto;
import br.com.timbrasil.portalcop.massivaservice.dto.BrasDto;
import br.com.timbrasil.portalcop.massivaservice.dto.DistribuidorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDetalhadaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MsanDto;
import br.com.timbrasil.portalcop.massivaservice.dto.NovoRegistroNocDto;
import br.com.timbrasil.portalcop.massivaservice.dto.PortaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.TipoDto;
import br.com.timbrasil.portalcop.massivaservice.dto.TopologiaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.UfDto;
import br.com.timbrasil.portalcop.massivaservice.form.Nttform;
import br.com.timbrasil.portalcop.massivaservice.model.Atividade;
import br.com.timbrasil.portalcop.massivaservice.model.Massiva;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaEquipamento;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaEquipeResp;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaMsan;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaPrioridade;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaSlot;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaSubTpAbertura;
import br.com.timbrasil.portalcop.massivaservice.repositories.AtividadeRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.AtividadeTipoRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaEquipamentoRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaEquipeRespRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaMsanRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaPrioridadeRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaSlotRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaSubTpAberturaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaTpTopologiaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.ModuloEstadoRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.UfRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.AtividadeSql;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.PortaSql;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.TopologiaSql;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MassivaService {
  @Autowired
  MassivaRepository massivaRepository;

  @Autowired
  MassivaEquipeRespRepository massivaEquipeRespRepository;

  @Autowired
  UfRepository ufRepository;

  @Autowired
  MassivaPrioridadeRepository massivaPrioridadeRepository;

  @Autowired
  MassivaSubTpAberturaRepository massivaSubTpAberturaRepository;

  @Autowired
  AtividadeTipoRepository atividadeTipoRepository;

  @Autowired
  ModuloEstadoRepository moduloEstadoRepository;

  @Autowired
  AtividadeRepository atividadeRepository;

  @Autowired
  MassivaTpTopologiaRepository massivaTpTopologiaRepository;

  @Autowired
  MassivaSlotRepository massivaSlotRepository;

  @Autowired
  MassivaEquipamentoRepository massivaEquipamentoRepository;

  @Autowired
  MassivaMsanRepository massivaMsanRepository;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  EntityManager entityManager;

  public List<MassivaDto> getListaMassivas() {
    log.info("Buscando lista de Massivas");
    List<MassivaDto> listaMassivas = massivaRepository.getListaMassivas();
    return listaMassivas;
  }

  public NovoRegistroNocDto getTelaInclusaoMassiva() {
    log.info("Buscando dados de: Equipe Responsavel | UF | Prioridade | Tipo Abertura");
    List<MassivaEquipeResp> listaMassivaEquipeResp = massivaEquipeRespRepository.findAll();
    List<UfDto> listaUf = ufRepository.getListaUf();
    List<MassivaPrioridade> listaMassivaPrioridade = massivaPrioridadeRepository.findAll();
    List<MassivaSubTpAbertura> listaMassivaSubTpAbertura = massivaSubTpAberturaRepository.findAll();
    List<TipoDto> listaAtividade = atividadeTipoRepository.getAtividadeMassiva();
    NovoRegistroNocDto novoRegistroNocDto = new NovoRegistroNocDto(listaMassivaEquipeResp, listaUf,
        listaMassivaPrioridade, listaMassivaSubTpAbertura, listaAtividade);
    return novoRegistroNocDto;
  }

  @SuppressWarnings("unchecked")
  public List<MsanDto> getMsan(String uf) {
    log.info("Buscando Msan para a uf: " + uf);
    List<MsanDto> listaMsan = (List<MsanDto>) entityManager
        .createNativeQuery(MassivaSql.QUERY_LISTAR_MSANS, MsanDto.class)
        .setParameter("estado", uf)
        .getResultList();
    return listaMsan;
  }

  @SuppressWarnings("unchecked")
  public List<AgregadorDto> getAgregador(String uf) {
    log.info("Buscando Agregador para a uf: " + uf);
    List<AgregadorDto> listAgregador = (List<AgregadorDto>) entityManager
        .createNativeQuery(MassivaSql.SQL_GET_AGREGADORES, AgregadorDto.class)
        .setParameter("estado", uf)
        .getResultList();
    return listAgregador;
  }

  @SuppressWarnings("unchecked")
  public List<DistribuidorDto> getDistribuidor(String uf) {
    log.info("Buscando Distribuidor para a uf: " + uf);
    List<DistribuidorDto> listDistribuidor = (List<DistribuidorDto>) entityManager
        .createNativeQuery(MassivaSql.QUERY_GET_DISTRIBUIDORES_MASSIVA, DistribuidorDto.class)
        .setParameter("estado", uf)
        .getResultList();
    return listDistribuidor;
  }

  @SuppressWarnings("unchecked")
  public List<BrasDto> getbras(String uf) {
    log.info("Buscando Bras para a uf: " + uf);
    List<BrasDto> listBras = (List<BrasDto>) entityManager
        .createNativeQuery(MassivaSql.QUERY_GET_BRAS_MASSIVA, BrasDto.class)
        .setParameter("estado", uf)
        .getResultList();
    return listBras;
  }

  @SuppressWarnings("unchecked")
  public List<AnelDto> getAnel(String uf) {
    log.info("Buscando Anel para a uf: " + uf);
    List<AnelDto> listAnel = (List<AnelDto>) entityManager
        .createNativeQuery(MassivaSql.QUERY_GET_ANEL_MASSIVA, AnelDto.class)
        .setParameter("estado", uf)
        .getResultList();
    return listAnel;
  }

  @SuppressWarnings("unchecked")
  public List<PortaDto> getPorta() {
    log.info("Buscando Porta");
    List<PortaDto> listPorta = (List<PortaDto>) entityManager
        .createNativeQuery(PortaSql.QUERIE_SLOTS_POR_MSAN, PortaDto.class)
        .getResultList();
    return listPorta;
  }

  @Transactional
  public void newNtt(Nttform nttForm, String matricula, String areaUsuario) throws Exception {
    log.info("cadastrando Massiva " + areaUsuario + " | " + nttForm.toString());
    boolean nttExist = nttExist(nttForm.getNtt());
    if (nttExist) {
      throw new Exception("Ntt já existe");
    }
    Long idAtividade = newAtividade(matricula, "MS_OPN_ATV", 3L, nttForm.getTipoAtividade());
    Optional<Long> idMassivaTopologia = massivaTpTopologiaRepository.getIdMassivaTopologia(nttForm.getTipoTopologia());
    if (idMassivaTopologia.isEmpty()) {
      throw new Exception("Erro no tipo topologia");
    }
    Long qtdElementos = (long) nttForm.getEquipamento().size();
    Massiva massiva = new Massiva(idAtividade, nttForm.getSubTipoAbertura(), idMassivaTopologia.get(),
        nttForm.getCidade(),
        nttForm.getEquipeResponsavel(), nttForm.getNtt(), nttForm.getIdControle(), nttForm.getLocalidade(),
        nttForm.getDetalhesTecnicos(), nttForm.getSintoma(), nttForm.getDataAcionamento(),
        nttForm.getPrevisaoAcionamento(), nttForm.getDataFalha(), nttForm.getPrioridade(), nttForm.getObservacao(),
        areaUsuario, qtdElementos, nttForm.getClientesIndisponiveis());
    massiva = massivaRepository.save(massiva);
    if (!(nttForm.getTipoTopologia().equals("AAA") || nttForm.getTipoTopologia().equals("VoIP"))) {
      if (nttForm.getTipoTopologia().equals("SLOT")) {
        setSlotMassiva(nttForm, massiva.getId());
      }
      setEquipamento(nttForm, massiva.getId());
      setMsanMassiva(nttForm, massiva.getId());
    }
    setQtdImpactoMassiva(areaUsuario, massiva.getId());
    String msg = String.format("Massiva criada pelo usuário %s.", matricula);
    setRegistroHistoricoAtividade(idAtividade, matricula, areaUsuario, msg, 108L);
  }

  public boolean nttExist(String ntt) {
    Optional<Massiva> massiva = massivaRepository.findByNtt(ntt);
    if (massiva.isPresent()) {
      return true;
    }
    return false;
  }

  @Transactional
  public Long newAtividade(String matricula, String refStatus, Long idModulo, String tipoAtividade) throws Exception {
    log.trace("Buscando idModuloEstado");
    Optional<Long> idModuloEstado = moduloEstadoRepository.getIdByRefStatusAndFkModulo(refStatus, idModulo);
    log.trace("Buscando idAtividade");
    Optional<Long> idAtividade = atividadeTipoRepository.getIdByFkModuloAndNomeAtividade(tipoAtividade, idModulo);
    Long idUsuario = usuarioService.getIdUsuario(matricula);
    if (idModuloEstado.isEmpty()) {
      throw new Exception("Erro no modulo");
    }
    if (idAtividade.isEmpty()) {
      throw new Exception("Erro na atividade");
    }
    Atividade save = atividadeRepository
        .save(new Atividade(idUsuario, idModuloEstado.get(), idAtividade.get(), idUsuario));
    return save.getId();
  }

  @Transactional
  public void setSlotMassiva(Nttform nttForm, Long id) {
    nttForm.getSlot().forEach(s -> {
      log.info("Salvando slot: " + s + " | da Massiva de id: " + id);
      massivaSlotRepository.save(new MassivaSlot(id, s));
    });
  }

  @Transactional
  public void setEquipamento(Nttform nttForm, Long id) {
    nttForm.getEquipamento().forEach(e -> {
      log.info("Salvando equipamento: " + e + " | da massiva de id: " + id);
      massivaEquipamentoRepository.save(new MassivaEquipamento(id, e));
    });
  }

  @Transactional
  public void setMsanMassiva(Nttform nttForm, Long id) {
    TopologiaDto topologiaDto;
    switch (nttForm.getTipoTopologia()) {
      case "SLOT":
        topologiaDto = (TopologiaDto) entityManager
            .createNativeQuery(TopologiaSql.SELECT_ANEL_MSAN_GABINETE_BY_MSAN, TopologiaDto.class)
            .setParameter("msan", nttForm.getEquipamento().get(0))
            .getSingleResult();
        massivaMsanRepository
            .save(new MassivaMsan(id, topologiaDto.getAnel(), topologiaDto.getMsan(), topologiaDto.getGabinete()));
        break;
      case "MSAN":
        topologiaDto = (TopologiaDto) entityManager
            .createNativeQuery(TopologiaSql.SELECT_ANEL_MSAN_GABINETE_BY_LIST_MSAN, TopologiaDto.class)
            .setParameter("listMsan", nttForm.getEquipamento())
            .getSingleResult();
        massivaMsanRepository
            .save(new MassivaMsan(id, topologiaDto.getAnel(), topologiaDto.getMsan(), topologiaDto.getGabinete()));
        break;
      case "AGREGADOR":
        topologiaDto = (TopologiaDto) entityManager
            .createNativeQuery(TopologiaSql.SELECT_ANEL_MSAN_GABINETE_BY_LIST_AGREGADOR, TopologiaDto.class)
            .setParameter("listAgregador", nttForm.getEquipamento())
            .getSingleResult();
        massivaMsanRepository
            .save(new MassivaMsan(id, topologiaDto.getAnel(), topologiaDto.getMsan(), topologiaDto.getGabinete()));
        break;
      case "DISTRIBUIDOR":
        topologiaDto = (TopologiaDto) entityManager
            .createNativeQuery(TopologiaSql.SELECT_ANEL_MSAN_GABINETE_BY_LIST_DISTRIBUIDOR, TopologiaDto.class)
            .setParameter("listDistribuidor", nttForm.getEquipamento())
            .getSingleResult();
        massivaMsanRepository
            .save(new MassivaMsan(id, topologiaDto.getAnel(), topologiaDto.getMsan(), topologiaDto.getGabinete()));
        break;
      case "BRAS":
        topologiaDto = (TopologiaDto) entityManager
            .createNativeQuery(TopologiaSql.SELECT_ANEL_MSAN_GABINETE_BY_LIST_BRAS, TopologiaDto.class)
            .setParameter("listBras", nttForm.getEquipamento())
            .getSingleResult();
        massivaMsanRepository
            .save(new MassivaMsan(id, topologiaDto.getAnel(), topologiaDto.getMsan(), topologiaDto.getGabinete()));
        break;
      default:
        break;
    }
  }

  @Transactional
  public void setQtdImpactoMassiva(String topologiaTipo, Long idMassiva) {
    log.info("Atuaalizando clientes impactados");
    switch (topologiaTipo) {
      case "AAA":
        massivaRepository.findById(idMassiva).ifPresent(m -> {
          Long qtdImpactados = (Long) entityManager
              .createNativeQuery(MassivaSql.QUERY_QTD_CLIENTES_IMPACTADOS, Long.class)
              .getSingleResult();
          m.setQtdImpactado(qtdImpactados);
          m.setQtdBase(qtdImpactados);
        });
        break;
      case "VoIP":
        massivaRepository.findById(idMassiva).ifPresent(m -> {
          Long qtdImpactados = (Long) entityManager
              .createNativeQuery(MassivaSql.QUERY_QTD_CLIENTES_IMPACTADOS, Long.class)
              .getSingleResult();
          m.setQtdImpactado(qtdImpactados);
          m.setQtdBase(qtdImpactados);
        });
        break;
      case "SLOT":
        entityManager
            .createNativeQuery(MassivaSql.QUERY_INSERT_MASSIVA_SERVICE_ID_SLOT)
            .setParameter("idMassiva", idMassiva)
            .executeUpdate();

        entityManager
            .createNativeQuery(MassivaSql.QUERY_INSERT_QTD_MASSIVA)
            .setParameter("fkMassiva", idMassiva)
            .setParameter("idMassiva", idMassiva)
            .executeUpdate();

        break;
      default:
        entityManager
            .createNativeQuery(MassivaSql.QUERY_INSERT_MASSIVA_SERVICE_ID)
            .setParameter("idMassiva", idMassiva)
            .executeUpdate();

        entityManager
            .createNativeQuery(MassivaSql.QUERY_INSERT_QTD_MASSIVA)
            .setParameter("fkMassiva", idMassiva)
            .setParameter("idMassiva", idMassiva)
            .executeUpdate();
        break;
    }
    entityManager
        .createNativeQuery(MassivaSql.QUERY_UPDT_QTD_INDSP)
        .setParameter("idMassiva", idMassiva)
        .executeUpdate();
  }

  @Transactional
  public void setRegistroHistoricoAtividade(Long idAtividade, String matricula, String tipoAtividade, String msg, Long idMensagem) {
    log.info("Resgistrando historico de atividade do tipo " + tipoAtividade);
    Long idUsuario = usuarioService.getIdUsuario(matricula);
    entityManager
        .createNativeQuery(AtividadeSql.SQL_INSERT_HISTORICO)
        .setParameter("idAtividade", idAtividade)
        .setParameter("idMensagem", idMensagem)
        .setParameter("msg", msg)
        .setParameter("idUsuario", idUsuario)
        .executeUpdate();
  }

  public MassivaDetalhadaDto getMassiva(Long id) throws Exception {
    Optional<MassivaDetalhadaDto> massivaDto = massivaRepository.getMassivaById(id);
    if (massivaDto.isEmpty()) {
      throw new Exception("Massiva não encontrada");
    }
    if (!("AAA".equals(massivaDto.get().getTipoTopologia()) || "VoIP".equals(massivaDto.get().getTipoTopologia()))) {
      List<String> listEquipamento = massivaEquipamentoRepository.getEquipamentosByFkMassiva(id);
      List<String> listMsan = massivaMsanRepository.getMsanByFkMassiva(id);
      massivaDto.get().setEquipamento(listEquipamento);
      massivaDto.get().setMsan(listMsan);
    }
    if("SLOT".equals(massivaDto.get().getTipoTopologia())) {
      List<String> listSlot = massivaSlotRepository.getSlotByFkMassiva(id);
      massivaDto.get().setSlot(listSlot);
    }
    return massivaDto.get();
  }
}
