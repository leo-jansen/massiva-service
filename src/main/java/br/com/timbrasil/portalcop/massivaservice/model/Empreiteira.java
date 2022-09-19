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
@Table(name = "COP_APP_METAL_EMPREITEIRAS", schema = "CICOP")
public class Empreiteira {
  @Id
  @SequenceGenerator(name = "empreiteira", sequenceName = "SQ_EMPREITEIRA", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empreiteira")
  private Long id;
  @Column(name = "NOME_EMPREITEIRA")
  private String nomeEmpreiteira;
  @Column(name = "EMPREITEIRA_ATIVA")
  private Long empreiteiraAtiva;
}
