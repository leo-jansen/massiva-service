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
@Table(name = "TB_ATIVIDADE_TIPO", schema = "CICOP")
public class AtividadeTipo {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "NOME_ATIVIDADE")
  private String nomeAtividade;
  @Column(name = "DESC_ATIVIDADE")
  private String descAtividade;
  @Column(name = "TB_NAME")
  private String tbName;
  @Column(name = "FK_MODULO")
  private Long fkModulo;
}
