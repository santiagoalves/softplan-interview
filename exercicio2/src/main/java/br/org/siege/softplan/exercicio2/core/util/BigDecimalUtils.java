package br.org.siege.softplan.exercicio2.core.util;

import br.org.siege.softplan.exercicio2.core.exception.InvalidNumberFormatException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class BigDecimalUtils {

    public static final DecimalFormat BIG_DECIMAL_PARSER;
    private static final RoundingMode ROUND_MODE_DEFAULT = RoundingMode.DOWN;
    private static final MathContext mathContext = new MathContext(5, ROUND_MODE_DEFAULT);

    static {

        BIG_DECIMAL_PARSER = (DecimalFormat) NumberFormat.getInstance(new Locale("pt", "BR"));
        BIG_DECIMAL_PARSER.setParseBigDecimal(true);
        BIG_DECIMAL_PARSER.setMinimumFractionDigits(2);
        BIG_DECIMAL_PARSER.setMaximumFractionDigits(2);
        BIG_DECIMAL_PARSER.setRoundingMode(ROUND_MODE_DEFAULT);

    }

    private BigDecimalUtils(){}


    public static BigDecimal parseFromString(String bigDecimalString) {
        try{
            return (BigDecimal) BIG_DECIMAL_PARSER.parseObject(bigDecimalString);
        } catch (ParseException e) {
            throw new InvalidNumberFormatException(bigDecimalString);
        }
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b, mathContext);
    }

    public static BigDecimal multiply(String a, String b) {
        return parseFromString(a).multiply(parseFromString(b), mathContext);
    }

    public static BigDecimal multiply(String a, BigDecimal b) {
        return parseFromString(a).multiply(b, mathContext);
    }

    public static String parseToString(BigDecimal bigDecimal) {
        return BIG_DECIMAL_PARSER.format(bigDecimal);
    }
}
