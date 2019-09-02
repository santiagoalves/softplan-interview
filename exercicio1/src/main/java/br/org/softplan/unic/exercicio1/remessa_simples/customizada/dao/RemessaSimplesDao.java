package br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao;

import java.math.BigDecimal;

public interface RemessaSimplesDao {

    BigDecimal encontrarPrecoParaCodigo(Integer codigo);

}
