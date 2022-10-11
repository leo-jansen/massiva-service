package br.com.timbrasil.portalcop.massivaservice.form;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FinalizarMassivaForm {
  private Long id;
  private String ntt;
  private LocalDateTime dataNormalizar;
  private Long fkEquipeRespnsavel;
  private boolean nttFechado;
  private String notaFechamento;
  private String causaRaiz;
}
