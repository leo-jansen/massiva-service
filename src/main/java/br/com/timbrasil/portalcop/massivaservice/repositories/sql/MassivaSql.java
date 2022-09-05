package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class MassivaSql {
  public static final String GET_MASSIVAS_METALICO = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto(
        A.id, A.idMassiva, A.idTpAcao, B.descAcao,
        (
          CASE
            WHEN A.idTpAcao = 1 THEN TO_CHAR(A.dataAbertura, 'dd/mm/yyyy hh24:mi:ss')
            ELSE TO_CHAR (
              A.dataManutencaoProg,
              'dd/mm/yyyy hh24:mi:ss'
            )
          END
        ),
        A.tipo, A.status, A.msan, A.parInicio, A.parFim, A.uf, A.cidade, A.idTpFalha,
        (
          CASE
            WHEN A.idTpFalha = 0 THEN C.descManutencao
            ELSE D.descFalha
          END
        ),
        A.idArea, E.descArea, A.prazo,
        (
          CASE
            WHEN A.tipo = 'S' THEN (
              CASE
                WHEN SYSDATE >= (A.dataAbertura + (1 / 12)) THEN 'S'
                WHEN SYSDATE >= (A.dataAbertura + (1 / 24 * 1.5)) THEN 'A1'
                WHEN SYSDATE >= (A.dataAbertura + (1 / 24)) THEN 'A2'
                ELSE 'N'
              END
            )
            ELSE (
              CASE
                WHEN SYSDATE > (A.prazo) THEN 'S'
                WHEN SYSDATE > (A.prazo - (1 / 24)) THEN 'A1'
                WHEN SYSDATE > (A.prazo - (2 / 24)) THEN 'A2'
                ELSE 'N'
              END
            )
          END
        ),
        A.empreiteira,
        NVL2(TO_CHAR(A.quantClientes), '?'),
        TO_CHAR (
          A.dataIniIndisp,
          'dd/mm/yyyy hh24:mi:ss'
        ),
        TO_CHAR (
          dataFimIndisp,
          'dd/mm/yyyy hh24:mi:ss'
        ),
        NVL(C.flagIndisponibilidade, 1),
        A.observacao
      )
    FROM
      Massiva A
      JOIN Acao B ON B.id = A.idTpAcao
      LEFT JOIN Manutencao C ON C.id = A.idTpManutencao
      LEFT JOIN Falha D ON D.id = A.idTpFalha
      JOIN Area E ON E.id = A.idArea
    WHERE
      A.status = 0
    ORDER BY
      A.dataAbertura  
  """;
}
