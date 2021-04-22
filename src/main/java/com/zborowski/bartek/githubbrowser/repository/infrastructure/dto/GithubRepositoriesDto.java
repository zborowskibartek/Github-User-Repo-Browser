package com.zborowski.bartek.githubbrowser.repository.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepositoriesDto {

    private String name;
    @JsonProperty(value = "stargazers_count")
    private Integer stars;

    public GithubRepositoriesDto(String name, Integer stars) {
        this.name = name;
        this.stars = stars;
    }

    public GithubRepositoriesDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
