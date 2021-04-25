package com.zborowski.bartek.githubbrowser.repository.domain

class GithubUserRepositoriesFacadeTest extends GithubUserRepositoriesFacadeSpec {

    def "should find repositories for user by username"() {
        given:
            def username = "allegro"
            def userRepositories = createUserRepositories(username)
            githubUserRepositoriesProvider.getUserRepositories(username) >> userRepositories

        expect:
            githubUserRepositoriesFacade.getUserRepositories(username) == userRepositories
    }

    def "should throw exception when return repositories for not existent username"() {
        given:
            def username = "usernameDoesNotExist"
            stubUserRepositoriesToThrowInvalidUserException(username)
        when:
            githubUserRepositoriesFacade.getUserRepositories(username)

        then:
            def exception = thrown(InvalidUsernameException)
            exception.getUsername() == username
    }

    def "should return stars for user by username"() {
        given:
            def username = "allegro"
            def userRepositories = createUserRepositories(username)
            def userStars = createUserStars(username)
            githubUserRepositoriesProvider.getUserRepositories(username) >> userRepositories

        expect:
            githubUserRepositoriesFacade.getAllStarsUserRepositories(username) == userStars
    }

    def "should throw exception when return stars for not existent username"() {
        given:
            def username = "usernameDoesNotExist"
            stubUserRepositoriesToThrowInvalidUserException(username)

        when:
            githubUserRepositoriesFacade.getAllStarsUserRepositories(username)

        then:
            def exception = thrown(InvalidUsernameException)
            exception.getUsername() == username
    }

    private void stubUserRepositoriesToThrowInvalidUserException(String username) {
        githubUserRepositoriesProvider.getUserRepositories(username) >> {
            throw new InvalidUsernameException(username)
        }
    }
}