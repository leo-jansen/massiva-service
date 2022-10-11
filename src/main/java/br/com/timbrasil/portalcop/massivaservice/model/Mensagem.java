package br.com.timbrasil.portalcop.massivaservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_MENSAGEM", schema = "CICOP")
public class Mensagem {
  @Id
  private Long id;
  @Column(name = "TITULO")
  private String titulo;
  @Column(name = "DESCRICAO")
  private String descricao;
  @Column(name = "FK_ATIVIDADE_TIPO")
  private Long fkAtividadeTipo;
  @Column(name = "MSG")
  private String msg;
}
