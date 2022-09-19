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
@Table(name = "TB_MASSIVA_TP_TOPOLOGIA", schema = "CICOP")
public class MassivaTpTopologia {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "TOPOLOGIA")
  private String topologia;
}
