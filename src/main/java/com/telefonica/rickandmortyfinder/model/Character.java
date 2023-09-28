package com.telefonica.rickandmortyfinder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Character {

    private String name;

    @JsonProperty("episode")
    private List<String> episodes;

    @JsonProperty("first_appearance")
    private String firstAppearance;

    public Character() {
    }

    public Character(String name, List<String> episodes, String firstAppearance) {
        this.name = name;
        this.episodes = episodes;
        this.firstAppearance = firstAppearance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<String> episodes) {
        this.episodes = episodes;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }
}
