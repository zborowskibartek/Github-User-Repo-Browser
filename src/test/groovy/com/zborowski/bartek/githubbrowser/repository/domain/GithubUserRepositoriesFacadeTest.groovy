package com.zborowski.bartek.githubbrowser.repository.domain


import spock.lang.Specification

class GithubUserRepositoriesFacadeTest extends Specification {

    private GithubUserRepositoriesFacade githubUserReposFacade
    private GithubUserRepositoriesProvider githubUserReposProvider

    def setup() {
        githubUserReposProvider = Stub()
        githubUserReposFacade = new GithubUserRepositoriesFacadeConfiguration().githubUserReposFacade(githubUserReposProvider)
    }

    def "should get user repositories"() {
        given:
            String username = "Bart"
            GithubRepository firstRepo = new GithubRepository("First Repo", 0)
            GithubRepository secondRepo = new GithubRepository("Second Repo", 2)
            GithubUserRepositories repos = new GithubUserRepositories(new ArrayList<GithubRepository>([firstRepo, secondRepo]), username)
            githubUserReposProvider.getAllGithubUserRepositories(username) >> repos
        when:
            GithubUserRepositories resultRepos = githubUserReposFacade.getAllUserRepos(username)
        then:
            resultRepos.getGithubRepositories() == [firstRepo, secondRepo]
            resultRepos.getUserName() == username
    }
}
