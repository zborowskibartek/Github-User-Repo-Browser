package com.zborowski.bartek.githubbrowser.repository.domain;

import java.util.List;

public class GithubUserRepositories {

    private final List<GithubRepository> repositories;
    private final String username;

    public GithubUserRepositories(List<GithubRepository> repositories, String username) {
        this.repositories = repositories;
        this.username = username;
    }

    public List<GithubRepository> getGithubRepositories() {
        return repositories;
    }

    public String getUserName() {
        return username;
    }

}
