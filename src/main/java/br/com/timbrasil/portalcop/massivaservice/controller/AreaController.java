package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.model.Area;
import br.com.timbrasil.portalcop.massivaservice.service.AreaService;

@RestController
@RequestMapping("/area")
public class AreaController {
  @Autowired
  AreaService areaService;

  @GetMapping
  public ResponseEntity<List<Area>> getComboArea() {
    List<Area> comboArea = areaService.getComboArea();
    return ResponseEntity.ok(comboArea);
  }
}
