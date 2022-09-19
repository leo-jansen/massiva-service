package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.EmpreiteiraDto;
import br.com.timbrasil.portalcop.massivaservice.repositories.EmpreiteiraRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpreiteiraService {
  @Autowired
  EmpreiteiraRepository empreiteiraRepository;

  public List<EmpreiteiraDto> getComboEmpreiteira() {
    log.trace("Buscando Empreiteira ativas (id e nome da empreiteira)");
    List<EmpreiteiraDto> empreiteirasAtiva = empreiteiraRepository.getEmpreiteiraByAtiva();
    return empreiteirasAtiva;
  }
}
