package com.zborowski.bartek.githubbrowser.repository.domain;

class GithubRepo {

    private final String name;
    private final int stars;

    GithubRepo(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    String getName() {
        return name;
    }

    int getStars() {
        return stars;
    }

}
