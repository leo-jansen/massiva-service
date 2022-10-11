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
@Table(name = "TB_MASSIVA_SLOT", schema = "CICOP")
public class MassivaSlot {
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "TB_MASSIVA_SLOT_ID_GENERATOR", sequenceName = "CICOP.SQ_MASSIVA_SLOT", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MASSIVA_SLOT_ID_GENERATOR")
  private Long id;
  @Column(name = "FK_MASSIVA")
  private Long fkMassiva;
  @Column(name = "SLOT")
  private String slot;

  public MassivaSlot(Long fkMassiva, String slot) {
    this.fkMassiva = fkMassiva;
    this.slot = slot;
  }
}
