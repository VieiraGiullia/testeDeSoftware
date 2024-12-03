package com.giulli.spotify.model;

import java.util.ArrayList;
import java.util.List;

public class Spotify {
    private final List<Musica> biblioteca;
    private final List<Playlist> playlists;

    public Spotify() {
        this.biblioteca = criarBiblioteca();
        this.playlists = new ArrayList<>();
    }

    private List<Musica> criarBiblioteca() {
        List<Musica> biblioteca = new ArrayList<>();
        biblioteca.add(new Musica("Shape of You", "Ed Sheeran"));
        biblioteca.add(new Musica("Blinding Lights", "The Weeknd"));
        return biblioteca;
    }

    public List<Musica> buscarMusica(String nome) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica musica : biblioteca) {
            if (musica.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(musica);
            }
        }
        return resultado;
    }

    public void criarPlaylist(String nome) {
        if (existePlaylist(nome)) {
            throw new IllegalArgumentException("Playlist já existe.");
        }
        playlists.add(new Playlist(nome));
    }

    public Playlist getPlaylist(String nome) {
        return playlists.stream()
                .filter(playlist -> playlist.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Playlist não encontrada."));
    }

    private boolean existePlaylist(String nome) {
        return playlists.stream().anyMatch(playlist -> playlist.getNome().equalsIgnoreCase(nome));
    }
}
