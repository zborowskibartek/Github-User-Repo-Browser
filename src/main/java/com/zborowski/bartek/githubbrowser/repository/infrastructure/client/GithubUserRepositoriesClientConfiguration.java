package com.zborowski.bartek.githubbrowser.repository.infrastructure.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class GithubUserRepositoriesClientConfiguration {

    @Bean
    RestTemplate githubUserRepositoriesRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    GithubUserRepositoriesClient githubUserRepositoriesClient() {
        return new GithubUserRepositoriesClient(githubUserRepositoriesRestTemplate());
    }
}
