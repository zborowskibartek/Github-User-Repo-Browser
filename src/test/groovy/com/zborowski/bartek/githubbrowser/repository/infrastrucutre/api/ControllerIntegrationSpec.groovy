package com.zborowski.bartek.githubbrowser.repository.infrastrucutre.api

import com.zborowski.bartek.githubbrowser.repository.IntegrationSpec
import com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubUserRepositoriesResponse
import com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubUserStarsResponse
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserStarsBuilder

import static com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubResponseMapper.mapRepositoriesToResponse
import static com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubResponseMapper.mapStarsToResponse

class ControllerIntegrationSpec extends IntegrationSpec {

    GithubUserRepositoriesResponse createExpectedUserRepositoriesResponse(String username) {
        def userRepositories = GithubUserRepositoriesBuilder.create()
                .setUsername(username)
                .withRepo("Board-Game-Rental", 0)
                .withRepo("Imperial-Settlers", 0)
                .withRepo("Notion-To-Anki", 0)
                .build()
        return mapRepositoriesToResponse(userRepositories)
    }

    GithubUserStarsResponse createUserStarsResponse(String username) {
        def userStars = GithubUserStarsBuilder.create()
                .setUsername(username)
                .setStars(0)
                .build()
        return mapStarsToResponse(userStars)
    }

    String localPath(String endpoint) {
        return "http://localhost:" + port + endpoint
    }
}