package br.org.siege.softplan.exercicio2.core.bean;

import br.org.siege.softplan.exercicio2.core.exception.CompositionUnkownException;
import br.org.siege.softplan.exercicio2.core.util.BigDecimalUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompositionItemBean {

    @EqualsAndHashCode.Include
    private ItemBean itemBean;
    @Getter
    private boolean notCompositionDependent;
    private List<ItemBean> inputs;
    private List<ItemBean> compositions;

    public CompositionItemBean(ItemBean itemBean, List<ItemBean> inputs, List<ItemBean> compositions) {
        this.itemBean = itemBean;
        this.inputs = inputs;
        this.compositions = compositions;
        this.notCompositionDependent = compositions.isEmpty();
    }

    public static String parseToString(CompositionItemBean compositionItemBean) {
        return String.format("%d %s %s %s",
                compositionItemBean.itemBean.getCodigo(),
                compositionItemBean.itemBean.getDescricao(),
                compositionItemBean.itemBean.getUnidade(),
                BigDecimalUtils.parseToString(compositionItemBean.itemBean.getCusto())
        );
    }

    public boolean isComputationPending() {
        return !notCompositionDependent;
    }

    public void calculate(final Map<Integer, CompositionItemBean> compositionsBatch) {

        if (this.itemBean.getCusto() != null) {
            return;
        }

        BigDecimal custoInsumos = this.inputs.stream()
                .map(ItemBean::getCusto)
                .reduce(BigDecimal.ZERO, BigDecimalUtils::add);

        BigDecimal custoComposicoes = BigDecimal.ZERO;

        if (!compositionsBatch.isEmpty() && !this.compositions.isEmpty()) {

            for (final ItemBean itemBeanComposicao : this.compositions) {

                final CompositionItemBean referenciaComposicao = compositionsBatch.get(itemBeanComposicao.getCodigo());

                if (referenciaComposicao == null) {
                    throw new CompositionUnkownException();
                }

                if (referenciaComposicao.isComputationPending()) {
                    referenciaComposicao.calculate(compositionsBatch);
                }

                BigDecimal custoItemComposicao = BigDecimalUtils.multiply(itemBeanComposicao.getQuantidade(), referenciaComposicao.itemBean.getCusto());

                custoComposicoes = BigDecimalUtils.add(custoComposicoes, custoItemComposicao);

            }

        }

        this.itemBean.setCusto(BigDecimalUtils.add(custoInsumos, custoComposicoes));

    }

}
