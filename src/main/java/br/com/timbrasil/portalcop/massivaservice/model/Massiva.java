package br.com.timbrasil.portalcop.massivaservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_MASSIVA", schema = "CICOP")
public class Massiva {
  @Id
  @SequenceGenerator(name = "TB_MASSIVA_ID_GENERATOR", sequenceName = "CICOP.SQ_MASSIVA", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MASSIVA_ID_GENERATOR")
  private Long id;
  @Column(name = "FK_ATIVIDADE")
  private Long fkAtividade;
  @Column(name = "FK_SUB_TIPO_ABERTURA")
  private Long fkSubTipoAbertura;
  @Column(name = "FK_TIPO_TOPOLOGIA")
  private Long fkTipoTopologia;
  @Column(name = "FK_CIDADE")
  private Long fkCidade;
  @Column(name = "FK_EQUIPE_RESP_ABERTURA")
  private Long fkEquipeRespAbertura;
  @Column(name = "FK_EQUIPE_RESP_FECHAMENTO")
  private Long fkEquipeRespFechamento;
  @Column(name = "NTT")
  private String ntt;
  @Column(name = "CONTROLE")
  private Long controle;
  @Column(name = "LOCALIDADE")
  private String localidade;
  @Column(name = "DETALHE_TECNICO")
  private String detalheTecnico;
  @Column(name = "CAUSA")
  private String causa;
  @Column(name = "CAUSA_RAIZ")
  private String causaRaiz;
  @Column(name = "DT_ACIONAMENTO")
  private LocalDateTime dtAcionamento;
  @Column(name = "DT_PREVISAO")
  private LocalDateTime dtPrevisao;
  @Column(name = "DT_FALHA")
  private LocalDateTime dtFalha;
  @Column(name = "FK_PRIORIDADE")
  private Long fkPrioridade;
  @Column(name = "OBSERVACAO")
  private String observacao;
  @Column(name = "NOTA_FECHAMENTO")
  private String notaFechamento;
  @Column(name = "DT_NORMALIZACAO")
  private LocalDateTime dtNormalizacao;
  @Column(name = "MOTIVO_REJEICAO")
  private String motivoRejeicao;
  @Column(name = "QTD_IMPACTADO")
  private Long qtdImpactado;
  @Column(name = "QTD_BASE")
  private Long qtdBase;
  @Column(name = "AREA_ABERTURA")
  private String areaAbertura;
  @Column(name = "QTD_ELEMENTOS")
  private Long qtdElementos;
  @Column(name = "QTD_INDISPONIVEIS")
  private Long qtdIndisponiveis;
  @Column(name = "FLAG_NTT_CANCELADO")
  private Long flagNttCancelado;

  public Massiva(Long fkAtividade, Long fkSubTipoAbertura, Long fkTipoTopologia, Long fkCidade,
      Long fkEquipeRespAbertura, String ntt, Long controle, String localidade, String detalheTecnico, String causa,
      LocalDateTime dtAcionamento, LocalDateTime dtPrevisao, LocalDateTime dtFalha, Long fkPrioridade,
      String observacao, String areaAbertura, Long qtdElementos, Long qtdIndisponiveis) {
    this.fkAtividade = fkAtividade;
    this.fkSubTipoAbertura = fkSubTipoAbertura;
    this.fkTipoTopologia = fkTipoTopologia;
    this.fkCidade = fkCidade;
    this.fkEquipeRespAbertura = fkEquipeRespAbertura;
    this.ntt = ntt;
    this.controle = controle;
    this.localidade = localidade;
    this.detalheTecnico = detalheTecnico;
    this.causa = causa;
    this.dtAcionamento = dtAcionamento;
    this.dtPrevisao = dtPrevisao;
    this.dtFalha = dtFalha;
    this.fkPrioridade = fkPrioridade;
    this.observacao = observacao;
    this.areaAbertura = areaAbertura;
    this.qtdElementos = qtdElementos;
    this.qtdIndisponiveis = qtdIndisponiveis;
  }
}
