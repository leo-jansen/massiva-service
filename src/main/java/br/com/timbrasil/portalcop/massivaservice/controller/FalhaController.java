package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.model.Falha;
import br.com.timbrasil.portalcop.massivaservice.service.FalhaService;

@RestController
@RequestMapping("/falha")
public class FalhaController {
  @Autowired
  FalhaService falhaService;

  @GetMapping
  public ResponseEntity<List<Falha>> getComboFalha() {
    List<Falha> comboFalha = falhaService.getComboFalha();
    return ResponseEntity.ok(comboFalha);
  }
}
