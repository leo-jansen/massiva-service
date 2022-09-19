package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.model.Acao;
import br.com.timbrasil.portalcop.massivaservice.repositories.AcaoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AcaoService {
  @Autowired
  AcaoRepository acaoRepository;

  public List<Acao> getComboAcao() {
    log.trace("buscando combo de acao(id e descrição)");
    return acaoRepository.findAll();
  }
}
