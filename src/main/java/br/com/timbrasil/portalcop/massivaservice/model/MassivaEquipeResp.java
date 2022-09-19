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
@Table(name = "TB_MASSIVA_EQUIPE_RESP", schema = "CICOP")
public class MassivaEquipeResp {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "EQUIPE_RESPONSAVEL")
  private String equipeResponsavel;
}
