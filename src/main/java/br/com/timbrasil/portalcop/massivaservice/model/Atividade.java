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
@Table(name = "TB_ATIVIDADE", schema = "CICOP")
public class Atividade {
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "TB_ATIVIDADE_ID_GENERATOR", sequenceName = "CICOP.SQ_ATIVIDADE_ID_ATIVIDADE", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_ATIVIDADE_ID_GENERATOR")
  private Long id;
  @Column(name = "DT_ABERTURA")
  private LocalDateTime dtAbertura;
  @Column(name = "DT_ULT_MODIFICACAO")
  private LocalDateTime dtUltModificacao;
  @Column(name = "FK_USR_ULT_MODIFICACAO")
  private Long fkUsrUltModificado;
  @Column(name = "FK_STATUS")
  private Long fkStatus;
  @Column(name = "FK_ATIVIDADE_TIPO")
  private Long fkAtividadeTipo;
  @Column(name = "FK_USR_ABERTURA")
  private Long fkUsrAbertura;

  public Atividade(Long fkUsrUltModificado, Long fkStatus, Long fkAtividadeTipo, Long fkUsrAbertura) {
    this.dtAbertura = LocalDateTime.now();
    this.dtUltModificacao = LocalDateTime.now();
    this.fkUsrUltModificado = fkUsrUltModificado;
    this.fkStatus = fkStatus;
    this.fkAtividadeTipo = fkAtividadeTipo;
    this.fkUsrAbertura = fkUsrAbertura;
  }
}
