package com.zborowski.bartek.githubbrowser.repository.util

import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserStars

class GithubUserStarsBuilder {

    private String username = "allegro"
    private int sumStars = 0

    static def create() {
        return new GithubUserStarsBuilder()
    }

    def setStars(int sumStars) {
        this.sumStars = sumStars
        return this
    }

    def setUsername(String username) {
        this.username = username
        return this
    }

    def build() {
        return new GithubUserStars(username, sumStars)
    }
}