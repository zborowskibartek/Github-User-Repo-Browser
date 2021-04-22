package com.zborowski.bartek.githubbrowser.repository.infrastructure.dto;

import com.zborowski.bartek.githubbrowser.repository.domain.GithubRepository;

import java.util.List;

public class GithubUserRepositoriesDto {

    private List<GithubRepository> repositories;
    private String userName;

    public GithubUserRepositoriesDto(List<GithubRepository> githubRepos, String userName) {
        this.repositories = githubRepos;
        this.userName = userName;
    }

    public GithubUserRepositoriesDto() {
    }

    public List<GithubRepository> getGithubRepos() {
        return repositories;
    }

    public String getUserName() {
        return userName;
    }

    public void addRepo(GithubRepository githubRepo) {
        repositories.add(githubRepo);
    }

}
