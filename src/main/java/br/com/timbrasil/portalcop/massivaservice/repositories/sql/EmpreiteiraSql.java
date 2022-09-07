package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class EmpreiteiraSql {
  public static final String GET_LIST_EMPREITEIRA = """
  SELECT
    new br.com.timbrasil.portalcop.massivaservice.dto.EmpreiteiraDto(
      e.id,
      e.nomeEmpreiteira
    )
  FROM
    Empreiteira e
  WHERE
    e.empreiteiraAtiva = 1
  ORDER BY
    e.id
  """;
}
