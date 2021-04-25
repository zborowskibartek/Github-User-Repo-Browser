package com.zborowski.bartek.githubbrowser.repository.infrastrucutre.client

import com.zborowski.bartek.githubbrowser.repository.IntegrationSpec
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesProvider
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder
import org.springframework.beans.factory.annotation.Autowired

class GithubUserRepositoriesIntegrationTest extends IntegrationSpec {

    @Autowired
    GithubUserRepositoriesProvider githubUserRepositoriesProvider

    def "should find repositories for user by username"() {
        given:
            def username = "zborowskibartek";
            stubGithubUserRepositoriesClient(200, username)
            GithubUserRepositories expectedResponse = createExpectedUserRepositoriesResponse(username)

        when:
            def repositories = githubUserRepositoriesProvider.getUserRepositories(username)
            println repositories
            println expectedResponse

        then:
            repositories.username == username
            repositories.repositories.containsAll(expectedResponse.repositories)
    }

    private static GithubUserRepositories createExpectedUserRepositoriesResponse(String username) {
        def userRepositories = GithubUserRepositoriesBuilder.create()
                .setUsername(username)
                .withRepo("Board-Game-Rental", 0)
                .withRepo("Imperial-Settlers", 0)
                .withRepo("Notion-To-Anki", 0)
                .build()
        return userRepositories
    }

}
