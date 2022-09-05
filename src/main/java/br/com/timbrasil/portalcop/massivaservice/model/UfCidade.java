package br.com.timbrasil.portalcop.massivaservice.model;

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
@Table(name = "COP_APP_UF_CIDADE", schema = "cicop")
public class UfCidade {
  @Id
  @SequenceGenerator(name = "ufCidade", sequenceName = "sq_uf", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ufCidade")
  private int id;
  @Column(name = "UF")
  private String uf;
  @Column(name = "CIDADE")
  private String cidade;
  @Column(name = "MSAN_COD")
  private String msanCod;
}
