package com.zborowski.bartek.githubbrowser.repository

import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse
import static com.github.tomakehurst.wiremock.client.WireMock.get
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import static org.springframework.http.HttpHeaders.CONTENT_TYPE
import static org.springframework.http.MediaType.*

@ActiveProfiles(profiles = "integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationSpec extends Specification {

    WireMockServer userRepositoriesClient

    def setup() {
        userRepositoriesClient = new WireMockServer(8081)
        userRepositoriesClient.start()
    }

    def cleanup() {
        userRepositoriesClient.stop()
    }

    def stubGithubUserRepositoriesClient(int statusCode, String username) {
        userRepositoriesClient
                .stubFor(get(urlEqualTo("/users/" + username + "/repos"))
                        .willReturn(
                                aResponse()
                                        .withStatus(statusCode)
                                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                                        .withBodyFile("/client/githubUserRepositoriesResponse.json"))
                )
    }
}