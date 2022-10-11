package br.com.timbrasil.portalcop.massivaservice.form;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RejeitarMassivaForm {
  private Long id;
  private String ntt;
  private Long idControle;
  private LocalDateTime dataFalha;
  private Long fkEquipeResponsavel;
  private String localidade;
  private LocalDateTime dataAcionamento;
  private String TipoAbertura;
  private LocalDateTime dataPrevisao;
  private Long fkSubTipoAbertura;
  private Long fkPrioridade;
  private LocalDateTime dataAbertura;
  private Long clientesIndisponiveis;
  private String detalheTecnico;
  private String sintoma;
  private String observacao;
}
