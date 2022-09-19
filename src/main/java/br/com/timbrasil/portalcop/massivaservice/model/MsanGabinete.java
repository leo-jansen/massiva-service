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
@Table(name = "VW_MSAN_GABINETE", schema = "CICOP")
public class MsanGabinete {
  @Id
  @Column(name = "MSAN_GABINETE")
  private String msanGabinete;
  @Column(name = "CIDADE")
  private String cidade;
  @Column(name = "FLAG_EXTERNO")
  private Long flagExterno; 
}
