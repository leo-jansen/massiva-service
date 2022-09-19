package br.com.timbrasil.portalcop.massivaservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_MASSIVA", schema = "CICOP")
public class Massiva {
  @Id
  @Column(name = "ID")
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
}
