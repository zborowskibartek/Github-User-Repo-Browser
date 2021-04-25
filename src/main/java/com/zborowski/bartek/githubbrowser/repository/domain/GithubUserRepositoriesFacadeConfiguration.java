package com.zborowski.bartek.githubbrowser.repository.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GithubUserRepositoriesFacadeConfiguration {

    @Bean
    GithubUserRepositoriesFacade createGithubUserRepositoriesFacade(GithubUserRepositoriesProvider githubUserRepositoriesProvider) {
        GithubUserRepositoriesService githubUserRepositoriesService = new GithubUserRepositoriesService(githubUserRepositoriesProvider);
        return new GithubUserRepositoriesFacade(githubUserRepositoriesService);
    }

}
