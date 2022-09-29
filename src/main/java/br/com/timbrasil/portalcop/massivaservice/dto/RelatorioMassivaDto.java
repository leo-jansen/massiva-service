package br.com.timbrasil.portalcop.massivaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioMassivaDto {
  private String serviceId;
  private String msan;
  private String ntt;
}
