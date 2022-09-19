package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class MotivoFechamentoSql {
  public static final String GET_LIST_MOTIVO_FECHAMENTO = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.MotivoFechamentoDto(
        MOT_FECHAMENTO.idTpAcao,
        MOT_FECHAMENTO.descMotFechamento
      )
    FROM
      MotivoFechamento MOT_FECHAMENTO
      JOIN Acao TP_ACAO ON MOT_FECHAMENTO.idTpAcao = TP_ACAO.id
    WHERE
      TP_ACAO.descAcao = :descAcao
      AND MOT_FECHAMENTO.flagAtivo = 1
    ORDER BY
      MOT_FECHAMENTO.idMotFechamento   
  """;
}
