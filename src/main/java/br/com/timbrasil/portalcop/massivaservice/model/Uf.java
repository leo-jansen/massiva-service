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
@Table(name = "TB_UF", schema = "CICOP")
public class Uf {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "FK_USR_MODIFICACAO")
  private Long fkUsrModificado;
  @Column(name = "SIGLA")
  private String sigla;
  @Column(name = "NOME")
  private String nome;
  @Column(name = "FLAG_ATIVO")
  private Long flagAtivo;
}
