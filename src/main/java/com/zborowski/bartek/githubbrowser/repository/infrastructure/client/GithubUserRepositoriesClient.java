package com.zborowski.bartek.githubbrowser.repository.infrastructure.client;

import com.zborowski.bartek.githubbrowser.repository.domain.*;
import com.zborowski.bartek.githubbrowser.repository.infrastructure.client.dto.GithubRepositoriesDto;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GithubUserRepositoriesClient implements GithubUserRepositoriesProvider {

    private static final String USERS_PATH = "/users/";
    private static final String REPOS_PATH = "/repos?";
    private static final String PER_PAGE = "per_page=100&";
    private static final String PAGE = "page=";

    private final RestTemplate restTemplate;
    private final String basePath;

    GithubUserRepositoriesClient(RestTemplate restTemplate, String basePath) {
        this.restTemplate = restTemplate;
        this.basePath = basePath;
    }

    public GithubUserRepositories getUserRepositories(String username) {
        int pageIndex = 1;
        String path = "";
        GithubRepositoriesDto[] repositoriesPerPage;
        List<GithubRepositoriesDto> repositories = new ArrayList<>();
        do {
            path = createPath(username, pageIndex);
            try {
                repositoriesPerPage = restTemplate.getForObject(path, GithubRepositoriesDto[].class);
                if (repositoriesPerPage != null && repositoriesPerPage.length > 0){
                    repositories.addAll(Arrays.asList(repositoriesPerPage));
                }
            } catch (HttpClientErrorException.NotFound exception) {
                throw new InvalidUsernameException(username);
            } catch (HttpServerErrorException exception){
                throw new InvalidRepositoriesProviderException(exception.getMessage());
            }
            pageIndex++;
        } while (repositoriesPerPage != null && repositoriesPerPage.length > 0);

        return mapToGithubUserRepositories(username, repositories);
    }

    private GithubUserRepositories mapToGithubUserRepositories(String username, List<GithubRepositoriesDto> dtoRepositories) {
        List<GithubRepository> repositories = dtoRepositories.stream()
                .map(repository -> new GithubRepository(repository.getName(), repository.getStars()))
                .collect(Collectors.toList());
        return new GithubUserRepositories(repositories, username);
    }

    private String createPath(String username, int pageNumber) {
        return basePath + USERS_PATH + username + REPOS_PATH + PER_PAGE + PAGE + pageNumber;
    }
}
