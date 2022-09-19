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
@Table(name = "COP_APP_METAL_TP_FALHA", schema = "CICOP")
public class Falha {
  @Id
	@Column(name = "ID_TP_FALHA")
	private Long id;
	@Column(name = "DESC_TP_FALHA")
	private String descFalha;
}
