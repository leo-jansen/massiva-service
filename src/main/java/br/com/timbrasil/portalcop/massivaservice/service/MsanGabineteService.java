package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.repositories.MsanGabineteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MsanGabineteService {
  @Autowired
  MsanGabineteRepository msanGabineteRepository;

  public List<String> getComboMsan(String cidade) {
    log.trace("Buscando Msan por cidade " + cidade);
    Optional<List<String>> comboMsanByCidade = msanGabineteRepository.getComboMsanByCidade(cidade);
    if (comboMsanByCidade.isPresent()) {
      return comboMsanByCidade.get();
    }
    log.trace("Não existe msan para a cidade " + cidade);
    return List.of();
  }
}
