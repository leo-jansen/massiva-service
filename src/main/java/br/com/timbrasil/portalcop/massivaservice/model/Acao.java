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
@Table(name = "COP_APP_METAL_TP_ACAO", schema = "CICOP")
public class Acao {
  @Id
	@Column(name = "ID_TP_ACAO")
	private Long id;
	@Column(name = "DESC_TP_ACAO")
	private String descAcao;
}
