package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MassivaMetalicaService {
  @Autowired
  MassivaRepository massivaRepository;

  public Optional<List<MassivaMetalicaDto>> getMassivasMetalica() {
    Optional<List<MassivaMetalicaDto>> massivasMetalica = massivaRepository.getMassivasMetalica();
    return massivasMetalica;
  }

  
}
