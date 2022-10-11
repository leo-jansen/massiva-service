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
@Table(name = "TB_PORTA_DE_TESTE", schema = "CICOP")
public class Porta {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "FK_MODELO")
  private Long fkModelo;
  @Column(name = "SLOT")
  private Long slot;
  @Column(name = "PORTA")
  private Long porta;
}
