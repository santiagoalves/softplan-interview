package br.org.siege.softplan.exercicio2.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded =  true)
public class CompositionDTO {

    @EqualsAndHashCode.Include
    private Integer codigoComposicao;
    private String descricaoComposicao;
    private String unidadeComposicao;
    private String tipoItem;
    @EqualsAndHashCode.Include
    private Integer codigoItem;
    private String descricaoItemComposicao;
    private String unidadeItem;
    private String quantidadeComposicao;
    private String valorUnitario;

}
