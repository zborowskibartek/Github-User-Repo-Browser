package com.zborowski.bartek.githubbrowser.repository.domain;

class GithubUserReposStars {

    private String userName;
    private int starsAmount;

    GithubUserReposStars(String userName, int starsAmount) {
        this.userName = userName;
        this.starsAmount = starsAmount;
    }

    String getUserName() {
        return userName;
    }

    int getSumAllStars() {
        return starsAmount;
    }
}
