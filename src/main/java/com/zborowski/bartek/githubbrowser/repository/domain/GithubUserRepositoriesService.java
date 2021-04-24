package com.zborowski.bartek.githubbrowser.repository.domain;

class GithubUserRepositoriesService {

    private final GithubUserRepositoriesProvider githubUserRepositoriesProvider;

    GithubUserRepositoriesService(GithubUserRepositoriesProvider githubUserRepositoriesProvider) {
        this.githubUserRepositoriesProvider = githubUserRepositoriesProvider;
    }

    GithubUserRepositories getUserRepositories(String username) {
        return githubUserRepositoriesProvider.getUserRepositories(username);
    }

    GithubUserStars getAllStarsUserRepositories(String username) {
        GithubUserRepositories repositories = githubUserRepositoriesProvider.getUserRepositories(username);
        int sumStars = repositories.getRepositories().stream()
                .mapToInt(GithubRepository::getStars)
                .sum();
        return new GithubUserStars(username, sumStars);
    }
}
