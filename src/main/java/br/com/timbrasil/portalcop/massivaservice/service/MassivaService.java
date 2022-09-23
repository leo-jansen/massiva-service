package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.AgregadorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.AnelDto;
import br.com.timbrasil.portalcop.massivaservice.dto.BrasDto;
import br.com.timbrasil.portalcop.massivaservice.dto.DistribuidorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MsanDto;
import br.com.timbrasil.portalcop.massivaservice.dto.NovoRegistroNocDto;
import br.com.timbrasil.portalcop.massivaservice.dto.PortaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.UfDto;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaEquipeResp;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaPrioridade;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaSubTpAbertura;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaEquipeRespRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaPrioridadeRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaSubTpAberturaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.UfRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.PortaSql;
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
  EntityManager entityManager;

  public List<MassivaDto> getListaMassivas() {
    log.info("Buscando lista de Massivas");
    List<MassivaDto> listaMassivas = massivaRepository.getListaMassivas();
    return listaMassivas;
  }

  public NovoRegistroNocDto getTelaInclusaoMassiva() {
    List<MassivaEquipeResp> listaMassivaEquipeResp = massivaEquipeRespRepository.findAll();
    List<UfDto> listaUf = ufRepository.getListaUf();
    List<MassivaPrioridade> listaMassivaPrioridade = massivaPrioridadeRepository.findAll();
    List<MassivaSubTpAbertura> listaMassivaSubTpAbertura = massivaSubTpAberturaRepository.findAll();
    List<MsanDto> listaMsan = (List<MsanDto>) entityManager.createNativeQuery(MassivaSql.QUERIE_LISTAR_MSANS, MsanDto.class).getResultList();
    List<AgregadorDto> listAgregador = (List<AgregadorDto>) entityManager.createNativeQuery(MassivaSql.SQL_GET_AGREGADORES).getResultList();
    List<DistribuidorDto> listDistribuidor = (List<DistribuidorDto>) entityManager.createNativeQuery(MassivaSql.QUERY_GET_DISTRIBUIDORES_MASSIVA, DistribuidorDto.class).getResultList();
    List<BrasDto> listBras = (List<BrasDto>) entityManager.createNativeQuery(MassivaSql.QUERY_GET_BRAS_MASSIVA, BrasDto.class).getResultList();
    List<AnelDto> listAnel = (List<AnelDto>) entityManager.createNativeQuery(MassivaSql.QUERY_GET_ANEL_MASSIVA, AnelDto.class).getResultList();
    List<PortaDto> listPorta = (List<PortaDto>) entityManager.createNativeQuery(PortaSql.QUERIE_SLOTS_POR_MSAN, PortaDto.class).getResultList();
    NovoRegistroNocDto novoRegistroNocDto = new NovoRegistroNocDto(listaMassivaEquipeResp, listaUf, listaMassivaPrioridade, listaMassivaSubTpAbertura, listaMsan, listAgregador, listDistribuidor, listBras, listAnel, listPorta);
    return novoRegistroNocDto;
  }
}
