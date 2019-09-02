package br.org.softplan.unic.exercicio1.remessa_simples.padrao.formatter;

import br.org.softplan.unic.exercicio1.ObservacaoFormatter;

import java.util.List;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.PREFIXO_SINGULAR;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class SingularFormatter implements ObservacaoFormatter<List<Integer>, String> {

    private static SingularFormatter instance;

    private SingularFormatter() {
    }

    public static SingularFormatter instance() {
        if (instance == null) {
            instance = new SingularFormatter();
        }
        return instance;
    }

    @Override
    public String formmat(List<Integer> codigos) {
        return String.format("%s: %s.", MSG_BUNDLE.getString(PREFIXO_SINGULAR), codigos.get(0));
    }

}