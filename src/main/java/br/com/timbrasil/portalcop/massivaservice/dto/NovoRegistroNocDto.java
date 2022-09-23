package br.com.timbrasil.portalcop.massivaservice.dto;

import java.util.List;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaEquipeResp;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaPrioridade;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaSubTpAbertura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovoRegistroNocDto {
  private List<MassivaEquipeResp> massivaEquipeResp;
  private List<UfDto> uf;
  private List<MassivaPrioridade> massivaPrioridade;
  private List<MassivaSubTpAbertura> massivaSubTpAbertura;
}
