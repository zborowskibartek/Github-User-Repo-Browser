package com.zborowski.bartek.githubbrowser.repository.domain;

public class GithubUserRepositoriesFacade {

    private final GithubUserRepositoriesService githubUserRepositoriesService;

    GithubUserRepositoriesFacade(GithubUserRepositoriesService githubUserRepositoriesService) {
        this.githubUserRepositoriesService = githubUserRepositoriesService;
    }

    public GithubUserRepositories getUserRepositories(String username) {
        return githubUserRepositoriesService.getUserRepositories(username);
    }

    public GithubUserStars getAllStarsUserRepositories(String username) {
        return githubUserRepositoriesService.getAllStarsUserRepositories(username);
    }

}
