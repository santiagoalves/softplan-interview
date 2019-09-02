package br.org.softplan.unic.exercicio1.remessa_simples.customizada;

import java.math.BigDecimal;

import static br.org.softplan.unic.exercicio1.util.Utils.INSTANCE_DECIMAL_FORMATER;

public class TotalizadorPreco {

    private BigDecimal precoTotal = BigDecimal.ZERO;

    public void somar(BigDecimal valor) {
        precoTotal = precoTotal.add(valor);
    }

    @Override
    public String toString() {
        return INSTANCE_DECIMAL_FORMATER.format(precoTotal);
    }

}