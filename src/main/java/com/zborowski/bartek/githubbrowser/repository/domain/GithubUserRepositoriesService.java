package com.zborowski.bartek.githubbrowser.repository.domain;

class GithubUserRepositoriesService {

    private final GithubUserRepositoriesProvider githubUserRepositoriesProvider;

    GithubUserRepositoriesService(GithubUserRepositoriesProvider githubUserRepositoriesProvider) {
        this.githubUserRepositoriesProvider = githubUserRepositoriesProvider;
    }

    GithubUserRepositories getUserRepositories(String username) {
        return githubUserRepositoriesProvider.getUserRepositories(username);
    }

}
