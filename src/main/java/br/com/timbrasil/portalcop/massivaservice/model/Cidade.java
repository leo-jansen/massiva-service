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
@Table(name = "TB_CIDADE", schema = "CICOP")
public class Cidade {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "FK_UF")
  private Long fkUf;
  @Column(name = "FK_USR_MODIFICACAO")
  private Long fkUsrModificado;
  @Column(name = "NOME")
  private String nome;
  @Column(name = "FLAG_ATIVO")
  private Long flagAtivo;
}
