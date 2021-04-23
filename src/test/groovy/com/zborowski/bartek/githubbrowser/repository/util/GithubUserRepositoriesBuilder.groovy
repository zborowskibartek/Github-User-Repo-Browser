package com.zborowski.bartek.githubbrowser.repository.util

import com.zborowski.bartek.githubbrowser.repository.domain.GithubRepository
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories

class GithubUserRepositoriesBuilder {

    private String username = "allegro"
    private List<GithubRepository> repositories = new ArrayList<>()

    static def create() {
        return new GithubUserRepositoriesBuilder()
    }

    def addRepo(String name, int stars) {
        this.repositories.add(new GithubRepository(name, stars))
        return this
    }

    def emptyList() {
        return new GithubUserRepositoriesBuilder().build()
    }

    def build() {
        return new GithubUserRepositories(repositories, username)
    }

}
