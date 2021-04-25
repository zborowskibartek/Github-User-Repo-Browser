package com.zborowski.bartek.githubbrowser.repository.domain

import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserStarsBuilder
import spock.lang.Specification

class GithubUserRepositoriesFacadeSpec extends Specification {

    GithubUserRepositoriesFacade githubUserRepositoriesFacade
    GithubUserRepositoriesProvider githubUserRepositoriesProvider

    def setup() {
        githubUserRepositoriesProvider = Stub()
        githubUserRepositoriesFacade = new GithubUserRepositoriesFacadeConfiguration().createGithubUserRepositoriesFacade(githubUserRepositoriesProvider)
    }

    GithubUserRepositories createUserRepositories(String username) {
        def userRepositories = GithubUserRepositoriesBuilder.create()
                .setUsername(username)
                .withRepo("1st repository", 0)
                .withRepo("2nd repository", 50)
                .build()
        return userRepositories
    }

    GithubUserStars createUserStars(String username) {
        def userStars = GithubUserStarsBuilder.create()
                .setUsername(username)
                .setStars(50)
                .build()
        return userStars
    }
}