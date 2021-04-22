package com.zborowski.bartek.githubbrowser.repository.domain;

public interface GithubUserRepositoriesProvider {

    GithubUserRepositories getUserRepositories(String username);

}
