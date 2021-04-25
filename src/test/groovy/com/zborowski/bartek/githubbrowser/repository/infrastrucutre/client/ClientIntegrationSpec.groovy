package com.zborowski.bartek.githubbrowser.repository.infrastrucutre.client

import com.zborowski.bartek.githubbrowser.repository.IntegrationSpec
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesProvider
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder
import org.springframework.beans.factory.annotation.Autowired

class ClientIntegrationSpec extends IntegrationSpec {

    @Autowired
    GithubUserRepositoriesProvider githubUserRepositoriesProvider

    GithubUserRepositories createExpectedUserRepositories(String username) {
        def userRepositories = GithubUserRepositoriesBuilder.create()
                .setUsername(username)
                .withRepo("Board-Game-Rental", 0)
                .withRepo("Imperial-Settlers", 0)
                .withRepo("Notion-To-Anki", 0)
                .build()
        return userRepositories
    }
}