package com.alura.springboot.demo.principal;

import com.alura.springboot.demo.model.Artista;
import com.alura.springboot.demo.model.Musica;
import com.alura.springboot.demo.model.TipoArtista;
import com.alura.springboot.demo.repository.ArtistasRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistasRepository repositorio;
    private Scanner sc = new Scanner(System.in);

    public Principal(ArtistasRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0){

            var menu = """
                    \n===== Buscador de Musica e Artistas =====
                    1 - Cadastrar artistas
                    2 - Cadastrar Músicas
                    3 - Listar Músicas
                    4 - Buscar artistas
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

        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);

    }

    private void listarMusicas() {

        List<Artista> musicas = repositorio.findAll();
        musicas.forEach(System.out::println);
    }

    private void cadastrarMusicas() {

        System.out.println("Cadastrar música de que artista: ");
        var nome = sc.nextLine();
        // Criando uma derived Querie
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);

        if(artista.isPresent()){

            System.out.println("Informe o titulo da música: ");
            var nomeMusica= sc.nextLine();

            Musica musica = new Musica(nomeMusica);
            // Adicionando a musica a lista de musica do artista
            artista.get().getMusicas().add(musica);

            // Criando o vinculo bidirecional onde a musica é vinculada ao artista
            musica.setArtista(artista.get());
            repositorio.save(artista.get());

        } else{
            System.out.println("Artista não encontrado");
        }

    }

    private void cadastrarArtistas() {

        var cadastrarNovo = "S";

        while(cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista: ");
            var nome = sc.nextLine();

            System.out.println("Informe o tipo do artista (SOLO, DUPLA, BANDA):");
            var tipoArtista = sc.nextLine();

            TipoArtista tipoTipo = TipoArtista.valueOf(tipoArtista.toUpperCase());
            Artista artista = new Artista(nome, tipoTipo);

            repositorio.save(artista);

            // Recursivo chamamento de um novo artista
            System.out.println("Deseja cadastrar um novo artista: (S/N)");
            cadastrarNovo = sc.nextLine();
        }

    }
}
