package com.conversor.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Conversor {

    public BigDecimal paraDecimal(String valor, String origem) {
        int radix = getRadix(origem);

        if (!valor.contains(".")) {
            return new BigDecimal(new BigInteger(valor, radix));
        }

        String[] parts = valor.split("\\.");
        String intPartStr = parts[0].isEmpty() ? "0" : parts[0];
        BigDecimal intPart = new BigDecimal(new BigInteger(intPartStr, radix));

        BigDecimal fracPart = BigDecimal.ZERO;
        if (parts.length > 1 && !parts[1].isEmpty()) {
            BigDecimal base = new BigDecimal(radix);
            BigDecimal divisor = base;
            for (char c : parts[1].toCharArray()) {
                int digit = Character.digit(c, radix);
                fracPart = fracPart.add(new BigDecimal(digit).divide(divisor, 16, RoundingMode.HALF_UP));
                divisor = divisor.multiply(base);
            }
        }
        return intPart.add(fracPart);
    }

    public String deDecimal(BigDecimal numero, String destino) {
        int radix = getRadix(destino);
        BigInteger intPart = numero.toBigInteger();
        BigDecimal fracPart = numero.subtract(new BigDecimal(intPart));

        String intStr = intPart.toString(radix).toUpperCase();

        if (fracPart.compareTo(BigDecimal.ZERO) == 0) {
            return intStr;
        }

        StringBuilder fracStr = new StringBuilder(".");
        BigDecimal base = new BigDecimal(radix);

        int precision = 10;
        while (fracPart.compareTo(BigDecimal.ZERO) > 0 && fracStr.length() <= precision) {
            fracPart = fracPart.multiply(base);
            BigInteger digit = fracPart.toBigInteger();
            fracStr.append(digit.toString(radix).toUpperCase());
            fracPart = fracPart.subtract(new BigDecimal(digit));
        }

        return intStr + fracStr.toString();
    }

    private int getRadix(String base) {
        switch (base) {
            case "BINARIO":
                return 2;
            case "OCTAL":
                return 8;
            case "HEXADECIMAL":
                return 16;
            case "DECIMAL":
                return 10;
            default:
                throw new IllegalArgumentException("Base inválida");
        }
    }
}