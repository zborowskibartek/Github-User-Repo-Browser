package com.zborowski.bartek.githubbrowser.repository.infrastrucutre.client


import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories
import com.zborowski.bartek.githubbrowser.repository.domain.InvalidRepositoriesProviderException
import com.zborowski.bartek.githubbrowser.repository.domain.InvalidUsernameException

class GithubUserRepositoriesClientIntegrationTest extends ClientIntegrationSpec {

    def "should find repositories for user by username"() {
        given:
            def username = "zborowskibartek"
            stubGithubUserRepositoriesClient(200, username)
            GithubUserRepositories expectedResponse = createExpectedUserRepositories(username)

        when:
            def repositories = githubUserRepositoriesProvider.getUserRepositories(username)

        then:
            repositories.username == username
            repositories.repositories.containsAll(expectedResponse.repositories)
    }

    def "should throw InvalidUsernameException when return repositories for not existent username"() {
        given:
            def username = "usernameDoesNotExist"
            stubGithubUserRepositoriesClient(404, username)

        when:
            githubUserRepositoriesProvider.getUserRepositories(username)

        then:
            def exception = thrown(InvalidUsernameException)
            exception.getUsername() == username
    }

    def "should throw InvalidRepositoriesProviderException when external server error"() {
        given:
            def username = "zborowskibartek"
            stubGithubUserRepositoriesClient(500, username)

        when:
            githubUserRepositoriesProvider.getUserRepositories(username)

        then:
            thrown(InvalidRepositoriesProviderException)
    }
}