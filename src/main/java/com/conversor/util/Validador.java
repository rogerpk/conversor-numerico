package com.conversor.util;

public class Validador {

    public static boolean campoVazio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    public static boolean isBinario(String valor) {
        return valor.matches("[01]+");
    }

    public static boolean isOctal(String valor) {
        return valor.matches("[0-7]+");
    }

    public static boolean isHexadecimal(String valor) {
        return valor.matches("[0-9A-Fa-f]+");
    }

    public static boolean isDecimal(String valor) {
        return valor.matches("[0-9]+");
    }
}