package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.model.OttMassivaMetalica;
import br.com.timbrasil.portalcop.massivaservice.repositories.MassivaRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.OttMassivaMetalicaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MassivaMetalicaService {
  @Autowired
  MassivaRepository massivaRepository;

  @Autowired
  OttMassivaMetalicaRepository ottMassivaMetalicaRepository;

  public Optional<List<MassivaMetalicaDto>> getMassivasMetalica() {
    log.trace("Buscando massivas metalicas");
    Optional<List<MassivaMetalicaDto>> massivasMetalica = massivaRepository.getMassivasMetalica();
    return massivasMetalica;
  }

  public List<OttMassivaMetalica> getOttsMassivasMetalica() {
    log.trace("Buscando otts relacionadas a massivas metalicas");
    List<OttMassivaMetalica> otts = ottMassivaMetalicaRepository.findAll();
    return otts;
  }

  
}
