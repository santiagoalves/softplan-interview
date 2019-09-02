package br.org.softplan.unic.exercicio1.util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class Utils {

    private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

    public static final NumberFormat INSTANCE_DECIMAL_FORMATER;
    public static final NumberFormat INSTANCE_CURRENCY_FORMATER = NumberFormat.getCurrencyInstance(LOCALE_PT_BR);
    public static final ResourceBundle MSG_BUNDLE = ResourceBundle.getBundle("resource_bundle.remessa_simples", LOCALE_PT_BR);


    static {
        INSTANCE_DECIMAL_FORMATER = NumberFormat.getNumberInstance(LOCALE_PT_BR);
        INSTANCE_DECIMAL_FORMATER.setMinimumFractionDigits(2);
    }

    private Utils() {
    }
}
