package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.ManutencaoDto;
import br.com.timbrasil.portalcop.massivaservice.service.ManutencaoService;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
  @Autowired
  ManutencaoService manutencaoService;

  @GetMapping("/{idTpAcao}")
  public ResponseEntity<List<ManutencaoDto>> getComboTipoManutencaoMetal(@PathVariable("idTpAcao") Long idTpAcao) {
    List<ManutencaoDto> comboTipoManutencao = manutencaoService.getComboTipoManutencaoMetal(idTpAcao);
    return ResponseEntity.ok(comboTipoManutencao);
  }
}
