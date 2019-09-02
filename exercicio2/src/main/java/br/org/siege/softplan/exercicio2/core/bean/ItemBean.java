package br.org.siege.softplan.exercicio2.core.bean;

import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.util.BigDecimalUtils;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemBean {

    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer codigo;
    private String descricao;
    private String tipo;
    private String unidade;
    @ToString.Include
    private String quantidade;
    @ToString.Include
    private String valor;

    @Setter
    @ToString.Include
    private BigDecimal custo;

    public ItemBean(CompositionDTO compositionDTO) {
        this.codigo = compositionDTO.getCodigoItem();
        this.descricao = compositionDTO.getDescricaoItemComposicao();
        this.tipo = compositionDTO.getTipoItem();
        this.unidade = compositionDTO.getUnidadeItem();
        this.valor = compositionDTO.getValorUnitario();
        this.quantidade = compositionDTO.getQuantidadeComposicao();
    }

    public static ItemBean instanceComposicao(CompositionDTO compositionDTO) {
        ItemBean itemBean = new ItemBean();
        itemBean.codigo = compositionDTO.getCodigoItem();
        itemBean.tipo = compositionDTO.getTipoItem();
        itemBean.unidade = compositionDTO.getUnidadeItem();
        itemBean.quantidade = compositionDTO.getQuantidadeComposicao();
        return itemBean;
    }

    public static ItemBean instanceCompositionItem(CompositionDTO compositionDTO) {
        ItemBean itemBean = new ItemBean();
        itemBean.codigo = compositionDTO.getCodigoComposicao();
        itemBean.descricao = compositionDTO.getDescricaoComposicao();
        itemBean.unidade = compositionDTO.getUnidadeComposicao();
        return itemBean;
    }

    public BigDecimal getCusto() {
        if (custo == null && StringUtils.isNoneBlank(quantidade, valor)) {
            custo = BigDecimalUtils.multiply(quantidade, valor);
        }
        return custo;
    }

}
