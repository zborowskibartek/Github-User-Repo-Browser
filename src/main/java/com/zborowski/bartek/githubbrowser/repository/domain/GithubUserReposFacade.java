package com.zborowski.bartek.githubbrowser.repository.domain;


public class GithubUserReposFacade {

    private final GithubUserReposService githubUserReposService;

    GithubUserReposFacade(GithubUserReposService githubUserReposService) {
        this.githubUserReposService = githubUserReposService;
    }

    public GithubUserRepos getAllUserRepos(String username) {
        return githubUserReposService.getAllUserRepos(username);
    }

}
