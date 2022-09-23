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
  private List<MassivaEquipeResp> listaMassivaEquipeResp;
  private List<UfDto> listaUf;
  private List<MassivaPrioridade> listaMassivaPrioridade;
  private List<MassivaSubTpAbertura> listaMassivaSubTpAbertura;
  private List<MsanDto> listaMsan;
  private List<AgregadorDto> listAgregador;
  private List<DistribuidorDto> listDistribuidor;
  private List<BrasDto> listBras;
  private List<AnelDto> listAnel;
  private List<PortaDto> listPorta;
}
