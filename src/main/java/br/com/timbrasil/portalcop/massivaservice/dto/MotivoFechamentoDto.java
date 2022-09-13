package br.com.timbrasil.portalcop.massivaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotivoFechamentoDto {
  private Long id;
  private String descMotFechamento;
}
