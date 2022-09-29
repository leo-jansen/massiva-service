package br.com.timbrasil.portalcop.massivaservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MassivaDetalhadaDto {
  private String ntt;
  private Long idControle;
  private LocalDateTime dataFalha;
  private String equipeResponsavel;
  private String localidade;
  private LocalDateTime dataAcionamento;
  private String tipoAtividade;
  private String cidade;
  private LocalDateTime previsaoAcionamento;
  private String subTipoAbertura;
  private String prioridade;
  private LocalDateTime dataAbertura;
  private Long clientesImpactados;
  private Long clientesIndisponiveis;
  private String tipoTopologia;
  private String detalhesTecnicos;
  private String sintoma;
  private String observacao;
  private List<String> equipamento;
  private List<String> msan;
  private List<String> slot;

  public MassivaDetalhadaDto(String ntt, Long idControle, LocalDateTime dataFalha, String equipeResponsavel,
      String localidade, LocalDateTime dataAcionamento, String tipoAtividade, String cidade,
      LocalDateTime previsaoAcionamento, String subTipoAbertura, String prioridade, LocalDateTime dataAbertura,
      Long clientesImpactados, Long clientesIndisponiveis, String tipoTopologia, String detalhesTecnicos,
      String sintoma, String observacao) {
    this.ntt = ntt;
    this.idControle = idControle;
    this.dataFalha = dataFalha;
    this.equipeResponsavel = equipeResponsavel;
    this.localidade = localidade;
    this.dataAcionamento = dataAcionamento;
    this.tipoAtividade = tipoAtividade;
    this.cidade = cidade;
    this.previsaoAcionamento = previsaoAcionamento;
    this.subTipoAbertura = subTipoAbertura;
    this.prioridade = prioridade;
    this.dataAbertura = dataAbertura;
    this.clientesImpactados = clientesImpactados;
    this.clientesIndisponiveis = clientesIndisponiveis;
    this.tipoTopologia = tipoTopologia;
    this.detalhesTecnicos = detalhesTecnicos;
    this.sintoma = sintoma;
    this.observacao = observacao;
  }
}
