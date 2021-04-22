package com.zborowski.bartek.githubbrowser.repository.domain;

public class GithubRepository {

    private final String name;
    private final int stars;

    public GithubRepository(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

}
