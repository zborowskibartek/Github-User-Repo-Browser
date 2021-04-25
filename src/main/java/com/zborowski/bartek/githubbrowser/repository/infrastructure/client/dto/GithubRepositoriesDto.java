package com.zborowski.bartek.githubbrowser.repository.infrastructure.client.dto;

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

    public Integer getStars() {
        return stars;
    }

}