package com.conversor.controller;

import com.conversor.model.*;
import com.conversor.util.Validador;

import java.math.BigInteger;

public class ConversorController {

    private Conversor conversor = new Conversor();
    private Historico historico = new Historico();

    public String converter(String valor, String origem, String destino) {

        try {

            if (Validador.campoVazio(valor))
                return "Erro: campo vazio";

            switch (origem) {
                case "BINARIO":
                    if (!Validador.isBinario(valor))
                        return "Erro: binário inválido";
                    break;

                case "OCTAL":
                    if (!Validador.isOctal(valor))
                        return "Erro: octal inválido";
                    break;

                case "HEXADECIMAL":
                    if (!Validador.isHexadecimal(valor))
                        return "Erro: hexadecimal inválido";
                    break;

                case "DECIMAL":
                    if (!Validador.isDecimal(valor))
                        return "Erro: decimal inválido";
                    break;
            }

            BigInteger decimal = conversor.paraDecimal(valor, origem);

            String resultado = conversor.deDecimal(decimal, destino);

            historico.adicionar(new Conversao(valor, origem, destino, resultado));

            return resultado;

        } catch (Exception e) {
            return "Erro na conversão.";
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n===== HISTÓRICO =====");

        for (Conversao c : historico.listar()) {
            System.out.println(c);
        }
    }

    public void limparHistorico() {
        historico.limpar();
    }
}