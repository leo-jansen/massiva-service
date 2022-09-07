package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.model.Acao;
import br.com.timbrasil.portalcop.massivaservice.service.AcaoService;

@RestController
@RequestMapping("/acao")
public class AcaoController {
  @Autowired
  AcaoService acaoService;

  @GetMapping
  public ResponseEntity<List<Acao>> getComboArea() {
    List<Acao> comboAcao = acaoService.getComboAcao();
    return ResponseEntity.ok(comboAcao);
  }
}
