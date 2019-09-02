package br.org.softplan.unic.exercicio1.remessa_simples.padrao.formatter;

import br.org.softplan.unic.exercicio1.ObservacaoFormatter;

import java.util.List;
import java.util.stream.Collectors;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.PREFIXO_PLURAL;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class PluralFormatter implements ObservacaoFormatter<List<Integer>, String> {

    private static PluralFormatter instance;

    private PluralFormatter() {
    }

    public static PluralFormatter instance() {
        if (instance == null) {
            instance = new PluralFormatter();
        }
        return instance;
    }

    @Override
    public String formmat(List<Integer> codigos) {

        final int indexUltimoElemento = codigos.size() - 1;

        final String ocorrencias = codigos.subList(0, indexUltimoElemento)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")).concat(" e ")
                .concat(codigos.get(indexUltimoElemento).toString());

        return String.format("%s: %s.", MSG_BUNDLE.getString(PREFIXO_PLURAL), ocorrencias);

    }
}