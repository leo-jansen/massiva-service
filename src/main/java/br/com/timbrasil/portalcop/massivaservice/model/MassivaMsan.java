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
@Table(name = "TB_MASSIVA_MSAN", schema = "CICOP")
public class MassivaMsan {
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "TB_MASSIVA_EQUIPAMENTO_ID_GENERATOR", sequenceName = "CICOP.SQ_MASSIVA_EQUIPAMENTO", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_MASSIVA_EQUIPAMENTO_ID_GENERATOR")
  private Long id;
  @Column(name = "FK_MASSIVA")
  private Long fkMassiva;
  @Column(name = "ANEL")
  private String anel;
  @Column(name = "MSAN")
  private String msan;
  @Column(name = "GABINETE")
  private String gabinete;

  public MassivaMsan(Long fkMsassiva, String anel, String msan, String gabinete){
    this.fkMassiva = fkMsassiva;
    this.anel = anel;
    this.msan = msan;
    this.gabinete = gabinete;
  }
}
