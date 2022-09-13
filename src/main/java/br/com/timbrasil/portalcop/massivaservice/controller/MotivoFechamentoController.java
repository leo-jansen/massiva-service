package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.MotivoFechamentoDto;
import br.com.timbrasil.portalcop.massivaservice.service.MotivoFechamentoService;

@RestController
@RequestMapping("/motivoFechamento")
public class MotivoFechamentoController {
  @Autowired
  MotivoFechamentoService motivoFechamentoService;

  @GetMapping("/{descAcao}")
  public ResponseEntity<List<MotivoFechamentoDto>> getComboFechamento(@PathVariable("descAcao") String descAcao) {
    List<MotivoFechamentoDto> comboMotivoFechamento = motivoFechamentoService.getComboMotivoFechamento(descAcao);
    return ResponseEntity.ok(comboMotivoFechamento);
  }
}
