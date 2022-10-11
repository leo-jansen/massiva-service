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
@Table(name = "COP_APP_METAL_TP_MANUTENCAO", schema = "CICOP")
public class Manutencao {
  @Id
  @Column(name = "ID_TP_MANUTENCAO")
  @SequenceGenerator(name = "manutencao", sequenceName = "cicop.sq_tp_manutencao", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manutencao")
  private Long id;
  @Column(name = "DESC_TP_MANUTENCAO")
  private String descManutencao;
  @Column(name = "ID_TP_ACAO")
  private Long idAcao;
  @Column(name = "FLAG_INDISPONIBILIDADE")
  private Long flagIndisponibilidade;
  @Column(name = "MINUTOS_INDISPONIBILIDADE")
  private Long minutosIndisponibilidade;
  @Column(name = "MINUTOS_ATIVIDADE")
  private Long minutoAtividade;
  @Column(name = "FLAG_ATIVO")
  private Long flagAtivo;
}
