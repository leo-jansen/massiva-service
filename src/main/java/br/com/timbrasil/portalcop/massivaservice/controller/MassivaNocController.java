package br.com.timbrasil.portalcop.massivaservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timbrasil.portalcop.massivaservice.dto.AgregadorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.AnelDto;
import br.com.timbrasil.portalcop.massivaservice.dto.BrasDto;
import br.com.timbrasil.portalcop.massivaservice.dto.DistribuidorDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDetalhadaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MsanDto;
import br.com.timbrasil.portalcop.massivaservice.dto.NovoRegistroNocDto;
import br.com.timbrasil.portalcop.massivaservice.dto.PortaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.RelatorioMassivaDto;
import br.com.timbrasil.portalcop.massivaservice.form.FinalizarMassivaForm;
import br.com.timbrasil.portalcop.massivaservice.form.Nttform;
import br.com.timbrasil.portalcop.massivaservice.form.RejeitarMassivaForm;
import br.com.timbrasil.portalcop.massivaservice.service.MassivaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  @PostMapping("/finalizar")
  public ResponseEntity<?> closeMassiva(@RequestBody @Valid FinalizarMassivaForm finalizarMassivaForm) {
    try {
      massivaService.closeMassiva("", finalizarMassivaForm);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @PostMapping("/rejeitar/{id}")
  public ResponseEntity<?> rejectMassiva(@PathVariable("id") Long id, @RequestParam("motivo") String motivo) {
    try {
      massivaService.rejectMassiva(id, motivo, "");
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @PatchMapping("/aceitar")
  public ResponseEntity<?> acceptedMassiva(@RequestBody @Valid RejeitarMassivaForm rejeitarMassivaForm) {
    try {
      massivaService.aceitarMassiva(rejeitarMassivaForm, "", "NOC");
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
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

  @PostMapping("/novo")
  public ResponseEntity<?> postMethodName(@RequestBody Nttform ntt) {
    try {
      massivaService.newNtt(ntt, "", "NOC");
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

}
