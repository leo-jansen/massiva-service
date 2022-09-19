package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MassivaService {
  @Autowired
  MassivaRepository massivaRepository;

  public List<MassivaDto> getListaMassivas() {
    log.info("Buscando lista de Massivas");
    List<MassivaDto> listaMassivas = massivaRepository.getListaMassivas();
    return listaMassivas;
  }
}
