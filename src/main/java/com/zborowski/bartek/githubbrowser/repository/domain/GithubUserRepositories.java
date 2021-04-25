package com.zborowski.bartek.githubbrowser.repository.domain;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserRepositories that = (GithubUserRepositories) o;
        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(repositories, that.repositories);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (repositories != null ? repositories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GithubUserRepositories{" +
                "username='" + username + '\'' +
                ", repositories=" + repositories +
                '}';
    }
}