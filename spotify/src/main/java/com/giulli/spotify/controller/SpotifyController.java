package com.giulli.spotify.controller;

import com.giulli.spotify.model.Musica;
import com.giulli.spotify.model.Playlist;
import com.giulli.spotify.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spotify")
public class SpotifyController {

    private final SpotifyService spotifyService;

    @Autowired
    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/buscar")
    public List<Musica> buscarMusica(@RequestParam String nome) {
        return spotifyService.buscarMusica(nome);
    }

    @PostMapping("/playlist")
    public void criarPlaylist(@RequestParam String nome) {
        spotifyService.criarPlaylist(nome);
    }

    @GetMapping("/playlist")
    public Playlist obterPlaylist(@RequestParam String nome) {
        return spotifyService.getPlaylist(nome);
    }

    @PostMapping("/playlist/{playlistNome}/adicionar")
    public void adicionarMusicaNaPlaylist(@PathVariable String playlistNome, @RequestParam String musicaNome) {
        spotifyService.adicionarMusicaNaPlaylist(playlistNome, musicaNome);
    }

    @PostMapping("/playlist/{playlistNome}/remover")
    public void removerMusicaDaPlaylist(@PathVariable String playlistNome, @RequestParam String musicaNome) {
        spotifyService.removerMusicaDaPlaylist(playlistNome, musicaNome);
    }
}
