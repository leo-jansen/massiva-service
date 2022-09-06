package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.model.OttMassivaMetalica;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaMetalicaService;

@RestController
@RequestMapping("/metalica")
public class MassivaMetalicaController {
  @Autowired
  MassivaMetalicaService massivaMetalicaService;

  @GetMapping
  public ResponseEntity<List<MassivaMetalicaDto>> getMassivasMetalica() {
    Optional<List<MassivaMetalicaDto>> massivasMetalica = massivaMetalicaService.getMassivasMetalica();
    if (massivasMetalica.isPresent()) {
      return ResponseEntity.ok(massivasMetalica.get());
    } 
    return ResponseEntity.noContent().build();
  }

  @GetMapping("otts")
  public ResponseEntity<List<OttMassivaMetalica>> getOttsMassivasMetalica() {
    List<OttMassivaMetalica> otts = massivaMetalicaService.getOttsMassivasMetalica();
    return ResponseEntity.ok(otts);
  }
}
