package com.giulli.spotify.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        if (musicas.contains(musica)) {
            throw new IllegalArgumentException("Música já existe na playlist.");
        }
        musicas.add(musica);
    }

    public void removerMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            throw new IllegalArgumentException("Música não encontrada na playlist.");
        }
        musicas.remove(musica);
    }

    public List<Musica> getMusicas() {
        return new ArrayList<>(musicas); // Retorna uma cópia para evitar manipulação direta
    }

    public String getNome() {
        return nome;
    }
}