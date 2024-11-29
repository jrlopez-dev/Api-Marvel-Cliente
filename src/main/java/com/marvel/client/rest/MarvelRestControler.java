package com.marvel.client.rest;

import com.marvel.client.modelo.dto.comics.ComicData;
import com.marvel.client.modelo.dto.comics.ComictDTO;
import com.marvel.client.modelo.dto.persobajeserie.PSerieDTO;
import com.marvel.client.modelo.dto.personajecomic.PScomicsDTO;
import com.marvel.client.modelo.dto.personajehistoria.PStoryDTO;
import com.marvel.client.modelo.dto.personajes.ContenidoMarvel;
import com.marvel.client.modelo.dto.personajes.MarvelDTO;
import com.marvel.client.modelo.dto.personajes.PersonajesDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marvel")
public class MarvelRestControler {
    
    private final ServiceMarvel marvelAPIClient;

    public MarvelRestControler(ServiceMarvel marvelAPIClient) {
        this.marvelAPIClient = marvelAPIClient;
    }


    @GetMapping("/obtenerpersonajes")
    public PersonajesDTO getpersonajes(@RequestParam(value = "name", required = false) String name ) {
        return marvelAPIClient.buscarpersonaje(name);
    }

    @GetMapping("/personajeserie")
    public PSerieDTO getpersonajeseries(@RequestParam Integer idpersonaje) {
        return marvelAPIClient.personajeserie(idpersonaje);
    }

    @GetMapping("/personajehistorietas")
    public PStoryDTO getpersonajehistorias(@RequestParam Integer id) {
        return marvelAPIClient.personajehistorieta(id);
    }

    @GetMapping("/personajecomic")
    public PScomicsDTO getpersonajecomic(@RequestParam Integer id) {
        return marvelAPIClient.personajecomic(id);
    }

    @GetMapping("/lstcomicAll")
    public ComictDTO getAllComic() {
        return marvelAPIClient.getlistcomic();
    }

    @GetMapping("/buscarcomicid")
    public ComictDTO getcomicxid(@RequestParam Integer id){
        return marvelAPIClient.getcomicxid(id);
    }

}
