package br.com.timbrasil.portalcop.massivaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircuitDto {
  private String nodename;
  private int slot;
  private int porta;
  private boolean habilitada;
}
