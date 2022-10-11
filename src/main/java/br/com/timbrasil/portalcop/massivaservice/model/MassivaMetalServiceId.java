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
@Table(name = "COP_APP_METAL_MASS_SERVICEID", schema = "CICOP")
public class MassivaMetalServiceId {
  @Id
  @SequenceGenerator(name = "TB_METAL_MASS_SERVICEID_ID_GENERATOR", sequenceName = "CICOP.SQ_APP_METAL_MASS_SERVICEID", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_METAL_MASS_SERVICEID_ID_GENERATOR")
  private Long id;
  @Column(name = "FK_METAL_MASSIVA", nullable = false)
  private Long fkMetalMassiva;
  @Column(name = "SERVICEID", nullable = false)
  private String serviceid;
  @Column(name = "NRM_MDF")
  private String nrmMdf;
  @Column(name = "SGF_CAIXA")
  private String sgfCaixa;
  @Column(name = "SGF_PAR")
  private String sgfPar;
  @Column(name = "BSS_STATUS_BANDA_LARGA")
  private String bssStatusBandaLarga;
}
