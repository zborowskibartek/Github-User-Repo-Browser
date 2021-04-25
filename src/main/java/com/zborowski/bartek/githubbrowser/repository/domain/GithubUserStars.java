package com.zborowski.bartek.githubbrowser.repository.domain;

import java.util.Objects;

public class GithubUserStars {

    private String username;
    private int sumStars;

    public GithubUserStars(String username, int sumStars) {
        this.username = username;
        this.sumStars = sumStars;
    }
    public GithubUserStars() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSumStars() {
        return sumStars;
    }

    public void setSumStars(int sumStars) {
        this.sumStars = sumStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserStars that = (GithubUserStars) o;
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