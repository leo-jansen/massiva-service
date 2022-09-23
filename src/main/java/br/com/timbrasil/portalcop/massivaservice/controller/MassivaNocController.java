package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.NovoRegistroNocDto;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaService;

@RestController
@RequestMapping("/NOC")
public class MassivaNocController {
  @Autowired
  MassivaService massivaService;

  @GetMapping()
  public ResponseEntity<List<MassivaDto>> getListaMassivas(){
    List<MassivaDto> listaMassivas = massivaService.getListaMassivas();
    if (listaMassivas.isEmpty()) {
      return ResponseEntity.ok(List.of());
    }
    return ResponseEntity.ok(listaMassivas);
  }

  @GetMapping("/telaInclusao")
  public ResponseEntity<NovoRegistroNocDto> getTelaInclusao() {
    NovoRegistroNocDto telaInclusaoMassiva = massivaService.getTelaInclusaoMassiva();
    return ResponseEntity.ok(telaInclusaoMassiva);
  }
}
