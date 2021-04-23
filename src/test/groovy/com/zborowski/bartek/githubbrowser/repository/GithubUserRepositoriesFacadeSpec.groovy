package com.zborowski.bartek.githubbrowser.repository

import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesFacade
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesFacadeConfiguration
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesProvider
import spock.lang.Specification

class GithubUserRepositoriesFacadeSpec extends Specification {

    GithubUserRepositoriesFacade githubUserRepositoriesFacade
    GithubUserRepositoriesProvider githubUserRepositoriesProvider

    def setup() {
        githubUserRepositoriesProvider = Stub()
        githubUserRepositoriesFacade = new GithubUserRepositoriesFacadeConfiguration().createGithubUserRepositoriesFacade(githubUserRepositoriesProvider)
    }

}
