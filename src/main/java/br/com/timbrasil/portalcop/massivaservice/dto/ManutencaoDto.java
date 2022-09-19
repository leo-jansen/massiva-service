package br.com.timbrasil.portalcop.massivaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManutencaoDto {
  private Long idTpManutencao;
  private String descTpManutencao;
  private Long idTpAcao;
  private Long flagInsdisponibilidade;
  private Long minutosIndisponibilidade;
  private Long minutoAtividade;
}
