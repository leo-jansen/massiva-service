package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class MassivaSql {
  public static final String GET_MASSIVAS_METALICO = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto(
        A.id, A.idMassiva, A.idTpAcao, B.descAcao,
        (
          CASE
            WHEN A.idTpAcao = 1 THEN TO_CHAR(A.dataAbertura, 'dd/mm/yyyy hh24:mi:ss')
            ELSE TO_CHAR (A.dataManutencaoProg, 'dd/mm/yyyy hh24:mi:ss')
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
        NVL(TO_CHAR(A.quantClientes), '?'),
        TO_CHAR(A.dataIniIndisp, 'dd/mm/yyyy hh24:mi:ss'),
        TO_CHAR(A.dataFimIndisp, 'dd/mm/yyyy hh24:mi:ss'),
        NVL(C.flagIndisponibilidade, 1),
        A.observacao
      )
    FROM
      MassivaMetal A
      JOIN Acao B ON B.id = A.idTpAcao
      LEFT JOIN Manutencao C ON C.id = A.idTpManutencao
      LEFT JOIN Falha D ON D.id = A.idTpFalha
      JOIN Area E ON E.id = A.idArea
    WHERE
      A.status = 0
    ORDER BY
      A.dataAbertura  
  """;

  public static final String SQL_VERF_MASS_METAL_ABERTA = """
    SELECT
      m
    FROM
      MassivaMetal m
    WHERE
      m.idTpAcao = :idAcao
      AND m.msan = :msan
      AND (
        TO_NUMBER(REPLACE(:parIni, 'MDF-')) BETWEEN TO_NUMBER(REPLACE(m.parInicio, 'MDF-'))
        AND TO_NUMBER(REPLACE(m.parFim, 'MDF-'))
        OR TO_NUMBER(REPLACE(:parFim, 'MDF-')) BETWEEN TO_NUMBER(REPLACE(m.parInicio, 'MDF-'))
        AND TO_NUMBER(REPLACE(m.parFim, 'MDF-'))
      )
      AND m.status = 0    
  """; 

  public static final String SEARCH_OPEN_RMT = """
    SELECT
      m
    FROM
      MassivaMetal m
    WHERE
      m.idTpAcao LIKE 'RMT%'
      AND m.msan = :msan
      AND m.parInicio <= :parIni
      AND m.parFim >= :parFim
      AND STATUS = 0    
  """;
  
  public static final String SQL_GET_CLIENTES_IMPACTADOS = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.Relatorio(
        TB1.idMassiva,
        TB2.serviceid,
        TB2.nrmMdf,
        TB2.sgfCaixa,
        TB2.sgfPar
      )
    FROM
      MassivaMetal TB1
      JOIN MassivaMetalServiceId TB2 ON TB2.fkMetalMassiva = TB1.id
    WHERE
      TB1.id = :id
  """;

  public static final String QUERY_LISTA_MASSIVAS_ABERTAS= """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto(
        TB1.ntt,
        TB2.dtAbertura,
        TB3.nomeAtividade,
        TB4.subTipoAbertura,
        TB5.prioridade,
        CONCAT(TB6.nome, '/', TB7.sigla),
        TB1.dtPrevisao,
        TB1.qtdImpactado,
        TB1.qtdIndisponiveis,
        TB1.id,
        TB10.topologia,
        TB1.qtdElementos,
        TB1.areaAbertura,
        TB9.nomeEstado
      )
    FROM
      Massiva TB1 
      JOIN Atividade TB2 ON TB1.fkAtividade = TB2.id 
      JOIN AtividadeTipo TB3 ON TB2.fkAtividadeTipo = TB3.id
      JOIN MassivaSubTpAbertura TB4 ON TB1.fkSubTipoAbertura = TB4.id
      JOIN MassivaPrioridade TB5 ON TB1.fkPrioridade = TB5.id
      JOIN Cidade TB6 ON TB1.fkCidade = TB6.id
      JOIN Uf TB7 ON TB6.fkUf = TB7.id
      JOIN MassivaTpTopologia TB8 ON TB1.fkTipoTopologia = TB8.id
      JOIN ModuloEstado TB9 ON TB2.fkStatus = TB9.id
      JOIN MassivaTpTopologia TB10 ON TB1.fkTipoTopologia = TB10.id
    WHERE
      TB9.refEstado = 'MS_OPN_ATV' 
    ORDER BY
      TB2.dtAbertura DESC
  """;

  public static final String QUERY_LISTAR_MSANS = """
    SELECT
      DISTINCT MSAN,
      MODELO,
      UF
    FROM
      CICOP.WEBCOP_TOPOLOGIA_REDE TB1,
      CICOP.VW_NRM_TOPOLOGY_NODE_UF TB2
    WHERE
      MSAN = TB2.NODE_NAME
      AND UF =:estado
    ORDER BY
      MSAN    
  """;

  public static final String SQL_GET_AGREGADORES = """
    SELECT
      DISTINCT AGREGADOR,
      UF
    FROM
      CICOP.WEBCOP_TOPOLOGIA_REDE TB1,
      CICOP.VW_NRM_TOPOLOGY_NODE_UF TB2
    WHERE
      AGREGADOR = TB2.NODE_NAME
      AND UF =:estado
    ORDER BY
      AGREGADOR    
  """;

  public static final String QUERY_GET_DISTRIBUIDORES_MASSIVA = """
    SELECT
      DISTINCT DISTRIBUIDOR,
      UF
    FROM
      CICOP.WEBCOP_TOPOLOGIA_REDE TB1,
      CICOP.VW_NRM_TOPOLOGY_NODE_UF TB2
    WHERE
      DISTRIBUIDOR = TB2.NODE_NAME
      AND UF =:estado
    ORDER BY
      DISTRIBUIDOR    
  """;

  public static final String QUERY_GET_BRAS_MASSIVA = """
    SELECT
      DISTINCT BRAS,
      UF
    FROM
      CICOP.WEBCOP_TOPOLOGIA_REDE TB1,
      CICOP.VW_NRM_TOPOLOGY_NODE_UF TB2
    WHERE
      BRAS = TB2.NODE_NAME
      AND UF =:estado
    ORDER BY
      BRAS
  """;

  public static final String QUERY_GET_ANEL_MASSIVA = """
    SELECT
      DISTINCT ANEL,
      UF
    FROM
      CICOP.WEBCOP_TOPOLOGIA_REDE TB1,
      CICOP.VW_NRM_TOPOLOGY_ANEL_UF TB2
    WHERE
      ANEL = TB2.TOPOLOGY
      AND UF =:estado
    ORDER BY
      ANEL
  """;

  public static final String SEARCH_NTT = """
    SELECT
      m
    FROM
      Massiva m
    WHERE
      m.ntt = :ntt
      AND (
        m.flagNttCancelado <> 1
        OR m.flagNttCancelado IS NULL
      )    
  """;

  public static final String QUERY_QTD_CLIENTES_IMPACTADOS = """
    SELECT
      COUNT(*)
    FROM
      CICOP.TB_INF_CADASTRO_CENTRALIZADO
    WHERE
      BSS_STATUS_BANDA_LARGA <> 'Inativo'    
  """;

  public static final String QUERY_INSERT_MASSIVA_SERVICE_ID_SLOT = """
    INSERT INTO
      CICOP.TB_MASSIVA_SERVICEID (ID, FK_MSAN_MASSIVA, SERVICEID)
    SELECT
      CICOP.SQ_MASSIVA_SERVICEID.NEXTVAL AS ID,
      BASE.FK_MSAN_MASSIVA,
      BASE.SERVICEID
    FROM
      (
        SELECT
          DISTINCT MSAN.ID AS FK_MSAN_MASSIVA,
          NRM.SERVICEID
        FROM
          CICOP.STG_INVENTORY_NRM NRM,
          CICOP.TB_MASSIVA_MSAN MSAN,
          CICOP.TB_MASSIVA_SLOT SLOT
        WHERE
          NRM.NODE_NAME = MSAN.MSAN
          AND MSAN.FK_MASSIVA = SLOT.FK_MASSIVA
          AND MSAN.FK_MASSIVA = :idMassiva
          AND SERVICEID IS NOT NULL
          AND CICOP.SPLIT_TEXT(
            CICOP.SPLIT_TEXT(NRM.PORT_NAME, 3, '-'),
            1,
            '/'
          ) = SLOT.SLOT
      ) BASE
  """;

  public static final String QUERY_INSERT_QTD_MASSIVA = """
    UPDATE
      CICOP.TB_MASSIVA
    SET
      QTD_IMPACTADO = (
        SELECT
          COUNT(*) AS QTD
        FROM
          CICOP.TB_MASSIVA_SERVICEID SERVICEID,
          CICOP.TB_MASSIVA_MSAN MSAN
        WHERE
          SERVICEID.FK_MSAN_MASSIVA = MSAN.ID
          AND MSAN.FK_MASSIVA = :fkMassiva
      ),
      QTD_BASE = (
        SELECT
          COUNT(DISTINCT SERVICEID)
        FROM
          CICOP.STG_INVENTORY_NRM
        WHERE
          SERVICEID IS NOT NULL
      )
    WHERE
      ID = :idMassiva
  """;

  public static final String QUERY_INSERT_MASSIVA_SERVICE_ID = """
    INSERT INTO
      CICOP.TB_MASSIVA_SERVICEID (ID, FK_MSAN_MASSIVA, SERVICEID)
    SELECT
      CICOP.SQ_MASSIVA_SERVICEID.NEXTVAL as ID,
      BASE.FK_MSAN_MASSIVA,
      BASE.SERVICEID
    FROM
      (
        SELECT
          DISTINCT MSAN.ID AS FK_MSAN_MASSIVA,
          NRM.SERVICEID
        FROM
          CICOP.STG_INVENTORY_NRM NRM,
          CICOP.TB_MASSIVA_MSAN MSAN
        WHERE
          NRM.NODE_NAME = MSAN.MSAN
          AND MSAN.FK_MASSIVA = :idMassiva
          AND NRM.SERVICEID IS NOT NULL
      ) BASE
  """;

  public static final String QUERY_UPDT_QTD_INDSP = """
    UPDATE
      CICOP.TB_MASSIVA
    SET
      QTD_INDISPONIVEIS = (
        CASE
          WHEN QTD_INDISPONIVEIS is null
          or QTD_INDISPONIVEIS = 0 then QTD_IMPACTADO
          else QTD_INDISPONIVEIS
        end
      )
    WHERE
      ID = :idMassiva
  """;

  public static final String QUERY_BUSCAR_MASSIVA = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.MassivaDetalhadaDto(
        TB1.ntt,
        TB1.controle,
        TB1.dtFalha,
        TB8.equipeResponsavel,
        TB1.localidade,
        TB1.dtAcionamento,
        TB3.nomeAtividade,
        CONCAT(TB6.nome,'/',TB7.sigla),
        TB1.dtPrevisao,
        TB4.subTipoAbertura,
        TB5.prioridade,
        TB2.dtAbertura,
        TB1.qtdImpactado,
        TB1.qtdIndisponiveis,
        TB9.topologia,
        TB1.detalheTecnico,
        TB1.causa,
        TB1.observacao
      ) 
    FROM
      Massiva TB1
      JOIN Atividade TB2 ON TB1.fkAtividade = TB2.id
      JOIN AtividadeTipo TB3 ON TB2.fkAtividadeTipo = TB3.id
      JOIN MassivaSubTpAbertura TB4 ON TB1.fkSubTipoAbertura = TB4.id
      JOIN MassivaPrioridade TB5 ON TB1.fkPrioridade = TB5.id
      JOIN Cidade TB6 ON TB1.fkCidade = TB6.id
      JOIN Uf TB7 ON TB6.fkUf = TB7.id
      LEFT JOIN MassivaEquipeResp TB8 ON TB1.fkEquipeRespAbertura = TB8.id
      JOIN MassivaTpTopologia TB9 ON TB1.fkTipoTopologia = TB9.id
      LEFT JOIN MassivaEquipeResp TB10 ON TB1.fkEquipeRespFechamento = TB10.id
      JOIN ModuloEstado TB11 ON TB2.fkStatus = TB11.id
    WHERE
      TB1.id = :idMassiva
  """;

  public static final String SQL_BUSCAR_SLOTS_MASSIVA_SELECT = """
    SELECT
      m.slot
    FROM
      MassivaSlot m
    WHERE
      m.fkMassiva = :idMassiva
  """;

  public static final String SQL_BUSCAR_EQUIPAMENTOS_MASSIVA_SELECT = """
    SELECT
      m.nodeMassiva
    FROM
      MassivaEquipamento m
    WHERE
      m.fkMassiva = :idMassiva
  """;

  public static final String SQL_BUSCAR_MSANS_MASSIVA_SELECT = """
    SELECT
      m.msan
    FROM
      MassivaMsan m
    WHERE
      m.fkMassiva = :idMassiva    
  """;
}
