package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserStars;

class GithubResponseMapper {

    static GithubUserRepositoriesResponse mapRepositoriesToResponse(GithubUserRepositories repositories) {
        return new GithubUserRepositoriesResponse(
                repositories.getRepositories(),
                repositories.getUsername()
        );
    }

    static GithubUserStarsResponse mapStarsToResponse(GithubUserStars stars) {
        return new GithubUserStarsResponse(
                stars.getUsername(),
                stars.getSumStars()
        );
    }
}