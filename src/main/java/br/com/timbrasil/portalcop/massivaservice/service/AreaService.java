package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.model.Area;
import br.com.timbrasil.portalcop.massivaservice.repositories.AreaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AreaService {
  @Autowired
  AreaRepository areaRepository;

  public List<Area> getComboArea() {
    log.trace("Buscando combo de area(id e descrição)");
    return areaRepository.findAll();
  }
}
