package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaMetalicaService;

@RestController
@RequestMapping("/metalica")
public class MassivaMetalicaController {
  @Autowired
  MassivaMetalicaService massivaMetalicaService;

  @GetMapping
  public ResponseEntity<List<MassivaMetalicaDto>> getMassivasMetalica() {
    List<MassivaMetalicaDto> massivasMetalica = massivaMetalicaService.getMassivasMetalica();
    if (massivasMetalica.size() > 0) {
      return ResponseEntity.ok(massivasMetalica);
    } 
    return ResponseEntity.noContent().build();
  }
}
