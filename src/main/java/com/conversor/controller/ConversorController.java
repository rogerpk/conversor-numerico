package com.conversor.controller;

import com.conversor.model.Conversao;
import com.conversor.model.Conversor;
import com.conversor.model.Historico;
import com.conversor.util.Validador;

public class ConversorController {

    private Conversor conversor = new Conversor();
    private Historico historico = new Historico();

    public String converter(String valor, String origem, String destino) {

        try {

            if (Validador.campoVazio(valor)) {
                return "Campo vazio.";
            }

            valor = valor.replace(",", ".");

            switch (origem) {

                case "BINARIO":

                    if (!Validador.isBinario(valor)) {
                        return "Isso não é um número binário válido.";
                    }

                    break;

                case "OCTAL":

                    if (!Validador.isOctal(valor)) {
                        return "Isso não é um número octal válido.";
                    }

                    break;

                case "HEXADECIMAL":

                    if (!Validador.isHexadecimal(valor)) {
                        return "Isso não é um número hexadecimal válido.";
                    }

                    break;

                case "DECIMAL":

                    if (!Validador.isDecimal(valor)) {
                        return "Isso não é um número decimal válido.";
                    }

                    break;

                default:
                    return "Base inválida.";
            }

            java.math.BigDecimal decimal = conversor.paraDecimal(valor, origem);

            String resultado = conversor.deDecimal(decimal, destino).replace(".", ",");

            historico.adicionar(
                    new Conversao(valor, origem, destino, resultado)
            );

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

    public String obterHistorico() {

        StringBuilder sb = new StringBuilder();

        for (Conversao c : historico.listar()) {
            sb.append(c).append("\n");
        }

        return sb.toString();
    }
}