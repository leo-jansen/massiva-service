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
  private String tipo;
  @NotBlank @NotEmpty @NotNull
  private String parInicio;
  @NotBlank @NotEmpty @NotNull
  private String parFim;
  @NotBlank @NotEmpty @NotNull
  private String observacao;
  private Long idTpArea;
  private Long idTpFalha;
  private LocalDateTime prazo;
  private String empreiteira;
  private Long idTpManutencao;
  private LocalDateTime dataIniIndisp;
  private LocalDateTime dataFimIndisp;
  private LocalDateTime dtIniManutencao;
  private String fileId;
}
