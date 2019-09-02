package br.org.siege.softplan.exercicio2.core.builder;

import br.org.siege.softplan.exercicio2.core.CompositionItemType;
import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.bean.CompositionItemBean;
import br.org.siege.softplan.exercicio2.core.bean.ItemBean;
import br.org.siege.softplan.exercicio2.core.exception.UnknowItemTypeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class CompositionItemBuilder {

    private CompositionItemBuilder() {
    }

    public static CompositionItemBean instance(List<CompositionDTO> compositions) {

        final ItemBean itemBean = ItemBean.instanceCompositionItem(compositions.get(0));
        final List<ItemBean> insumos = new ArrayList<>();
        final List<ItemBean> composicoes = new ArrayList<>();

        compositions.stream().collect(Collectors.groupingBy(CompositionDTO::getTipoItem))
                .forEach((tipo, itens) -> {
                    if (CompositionItemType.INSUMO.name().equals(tipo)) {
                        insumos.addAll(itens.stream().map(ItemBean::new).collect(Collectors.toList()));
                    } else if (CompositionItemType.COMPOSICAO.name().equals(tipo)) {
                        composicoes.addAll(
                                itens.stream().map(ItemBean::instanceComposicao)
                                        .filter(composicao -> !composicao.equals(itemBean))
                                        .collect(Collectors.toList())
                        );
                    } else {
                        throw new UnknowItemTypeException(tipo);
                    }
                });

        CompositionItemBean compositionItemBean = new CompositionItemBean(itemBean, insumos, composicoes);

        if (compositionItemBean.isNotCompositionDependent()) {
            compositionItemBean.calculate(Collections.emptyMap());
        }

        return compositionItemBean;
    }

}
