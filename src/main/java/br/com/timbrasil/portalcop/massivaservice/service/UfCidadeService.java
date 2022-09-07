package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.repositories.UfCidadeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UfCidadeService {
  @Autowired
  UfCidadeRepository ufCidadeRepository;

  public List<String> getUf() {
    log.trace("Buscando Uf");
    List<String> ufs = ufCidadeRepository.getComboUfs();
    return ufs;
  }

  public List<String> getComboCidade(String cidade) {
    log.trace("buscando cidade para uf " + cidade);
    List<String> comboCidade = ufCidadeRepository.getComboCidade(cidade);
    return comboCidade;
  }

}
