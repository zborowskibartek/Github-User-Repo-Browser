package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

public class GithubUserStarsResponse {

    private final String username;
    private final int sumStars;

    public GithubUserStarsResponse(String username, int sumStars) {
        this.username = username;
        this.sumStars = sumStars;
    }

    public String getUsername() {
        return username;
    }

    public int getSumStars() {
        return sumStars;
    }
}