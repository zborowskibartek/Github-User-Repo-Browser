package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import java.util.Objects;

public class GithubRepositoryResponse {

    private String name;
    private int stars;

    public GithubRepositoryResponse(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public GithubRepositoryResponse() {
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubRepositoryResponse that = (GithubRepositoryResponse) o;
        if (stars != that.stars) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + stars;
        return result;
    }
}
