package com.zborowski.bartek.githubbrowser.repository.infrastrucutre.api

import com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubUserRepositoriesResponse
import com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubUserStarsResponse
import org.springframework.http.HttpStatus

class GithubUserRepositoriesControllerIntegrationTest extends ControllerIntegrationSpec {

    def "should find repositories with status code 200 for user by username"() {
        given:
            def username = "zborowskibartek"
            def expectedResponse = createExpectedUserRepositoriesResponse(username)
            stubGithubUserRepositoriesClient(200, username)

        when:
            def response = restTemplate.getForEntity(localPath("/repositories?username=") + username, GithubUserRepositoriesResponse.class)

        then:
            verifyAll(response) {
                getBody() == expectedResponse
                getStatusCode() == HttpStatus.OK
            }
    }

    def "should return stars with status code 200 for user by username"() {
        given:
            def username = "zborowskibartek"
            def expectedResponse = createUserStarsResponse(username)
            stubGithubUserRepositoriesClient(200, username)

        when:
            def response = restTemplate.getForEntity(localPath("/repositories/stars?username=") + username, GithubUserStarsResponse.class)

        then:
            verifyAll(response) {
                getBody() == expectedResponse
                getBody().getSumStars() == 0
                getStatusCode() == HttpStatus.OK
            }
    }
}