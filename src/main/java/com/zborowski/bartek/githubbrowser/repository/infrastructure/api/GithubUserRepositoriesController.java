package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;


import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesFacade;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserStars;
import com.zborowski.bartek.githubbrowser.repository.domain.InvalidUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.zborowski.bartek.githubbrowser.repository.infrastructure.api.GithubResponseMapper.*;

@RestController
@RequestMapping("/repositories")
public class GithubUserRepositoriesController {

    private final GithubUserRepositoriesFacade githubUserRepositoriesFacade;

    public GithubUserRepositoriesController(GithubUserRepositoriesFacade githubUserRepositoriesFacade) {
        this.githubUserRepositoriesFacade = githubUserRepositoriesFacade;
    }

    @GetMapping
    public ResponseEntity<GithubUserRepositoriesResponse> getUserRepositories(@RequestParam(value = "username") String username) {
        GithubUserRepositories repositories = githubUserRepositoriesFacade.getUserRepositories(username);
        if (repositories == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapRepositoriesToResponse(repositories));
    }

    @GetMapping("/stars")
    public ResponseEntity<GithubUserStarsResponse> getAllStarsFromUserRepositories(@RequestParam(value = "username") String username) {
        GithubUserStars stars = githubUserRepositoriesFacade.getAllStarsUserRepositories(username);
        return ResponseEntity.ok(mapStarsToResponse(stars));
    }

    @ExceptionHandler(InvalidUsernameException.class)
    private ResponseEntity<GithubUserRepositoriesErrorResponse> handleInvalidUsernameException(InvalidUsernameException exception) {
        GithubUserRepositoriesErrorResponse errors = new GithubUserRepositoriesErrorResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}