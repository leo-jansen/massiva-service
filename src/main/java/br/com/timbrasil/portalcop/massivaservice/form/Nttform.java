package br.com.timbrasil.portalcop.massivaservice.form;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Nttform {
  @NotBlank @NotEmpty @NotNull
  private String ntt;
  @NotBlank @NotEmpty
  private Long equipeResponsavel;
  @NotBlank @NotEmpty @NotNull
  private String tipoAtividade;
  @NotBlank @NotEmpty @NotNull
  private Long subTipoAbertura;
  @NotBlank @NotEmpty @NotNull
  private Long idControle;
  @NotBlank @NotEmpty @NotNull
  private String localidade;
  @NotBlank @NotEmpty @NotNull
  private Long cidade;
  @NotBlank @NotEmpty @NotNull
  private Long prioridade;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime dataFalha;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime dataAcionamento;
  @NotBlank @NotEmpty @NotNull
  private LocalDateTime previsaoAcionamento;
  @NotBlank @NotEmpty @NotNull
  private Long clientesIndisponiveis;
  @NotBlank @NotEmpty @NotNull
  private String detalhesTecnicos;
  @NotBlank @NotEmpty @NotNull
  private String sintoma;
  @NotBlank @NotEmpty @NotNull
  private String observacao;
  @NotBlank @NotEmpty @NotNull
  private String tipoTopologia;
  private List<String> equipamento;
  private List<String> slot;
}
