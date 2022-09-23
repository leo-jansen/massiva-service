package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.AgregadorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.AnelDto;
import br.com.timbrasil.portalcop.massivaservice.dto.BrasDto;
import br.com.timbrasil.portalcop.massivaservice.dto.DistribuidorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MsanDto;
import br.com.timbrasil.portalcop.massivaservice.dto.NovoRegistroNocDto;
import br.com.timbrasil.portalcop.massivaservice.dto.PortaDto;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaService;

@RestController
@RequestMapping("/NOC")
public class MassivaNocController {
  @Autowired
  MassivaService massivaService;

  @GetMapping()
  public ResponseEntity<List<MassivaDto>> getListaMassivas() {
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

  @GetMapping("/msan")
  public ResponseEntity<List<MsanDto>> getMsan(@RequestParam("uf") String uf) {
    List<MsanDto> listaMsan = massivaService.getMsan(uf);
    return ResponseEntity.ok(listaMsan);
  }

  @GetMapping("/agregador")
  public ResponseEntity<List<AgregadorDto>> getAgregador(@RequestParam("uf") String uf) {
    List<AgregadorDto> listaAgregador = massivaService.getAgregador(uf);
    return ResponseEntity.ok(listaAgregador);
  }

  @GetMapping("/distribuidor")
  public ResponseEntity<List<DistribuidorDto>> getDistribuidor(@RequestParam("uf") String uf) {
    List<DistribuidorDto> listaDistribuidor = massivaService.getDistribuidor(uf);
    return ResponseEntity.ok(listaDistribuidor);
  }

  @GetMapping("/bras")
  public ResponseEntity<List<BrasDto>> getBras(@RequestParam("uf") String uf) {
    List<BrasDto> listaBras = massivaService.getbras(uf);
    return ResponseEntity.ok(listaBras);
  }

  @GetMapping("/Anel")
  public ResponseEntity<List<AnelDto>> getAnel(@RequestParam("uf") String uf) {
    List<AnelDto> listaAnel = massivaService.getAnel(uf);
    return ResponseEntity.ok(listaAnel);
  }

  @GetMapping("/porta")
  public ResponseEntity<List<PortaDto>> getPorta() {
    List<PortaDto> listaPorta = massivaService.getPorta();
    return ResponseEntity.ok(listaPorta);
  }
}
