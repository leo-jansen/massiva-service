package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.EmpreiteiraDto;
import br.com.timbrasil.portalcop.massivaservice.service.EmpreiteiraService;

@RestController
@RequestMapping("/empreiteira")
public class EmpreiteiraController {
  @Autowired
  EmpreiteiraService empreiteiraService;

  @GetMapping
  public ResponseEntity<List<EmpreiteiraDto>> getComboEmpreiteira() {
    List<EmpreiteiraDto> comboEmpreiteira = empreiteiraService.getComboEmpreiteira();
    return ResponseEntity.ok(comboEmpreiteira);
  }
}
