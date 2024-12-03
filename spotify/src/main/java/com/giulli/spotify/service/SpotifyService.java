package com.giulli.spotify.service;

import com.giulli.spotify.model.Musica;
import com.giulli.spotify.model.Playlist;
import com.giulli.spotify.model.Spotify;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotifyService {

    private final Spotify spotify;

    public SpotifyService() {
        this.spotify = new Spotify();
    }

    public List<Musica> buscarMusica(String nome) {
        return spotify.buscarMusica(nome);
    }

    public void criarPlaylist(String nome) {
        spotify.criarPlaylist(nome);
    }

    public Playlist getPlaylist(String nome) {
        return spotify.getPlaylist(nome);
    }

    public void adicionarMusicaNaPlaylist(String playlistNome, String musicaNome) {
        List<Musica> musicas = buscarMusica(musicaNome);
        if (!musicas.isEmpty()) {
            Playlist playlist = getPlaylist(playlistNome);
            playlist.adicionarMusica(musicas.get(0));
        }
    }

    public void removerMusicaDaPlaylist(String playlistNome, String musicaNome) {
        List<Musica> musicas = buscarMusica(musicaNome);
        if (!musicas.isEmpty()) {
            Playlist playlist = getPlaylist(playlistNome);
            playlist.removerMusica(musicas.get(0));
        }
    }
}
