package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;


import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositories;
import com.zborowski.bartek.githubbrowser.repository.domain.GithubUserRepositoriesFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repositories")
public class GithubUserRepositoriesController {

    private final GithubUserRepositoriesFacade githubUserRepositoriesFacade;

    public GithubUserRepositoriesController(GithubUserRepositoriesFacade githubUserRepositoriesFacade) {
        this.githubUserRepositoriesFacade = githubUserRepositoriesFacade;
    }

    @GetMapping
    public ResponseEntity<GithubUserRepositories> getUserRepositories(@RequestParam(value = "username") String username) {
        GithubUserRepositories repositories = githubUserRepositoriesFacade.getUserRepositories(username);
        if (repositories == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repositories);
    }

}
