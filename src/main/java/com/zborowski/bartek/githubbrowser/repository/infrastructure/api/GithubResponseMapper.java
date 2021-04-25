package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

import com.zborowski.bartek.githubbrowser.repository.domain.GithubRepository;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserStars;

import java.util.List;
import java.util.stream.Collectors;


public class GithubResponseMapper {

    public static GithubUserRepositoriesResponse mapRepositoriesToResponse(GithubUserRepositories repositories) {
        return new GithubUserRepositoriesResponse(mapRepositoryListToResponse(repositories.getRepositories()),
                repositories.getUsername()
        );
    }


    public static List<GithubRepositoryResponse> mapRepositoryListToResponse(List<GithubRepository> repositoryList) {
        return repositoryList.stream()
                .map(repository -> new GithubRepositoryResponse(repository.getName(), repository.getStars()))
                .collect(Collectors.toList());
    }

    public static GithubUserStarsResponse mapStarsToResponse(GithubUserStars stars) {
        return new GithubUserStarsResponse(
                stars.getUsername(),
                stars.getSumStars()
        );
    }
}