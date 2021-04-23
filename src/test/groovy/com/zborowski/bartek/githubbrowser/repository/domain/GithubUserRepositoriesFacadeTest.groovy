package com.zborowski.bartek.githubbrowser.repository.domain

import com.zborowski.bartek.githubbrowser.repository.GithubUserRepositoriesFacadeSpec
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder

class GithubUserRepositoriesFacadeTest extends GithubUserRepositoriesFacadeSpec {

    def "should find repositories"() {
        given:
            String username = "Bartek"
            def userRepositories = GithubUserRepositoriesBuilder.create().addRepo("1st", 0).addRepo("2nd", 50).build()
            githubUserRepositoriesProvider.getUserRepositories(username) >> userRepositories

        expect:
            githubUserRepositoriesFacade.getUserRepositories(username) == userRepositories
    }
}
