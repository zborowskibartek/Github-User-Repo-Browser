package com.zborowski.bartek.githubbrowser.repository.domain

import spock.lang.Specification

class GithubUserRepositoriesFacadeSpec extends Specification {

    GithubUserRepositoriesFacade githubUserRepositoriesFacade
    GithubUserRepositoriesProvider githubUserRepositoriesProvider

    def setup() {
        githubUserRepositoriesProvider = Stub()
        githubUserRepositoriesFacade = new GithubUserRepositoriesFacadeConfiguration().createGithubUserRepositoriesFacade(githubUserRepositoriesProvider)
    }

}
