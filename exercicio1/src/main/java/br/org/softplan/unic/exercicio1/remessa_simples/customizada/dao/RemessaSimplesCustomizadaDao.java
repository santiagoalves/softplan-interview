package br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RemessaSimplesCustomizadaDao implements RemessaSimplesDao {

    private static final Map<Integer, BigDecimal> LOTES_REMESSA_SIMPLES;

    static {
        LOTES_REMESSA_SIMPLES = new HashMap<>();
        LOTES_REMESSA_SIMPLES.put(1, BigDecimal.valueOf(10));
        LOTES_REMESSA_SIMPLES.put(2, BigDecimal.valueOf(35));
        LOTES_REMESSA_SIMPLES.put(3, BigDecimal.valueOf(5));
        LOTES_REMESSA_SIMPLES.put(4, BigDecimal.valueOf(1500));
        LOTES_REMESSA_SIMPLES.put(5, BigDecimal.valueOf(0.3));
    }

    public BigDecimal encontrarPrecoParaCodigo(Integer codigo) {
        return LOTES_REMESSA_SIMPLES.get(codigo);
    }


}
