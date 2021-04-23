package com.zborowski.bartek.githubbrowser.repository.domain;

import java.util.List;

public class GithubUserRepositories {

    private final String username;
    private final List<GithubRepository> repositories;

    public GithubUserRepositories(List<GithubRepository> repositories, String username) {
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
