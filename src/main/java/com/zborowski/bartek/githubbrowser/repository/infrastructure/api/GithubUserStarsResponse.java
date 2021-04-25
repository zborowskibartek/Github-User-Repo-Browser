package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import java.util.Objects;

public class GithubUserStarsResponse {

    private String username;
    private int sumStars;

    public GithubUserStarsResponse(String username, int sumStars) {
        this.username = username;
        this.sumStars = sumStars;
    }

    public GithubUserStarsResponse() {
    }

    public String getUsername() {
        return username;
    }

    public int getSumStars() {
        return sumStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserStarsResponse that = (GithubUserStarsResponse) o;
        if (sumStars != that.sumStars) return false;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + sumStars;
        return result;
    }
}