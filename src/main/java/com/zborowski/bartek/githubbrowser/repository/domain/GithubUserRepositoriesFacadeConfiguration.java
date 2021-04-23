package com.zborowski.bartek.githubbrowser.repository.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubUserRepositoriesFacadeConfiguration {

    @Bean
    public GithubUserRepositoriesFacade createGithubUserRepositoriesFacade(GithubUserRepositoriesProvider githubUserRepositoriesProvider){
        GithubUserRepositoriesService githubUserRepositoriesService = new GithubUserRepositoriesService(githubUserRepositoriesProvider);
        return new GithubUserRepositoriesFacade(githubUserRepositoriesService);
    }

}
