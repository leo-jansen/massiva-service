package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.dto.MotivoFechamentoDto;
import br.com.timbrasil.portalcop.massivaservice.repositories.MotivoFechamentoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MotivoFechamentoService {
  @Autowired
  MotivoFechamentoRepository motivoFechamentoRepository;

  public List<MotivoFechamentoDto> getComboMotivoFechamento(String descAcao) {
    log.trace("Buscando combo de motivo fechamento para a ação " + descAcao);
    List<MotivoFechamentoDto> comboMotivoFechamento = motivoFechamentoRepository.getComboMotivoFechamento(descAcao);
    return comboMotivoFechamento;
  }
}
