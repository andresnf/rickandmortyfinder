package com.telefonica.rickandmortyfinder.model;

import java.util.List;

public class CharacterAppearance {

    private String name;
    private List<String> episodes;
    private String firstAppearance;

    public CharacterAppearance() {
    }

    public CharacterAppearance(String name, List<String> episodes, String firstAppearance) {
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
