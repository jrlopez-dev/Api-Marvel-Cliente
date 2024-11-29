package com.marvel.client.modelo.dto.personajes;

public class ContenidoMarvel {
    private Integer id;
    private String name;
    private String description;
    private Series series;
    private Historietas stories;
    private Comics comics;

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Series getSeries() {
       return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Historietas getStories() {
       return stories;
    }

    public void setStories(Historietas stories) {
        this.stories = stories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
