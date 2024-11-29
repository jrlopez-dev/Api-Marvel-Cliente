/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marvel.client.rest;

import com.marvel.client.modelo.dto.comics.ComicData;
import com.marvel.client.modelo.dto.comics.ComictDTO;
import com.marvel.client.modelo.dto.persobajeserie.PSerieDTO;
import com.marvel.client.modelo.dto.personajecomic.PScomicsDTO;
import com.marvel.client.modelo.dto.personajehistoria.PStoryDTO;
import com.marvel.client.modelo.dto.personajes.*;
import com.marvel.client.modelo.entity.Personajehistoria;
import com.marvel.client.modelo.entity.Personajes;
import com.marvel.client.modelo.entity.Personajeserie;
import com.marvel.client.reposirtory.PersonajeHistoryRepository;
import com.marvel.client.reposirtory.PersonajeRepository;
import com.marvel.client.reposirtory.PersonajeSerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jrlopez
 */
@Service
public class ServiceMarvel {
    @Autowired
    PersonajeRepository repositoryPersonaje;
    @Autowired
    PersonajeHistoryRepository repositoryHistory;
    @Autowired
    PersonajeSerieRepository repositorySerie;
    
    private final String publicKey = "03634040c87e77c532cf468d2970b978";
    private final String hash = "9f5c200f10e65a478a5c9bcc9f088e45";
    private final String ts = "1";
    private final String path="https://gateway.marvel.com:443/v1/public/";
    private final RestTemplate restTemplate = new RestTemplate();

    public PersonajesDTO buscarpersonaje(String name) {
        String urlbase = path + "characters?apikey=" + publicKey + "&ts=" + ts + "&hash=" + hash;
        String url = "";
        if (Objects.nonNull(name)) { //Si envian el nombre se agrega a la url el parametro name
            url = urlbase + "&name=" + name;
        }else{  //Sino se filtran todos los personajes
            url=urlbase;
        }
        MarvelDTO response = restTemplate.getForObject(url, MarvelDTO.class); //Peticion a la pai de marvel
        for (ContenidoMarvel data : response.getData().getResults()) {  //For  que recorre los personajes y los almacena en la base de datos
            Personajes personaje = repositoryPersonaje.findById(data.getId()).orElse(null);
            if (Objects.isNull(personaje)) {
                personaje = new Personajes();
                personaje.setId(data.getId());
                personaje.setName(data.getName());
                repositoryPersonaje.save(personaje);
            }
        }
        PersonajesDTO ps = new PersonajesDTO();
        ps.personajes=response.getData().getResults();
        return ps;
    }

    public PSerieDTO personajeserie(Integer id){
        String urlbase = path + "characters?apikey=" + publicKey + "&ts=" + ts + "&hash=" + hash;
        String url = "";
        if(Objects.nonNull(id)){
            Personajes personaje = repositoryPersonaje.findById(id).orElse(null);
            if(Objects.nonNull(personaje)){
                System.out.println("Entro al if");
                url = urlbase + "&name=" + personaje.getName();
            }else{
                System.out.println("Entro al else");
            }
        }
        System.out.println("Url a consultar: "+url);
        MarvelDTO response = restTemplate.getForObject(url, MarvelDTO.class);
        PSerieDTO pSerieDTO = new PSerieDTO();
        pSerieDTO.id=response.getData().getResults().get(0).getId();
        pSerieDTO.nombre = response.getData().getResults().get(0).getName();
        pSerieDTO.series = response.getData().getResults().get(0).getSeries().getItems();
        return pSerieDTO;
    }

    public PStoryDTO personajehistorieta(Integer id){
        String urlbase = path + "characters?apikey=" + publicKey + "&ts=" + ts + "&hash=" + hash;
        String url = "";
        if(Objects.nonNull(id)){
            Personajes personaje = repositoryPersonaje.findById(id).orElse(null);
            if(Objects.nonNull(personaje)){
                url = urlbase + "&name=" + personaje.getName();
            }
        }
        MarvelDTO response = restTemplate.getForObject(url, MarvelDTO.class);
        PStoryDTO ph = new PStoryDTO();
        ph.id=response.getData().getResults().get(0).getId();
        ph.nombre = response.getData().getResults().get(0).getName();
        ph.stories = response.getData().getResults().get(0).getStories().getItems();
        return ph;
    }

    public PScomicsDTO personajecomic(Integer id){
        String urlbase = path + "characters?apikey=" + publicKey + "&ts=" + ts + "&hash=" + hash;
        String url = "";
        if(Objects.nonNull(id)){
            Personajes personaje = repositoryPersonaje.findById(id).orElse(null);
            if(Objects.nonNull(personaje)){
                url = urlbase + "&name=" + personaje.getName();
            }
        }
        MarvelDTO response = restTemplate.getForObject(url, MarvelDTO.class);
        PScomicsDTO pScomicsDTO = new PScomicsDTO();
        pScomicsDTO.id=response.getData().getResults().get(0).getId();
        pScomicsDTO.nombre = response.getData().getResults().get(0).getName();
        pScomicsDTO.comics = response.getData().getResults().get(0).getStories().getItems();
        return pScomicsDTO;
    }

    public ComictDTO getlistcomic(){
        String url="";
        url = path+"comics?apikey="+publicKey+"&ts="+ts+"&hash="+hash;
        ComicData response = restTemplate.getForObject(url, ComicData.class);
        ComictDTO comictDTO = new ComictDTO();
        comictDTO.comics = response.data.results;
        return comictDTO;
    }

    public ComictDTO getcomicxid(Integer id){
        String url="";
        if(Objects.nonNull(id)){
            url = path+"comics/"+id+"?apikey="+publicKey+"&ts="+ts+"&hash="+hash;
        }
        ComicData response = restTemplate.getForObject(url, ComicData.class);
        ComictDTO comictDTO = new ComictDTO();
        comictDTO.comics = response.data.results;
        return comictDTO;
    }



}
