package com.zborowski.bartek.githubbrowser.repository.domain;

class GithubUserReposService {

    private final GithubUserReposProvider githubUserReposProvider;

    GithubUserReposService(GithubUserReposProvider githubUserReposProvider) {
        this.githubUserReposProvider = githubUserReposProvider;
    }

    GithubUserRepos getAllUserRepos(String username) {
        return githubUserReposProvider.getAllGithubUserRepos(username);
    }

}
