package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class TopologiaSql {
  public static final String SELECT_ANEL_MSAN_GABINETE_BY_MSAN = """
    SELECT
      T.ANEL,
      T.MSAN,
      T.GABINETE
    FROM
      (
        SELECT
          MSAN,
          GABINETE,
          LISTAGG(ANEL, ', ') WITHIN GROUP (
            ORDER BY
              ANEL
          ) ANEL
        FROM
          CICOP.WEBCOP_TOPOLOGIA_REDE
        WHERE
          MSAN = :msan
        GROUP BY
          MSAN,
          GABINETE
      ) T    
  """;

  public static final String SELECT_ANEL_MSAN_GABINETE_BY_LIST_MSAN = """
    SELECT
      T.ANEL,
      T.MSAN,
      T.GABINETE
    FROM
      (
        SELECT
          MSAN,
          GABINETE,
          LISTAGG(ANEL, ', ') WITHIN GROUP (
            ORDER BY
              ANEL
          ) ANEL
        FROM
          CICOP.WEBCOP_TOPOLOGIA_REDE
        WHERE
          MSAN in (:listMsan)
        GROUP BY
          MSAN,
          GABINETE
      ) T     
  """;

  public static final String SELECT_ANEL_MSAN_GABINETE_BY_LIST_AGREGADOR = """
    SELECT
      T.ANEL,
      T.MSAN,
      T.GABINETE
    FROM
      (
        SELECT
          MSAN,
          GABINETE,
          LISTAGG(ANEL, ', ') WITHIN GROUP (
            ORDER BY
              ANEL
          ) ANEL
        FROM
          CICOP.WEBCOP_TOPOLOGIA_REDE
        WHERE
          AGREGADOR in (:listAgregador)
        GROUP BY
          MSAN,
          GABINETE
      ) T     
  """;

  public static final String SELECT_ANEL_MSAN_GABINETE_BY_LIST_DISTRIBUIDOR = """
    SELECT
      T.ANEL,
      T.MSAN,
      T.GABINETE
    FROM
      (
        SELECT
          MSAN,
          GABINETE,
          LISTAGG(ANEL, ', ') WITHIN GROUP (
            ORDER BY
              ANEL
          ) ANEL
        FROM
          CICOP.WEBCOP_TOPOLOGIA_REDE
        WHERE
          DISTRIBUIDOR in (:listDistribuidor)
        GROUP BY
          MSAN,
          GABINETE
      ) T     
  """;

  public static final String SELECT_ANEL_MSAN_GABINETE_BY_LIST_BRAS = """
    SELECT
      T.ANEL,
      T.MSAN,
      T.GABINETE
    FROM
      (
        SELECT
          MSAN,
          GABINETE,
          LISTAGG(ANEL, ', ') WITHIN GROUP (
            ORDER BY
              ANEL
          ) ANEL
        FROM
          CICOP.WEBCOP_TOPOLOGIA_REDE
        WHERE
          BRAS in (:listBras)
        GROUP BY
          MSAN,
          GABINETE
      ) T     
  """;
}
