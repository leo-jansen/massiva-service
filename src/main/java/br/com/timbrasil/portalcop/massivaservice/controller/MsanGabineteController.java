package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.service.MsanGabineteService;

@RestController
@RequestMapping("/msan")
public class MsanGabineteController {
  @Autowired
  MsanGabineteService msanGabineteService;

  @GetMapping("/{cidade}")
  public ResponseEntity<List<String>> getComboCidade(@PathVariable("cidade") String cidade) {
    List<String> comboMsan = msanGabineteService.getComboMsan(cidade);
    return ResponseEntity.ok(comboMsan);
  }
}
