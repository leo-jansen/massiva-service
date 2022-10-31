package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.timbrasil.portalcop.massivaservice.dto.*;
import br.com.timbrasil.portalcop.massivaservice.form.*;
import br.com.timbrasil.portalcop.massivaservice.model.OttMassiva;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaService;

@RestController
@RequestMapping("/COP")
public class MassivaCopController {
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

  @GetMapping("/{id}")
  public ResponseEntity<?> getMassiva(@PathVariable("id") Long id) {
    try {
      MassivaDetalhadaDto massivaDetalhadaDto = massivaService.getMassiva(id);
      return ResponseEntity.ok(massivaDetalhadaDto);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/relatorio/{id}")
  public ResponseEntity<List<RelatorioMassivaDto>> getRelatorio(@PathVariable("id") Long id) {
    List<RelatorioMassivaDto> relatorio = massivaService.getRelatorio(id);
    return ResponseEntity.ok(relatorio);
  }

  @PatchMapping("/{idMassiva}/{idSubtipo}")
  public ResponseEntity<?> modifySubtipo(@PathVariable("idMassiva") Long idMassiva,
      @PathVariable("idSubtipo") Long idSubtipo) {
    try {
      massivaService.modifySubtipo(idMassiva, idSubtipo);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @PostMapping("/novo")
  public ResponseEntity<?> postMethodName(@RequestBody Nttform ntt) {
    try {
      massivaService.newNtt(ntt, "F8057991", "COP");
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @GetMapping("/telaInclusao")
  public ResponseEntity<NovoRegistroNocDto> getTelaInclusao() {
    NovoRegistroNocDto telaInclusaoMassiva = massivaService.getTelaInclusaoMassiva();
    return ResponseEntity.ok(telaInclusaoMassiva);
  }

  @GetMapping("/otts")
  public ResponseEntity<List<OttMassiva>> getOttsCampo() {
    List<OttMassiva> ottsCampo = massivaService.getOttsCampo();
    return ResponseEntity.ok(ottsCampo);
  }

  @GetMapping("/encerradas")
  public ResponseEntity<List<MassivaDto>> getMassivasEncerradas() {
    List<MassivaDto> massivaEncerradas = massivaService.getMassivaEncerradas();
    return ResponseEntity.ok(massivaEncerradas);
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

  @GetMapping("/portasTeste/{msan}")
  public ResponseEntity<List<CircuitDto>> getPortaTeste(@PathVariable("msan") String msan) {
    List<CircuitDto> portasTeste = massivaService.getPortasTeste(msan);
    return ResponseEntity.ok(portasTeste);
  }
}
