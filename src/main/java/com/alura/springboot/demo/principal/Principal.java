package com.alura.springboot.demo.principal;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0){

            var menu = """
                    \n===== Buscador de Musica e Artistas =====
                    1 - Cadastrar artistas
                    2 - Cadastrar Músicas
                    3 - Listar Músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){

                case 1:
                    cadastrarArtistas();
                    break;

                case 2:
                    cadastrarMusicas();
                    break;

                case 3:
                    listarMusicas();
                    break;

                case 4:
                    buscarArtistas();
                    break;

                case 5:
                    pesquisarDados();
                    break;

                case 0:
                    System.out.println("Saindo da aplicação...");
                    break;

                default:
                    System.out.println("Digite uma opção válidas");
            }
        }
    }

    private void pesquisarDados() {

    }

    private void buscarArtistas() {

    }

    private void listarMusicas() {

    }

    private void cadastrarMusicas() {

    }

    private void cadastrarArtistas() {

    }
}
