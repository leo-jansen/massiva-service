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
@Table(name = "TB_MODULO", schema = "CICOP")
public class Modulo {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "MODULO_NAME")
  private String moduloName;
  @Column(name = "MODULO_DESC")
  private String moduloDesc;
  @Column(name = "FK_APP")
  private Long fkApp;
  @Column(name = "MATRICULA")
  private String matricula;
}
