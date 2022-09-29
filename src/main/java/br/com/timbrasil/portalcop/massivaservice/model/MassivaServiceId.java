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
@Table(name = "TB_MASSIVA_SERVICEID", schema = "CICOP")
public class MassivaServiceId {
  @Id
  private Long id;
  @Column(name = "FK_MSAN_MASSIVA")
  private Long fkMsanMassiva;
  @Column(name = "SERVICEID")
  private String serviceId;
}
