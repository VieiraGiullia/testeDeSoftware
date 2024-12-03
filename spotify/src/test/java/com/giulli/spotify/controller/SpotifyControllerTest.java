package com.giulli.spotify.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.giulli.spotify.model.Musica;
import com.giulli.spotify.model.Playlist;
import com.giulli.spotify.service.SpotifyService;

@SpringBootTest
@AutoConfigureMockMvc  
public class SpotifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpotifyService spotifyService;

    @Test
    public void buscarMusica_deveRetornarMusicas() throws Exception {
        Musica musica = new Musica("Shape of You", "Ed Sheeran");
        when(spotifyService.buscarMusica("Shape of You")).thenReturn(List.of(musica));

        mockMvc.perform(get("/api/spotify/buscar")
                        .param("nome", "Shape of You"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Shape of You"));
    }
    // teste para buscar playlist
    @Test
    public void getPlaylist_deveRetornarPlaylist() throws Exception {
        Playlist playlist = new Playlist("Minha Playlist");
        when(spotifyService.getPlaylist("Minha Playlist")).thenReturn(playlist);

        mockMvc.perform(get("/api/spotify/playlist")
                        .param("nome", "Minha Playlist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Minha Playlist"));
    }
    // teste para criar playlist
    @Test
    public void criarPlaylist_deveCriarPlaylist() throws Exception {
        mockMvc.perform(post("/api/spotify/playlist")
                        .param("nome", "Minha Playlist"))
                .andExpect(status().isOk());
    }
    // teste para remover playlist

}