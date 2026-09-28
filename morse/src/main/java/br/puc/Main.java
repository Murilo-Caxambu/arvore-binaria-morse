package br.puc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.incializar();
        arvore.carregarTabelaMorsePadrao();

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=============================================");
            System.out.println(" ÁRVORE BINÁRIA - CÓDIGO MORSE");
            System.out.println("=============================================");
            System.out.println("1. Descodificar mensagem em codigo Morse");
            System.out.println("2. Buscar caractere por sequencia morse (ex: '...')");
            System.out.println("3. Exibir estrutura da árvore binaria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Descodificar Mensagem ---");
                    System.out.println("Orientações: separe letras por espaço (' ') e palavras por barra ('/').");
                    System.out.print("Introduza a mensagem em Morse: ");
                    String mensagem = scanner.nextLine();
                    String resultado = arvore.decodificarMensagem(mensagem);
                    System.out.println("Mensagem descodificada: " + resultado);
                    break;

                case 2:
                    System.out.println("\n--- Busca por Codigo Morse ---");
                    System.out.print("Introduza a sequencia de pontos e traços (ex: '---'): ");
                    String codigo = scanner.nextLine().trim();
                    String caractereEncontrado = arvore.buscar(codigo);
                    if (caractereEncontrado != null) {
                        System.out.println("Caractere correspondente : " + caractereEncontrado);
                    } else {
                        System.out.println("Nenhum caractere encontrado para a sequencia.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Estrutura hierarquica da arvore ---");
                    arvore.exibir();
                    break;

                case 0:
                    System.out.println("Programa encerrado com sucesso.");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha um número válido.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}