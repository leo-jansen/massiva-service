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
@Table(name = "COP_APP_METAL_AREA", schema = "CICOP")
public class Area {
  @Id
  @Column(name = "ID_AREA")
  @SequenceGenerator(name = "area", sequenceName = "SQ_AREA", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area")
	private int id;
	@Column(name = "DESC_AREA")
	private String descArea;
}
