package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import java.util.List;
import java.util.Objects;

public class GithubUserRepositoriesResponse {

    private String username;
    private List<GithubRepositoryResponse> repositories;

    public GithubUserRepositoriesResponse(List<GithubRepositoryResponse> repositories, String username) {
        this.repositories = repositories;
        this.username = username;
    }

    public GithubUserRepositoriesResponse() {
    }

    public String getUsername() {
        return username;
    }

    public List<GithubRepositoryResponse> getRepositories() {
        return repositories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserRepositoriesResponse that = (GithubUserRepositoriesResponse) o;
        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(repositories, that.repositories);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (repositories != null ? repositories.hashCode() : 0);
        return result;
    }
}