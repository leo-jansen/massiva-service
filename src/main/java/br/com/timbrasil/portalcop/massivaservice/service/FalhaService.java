package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.model.Falha;
import br.com.timbrasil.portalcop.massivaservice.repositories.FalhaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FalhaService {
  @Autowired
  FalhaRepository falhaRepository;

  public List<Falha> getComboFalha() {
    log.trace("Buscando combo de falha(id e descrição)");
    return falhaRepository.findAll();
  }
}
