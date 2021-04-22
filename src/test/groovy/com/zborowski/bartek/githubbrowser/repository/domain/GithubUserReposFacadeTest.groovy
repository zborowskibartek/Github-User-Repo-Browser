package com.zborowski.bartek.githubbrowser.repository.domain


import spock.lang.Specification

class GithubUserReposFacadeTest extends Specification {

    private GithubUserReposFacade githubUserReposFacade
    private GithubUserReposProvider githubUserReposProvider

    def setup() {
        githubUserReposProvider = Stub()
        githubUserReposFacade = new GithubUserReposFacadeConfiguration().githubUserReposFacade(githubUserReposProvider)
    }

    def "should get user repositories"() {
        given:
            String username = "Bart"
            GithubRepo firstRepo = new GithubRepo("First Repo", 0)
            GithubRepo secondRepo = new GithubRepo("Second Repo", 2)
            GithubUserRepos repos = new GithubUserRepos(username)
            repos.addRepo(firstRepo)
            repos.addRepo(secondRepo)
            githubUserReposProvider.getAllGithubUserRepos(username) >> repos
        when:
            GithubUserRepos resultRepos = githubUserReposFacade.getAllUserRepos(username)
        then:
            resultRepos.getGithubRepos() == [firstRepo, secondRepo]
            resultRepos.getUserName() == username
    }
}
