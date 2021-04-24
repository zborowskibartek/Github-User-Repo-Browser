package com.zborowski.bartek.githubbrowser.repository.infrastructure.client.dto;

import com.zborowski.bartek.githubbrowser.repository.domain.GithubRepository;

import java.util.List;

public class GithubUserRepositoriesDto {

    private List<GithubRepository> repositories;
    private String username;

    public GithubUserRepositoriesDto(List<GithubRepository> repositories, String username) {
        this.repositories = repositories;
        this.username = username;
    }

    public GithubUserRepositoriesDto() {
    }

    public List<GithubRepository> getRepositories() {
        return repositories;
    }

    public String getUsername() {
        return username;
    }

    public void addRepo(GithubRepository githubRepo) {
        repositories.add(githubRepo);
    }

}
