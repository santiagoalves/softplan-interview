package br.org.siege.softplan.exercicio2.core;

import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.bean.CompositionItemBean;
import br.org.siege.softplan.exercicio2.core.builder.CompositionItemBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompositionBatchCalculator {

    private final Map<Integer, CompositionItemBean> compositionsBatch = new LinkedHashMap<>();

    public CompositionBatchCalculator(Map<Integer, List<CompositionDTO>> compositionBatchs) {
        compositionBatchs.forEach(this::registerCompositionBatch);
    }

    private void registerCompositionBatch(Integer codigo, List<CompositionDTO> compositionDTOS) {
        CompositionItemBean compositionItemBean = CompositionItemBuilder.instance(compositionDTOS);
        this.compositionsBatch.put(codigo, compositionItemBean);
    }

    public String execute() {

        return this.compositionsBatch.values().stream()
                .map(compositionItemBean -> {
                    if (compositionItemBean.isComputationPending()) {
                        compositionItemBean.calculate(this.compositionsBatch);
                    }
                    return CompositionItemBean.parseToString(compositionItemBean);
                }).collect(Collectors.joining("\n"));

    }

}
