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
@Table(name = "TB_MODULO_ESTADO", schema = "CICOP")
public class ModuloEstado {
  @Id
  @Column(name = "ID")
  private Long id;
  @Column(name = "FK_MODULO")
  private Long fkModulo;
  @Column(name = "NOME_ESTADO")
  private String nomeEstado;
  @Column(name = "DESC_ESTADO")
  private String descEstado;
  @Column(name = "REF_ESTADO")
  private String refEstado;
}
