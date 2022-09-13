package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.ManutencaoDto;
import br.com.timbrasil.portalcop.massivaservice.repositories.ManutencaoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManutencaoService {
  @Autowired
  ManutencaoRepository manutencaoRepository;

  public List<ManutencaoDto> getComboTipoManutencaoMetal(Long idTpAcao) {
    log.trace("Buscando combo de manutencao");
    List<ManutencaoDto> comboTipoManutencao = manutencaoRepository.getComboTipoManutencaoMetal(idTpAcao);
    return comboTipoManutencao;
  }
}
