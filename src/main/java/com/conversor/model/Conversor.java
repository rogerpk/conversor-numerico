package com.conversor.model;

import java.math.BigInteger;

public class Conversor {

    public BigInteger paraDecimal(String valor, String origem) {

        switch (origem) {
            case "BINARIO":
                return new BigInteger(valor, 2);

            case "OCTAL":
                return new BigInteger(valor, 8);

            case "HEXADECIMAL":
                return new BigInteger(valor, 16);

            case "DECIMAL":
                return new BigInteger(valor);

            default:
                throw new IllegalArgumentException("Base inválida");
        }
    }

    public String deDecimal(BigInteger numero, String destino) {

        switch (destino) {
            case "BINARIO":
                return numero.toString(2);

            case "OCTAL":
                return numero.toString(8);

            case "HEXADECIMAL":
                return numero.toString(16).toUpperCase();

            case "DECIMAL":
                return numero.toString();

            default:
                throw new IllegalArgumentException("Base inválida");
        }
    }
}