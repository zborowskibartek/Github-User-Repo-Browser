package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import com.zborowski.bartek.githubbrowser.repository.domain.GithubRepository;

import java.util.List;

public class GithubUserRepositoriesResponse {

    private final String username;
    private final List<GithubRepository> repositories;

    public GithubUserRepositoriesResponse(List<GithubRepository> repositories, String username) {
        this.repositories = repositories;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<GithubRepository> getRepositories() {
        return repositories;
    }
}
