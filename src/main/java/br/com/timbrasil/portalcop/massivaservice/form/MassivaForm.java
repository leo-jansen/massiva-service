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
public class MassivaForm {
  @NotBlank @NotEmpty @NotNull
  private String tipoAcao;
  @NotBlank @NotEmpty @NotNull
  private String uf;
  @NotBlank @NotEmpty @NotNull
  private String cidade;
  @NotBlank @NotEmpty @NotNull
  private String msan;
  @NotBlank @NotEmpty @NotNull
  private Long parInicio;
  @NotBlank @NotEmpty @NotNull
  private Long parFim;
  @NotBlank @NotEmpty @NotNull
  private String tipoFalha;
  @NotBlank @NotEmpty @NotNull
  private String origem;
  @NotBlank @NotEmpty @NotNull
  private String empreiteira;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime prazo;
  @NotBlank @NotEmpty @NotNull
  private String observacao;
}
