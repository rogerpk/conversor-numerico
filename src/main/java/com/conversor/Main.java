package com.conversor;

import com.conversor.controller.ConversorController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConversorController controller = new ConversorController();

        int opcao;

        do {
            System.out.println("\n===== CONVERSOR PROFISSIONAL =====");
            System.out.println("1 - Converter");
            System.out.println("2 - Histórico");
            System.out.println("3 - Limpar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Número: ");
                    String valor = sc.nextLine();

                    System.out.print("Origem (BINARIO/OCTAL/DECIMAL/HEXADECIMAL): ");
                    String origem = sc.nextLine().toUpperCase();

                    System.out.print("Destino (BINARIO/OCTAL/DECIMAL/HEXADECIMAL): ");
                    String destino = sc.nextLine().toUpperCase();

                    String resultado = controller.converter(valor, origem, destino);

                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    controller.mostrarHistorico();
                    break;

                case 3:
                    controller.limparHistorico();
                    System.out.println("Histórico limpo.");
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}