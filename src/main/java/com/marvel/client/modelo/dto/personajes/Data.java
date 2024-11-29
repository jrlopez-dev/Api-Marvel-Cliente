package com.marvel.client.modelo.dto.personajes;

import com.marvel.client.modelo.dto.personajes.ContenidoMarvel;

import java.util.List;

public class Data {
    private List<ContenidoMarvel> results;

    public List<ContenidoMarvel> getResults() {
        return results;
    }
    public void setResults(List<ContenidoMarvel> results) {
        this.results = results;
    }
}
