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
@Table(name = "COP_APP_METAL_MOT_FECHAMENTO", schema = "CICOP")
public class MotivoFechamento {
  @Id
  @Column(name = "ID_MOT_FECHAMENTO")
  private Long idMotFechamento;
  @Column(name = "DESC_MOT_FECHAMENTO")
  private String descMotFechamento;
  @Column(name = "ID_TP_ACAO")
  private Long idTpAcao;
  @Column(name = "FLAG_ATIVO")
  private Long flagAtivo;
}
