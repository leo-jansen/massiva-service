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
@Table(name = "TB_ATIVIDADE", schema = "CICOP")
public class Atividade {
  @Id
  @Column(name = "ID")
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
}
