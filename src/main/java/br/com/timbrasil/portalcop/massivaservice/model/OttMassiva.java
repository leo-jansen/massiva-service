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
@Table(name = "VW_GET_OTT_ABERTOS_POR_MASSIVA", schema = "CICOP")
public class OttMassiva {
  @Id
  @Column(name = "OTT")
  public String ott;
  @Column(name = "MOTIVO_ABERTURA")
  public String motivoAbertura;
  @Column(name = "SERVICE_ID")
  public String serviceId;
  @Column(name = "BUCKET")
  public String bucket;
  @Column(name = "STATUS_TOA")
  public String statusToa;
  @Column(name = "UF")
  public String uf;
  @Column(name = "ID_MASSIVA")
  public String idMassiva;
}
