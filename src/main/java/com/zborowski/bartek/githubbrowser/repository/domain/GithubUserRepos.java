package com.zborowski.bartek.githubbrowser.repository.domain;

import java.util.ArrayList;
import java.util.List;

public class GithubUserRepos {

    private final List<GithubRepo> githubRepos;
    private final String name;

    GithubUserRepos(String name) {
        this.githubRepos = new ArrayList<>();
        this.name = name;
    }

    List<GithubRepo> getGithubRepos() {
        return githubRepos;
    }

    String getUserName() {
        return name;
    }

    void addRepo(GithubRepo githubRepo) {
        githubRepos.add(githubRepo);
    }

}
