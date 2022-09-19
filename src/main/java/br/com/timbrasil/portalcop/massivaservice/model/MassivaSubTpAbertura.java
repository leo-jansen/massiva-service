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
@Table(name = "TB_MASSIVA_SUB_TP_ABERTURA", schema = "CICOP")
public class MassivaSubTpAbertura {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "SUB_TIPO_ABERTURA")
  private String subTipoAbertura;
}
