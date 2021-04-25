package com.zborowski.bartek.githubbrowser.repository

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.*
import static org.springframework.http.HttpHeaders.CONTENT_TYPE
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@ActiveProfiles(profiles = "integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationSpec extends Specification {

    WireMockServer userRepositoriesClient

    @LocalServerPort
    int port

    RestTemplate restTemplate

    def setup() {
        userRepositoriesClient = new WireMockServer(8081)
        userRepositoriesClient.start()
        restTemplate = new RestTemplate()
    }

    def cleanup() {
        userRepositoriesClient.stop()
    }

    def stubGithubUserRepositoriesClient(int statusCode, String username) {
        createStubPerPage(username, statusCode, "/client/githubUserRepositoriesResponsePageOne.json", 1)
        createStubPerPage(username, statusCode, "/client/githubUserRepositoriesResponsePageTwo.json", 2)
    }

    private StubMapping createStubPerPage(String username, int statusCode, String bodyFilePath, int page) {
        userRepositoriesClient
                .stubFor(get(urlEqualTo("/users/" + username + "/repos?per_page=100&page=" + page))
                        .willReturn(
                                aResponse()
                                        .withStatus(statusCode)
                                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                                        .withBodyFile(bodyFilePath))
                )
    }
}