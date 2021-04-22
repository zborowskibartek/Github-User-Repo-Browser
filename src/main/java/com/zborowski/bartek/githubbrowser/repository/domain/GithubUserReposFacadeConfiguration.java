package com.zborowski.bartek.githubbrowser.repository.domain;

public class GithubUserReposFacadeConfiguration {

    GithubUserReposFacade githubUserReposFacade(GithubUserReposProvider githubUserReposProvider){
        GithubUserReposService githubUserReposService = new GithubUserReposService(githubUserReposProvider);
        return new GithubUserReposFacade(githubUserReposService);
    }

}
