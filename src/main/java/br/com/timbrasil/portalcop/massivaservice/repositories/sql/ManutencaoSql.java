package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class ManutencaoSql {
  public static final String GET_LIST_TIPO_MANUTENCAO = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.ManutencaoDto(
        m.id,
        m.descManutencao,
        m.idAcao,
        m.flagIndisponibilidade,
        m.minutosIndisponibilidade,
        m.minutoAtividade
      )
    FROM
      Manutencao m
    WHERE
      m.idAcao = :idTpAcao
      AND m.flagAtivo = 1
    ORDER BY
      m.descManutencao
  """;
}
