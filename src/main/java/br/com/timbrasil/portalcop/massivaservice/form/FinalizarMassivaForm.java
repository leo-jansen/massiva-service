package br.com.timbrasil.portalcop.massivaservice.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FinalizarMassivaForm {
  @NotBlank @NotEmpty @NotNull
  private Long id;
  @NotBlank @NotEmpty @NotNull
  private String ntt;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime dataNormalizar;
  @NotBlank @NotEmpty @NotNull
  private Long fkEquipeRespnsavel;
  @NotBlank @NotEmpty @NotNull
  private boolean nttFechado;
  @NotBlank @NotEmpty @NotNull
  private String notaFechamento;
  @NotBlank @NotEmpty @NotNull
  private String causaRaiz;
}
