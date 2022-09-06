package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.service.UfCidadeService;

@RestController
@RequestMapping("/uf")
public class UfCidadeController {
  @Autowired
  UfCidadeService ufCidadeService;

  @GetMapping
  public ResponseEntity<List<String>> getUf() {
    List<String> ufs = ufCidadeService.getUf();
    return ResponseEntity.ok(ufs);
  }
}
