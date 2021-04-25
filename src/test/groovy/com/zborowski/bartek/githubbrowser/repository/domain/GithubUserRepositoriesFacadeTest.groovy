package com.zborowski.bartek.githubbrowser.repository.domain


import com.zborowski.bartek.githubbrowser.repository.util.GithubUserRepositoriesBuilder
import com.zborowski.bartek.githubbrowser.repository.util.GithubUserStarsBuilder

class GithubUserRepositoriesFacadeTest extends GithubUserRepositoriesFacadeSpec {

    def "should find repositories for user by username"() {
        given:
            def username = "allegro"
            def userRepositories = createUserRepositories(username)
            githubUserRepositoriesProvider.getUserRepositories(username) >> userRepositories

        expect:
            githubUserRepositoriesFacade.getUserRepositories(username) == userRepositories
    }

    def "should throw exception when find repositories and username not exist"() {
        given:
            def username = "UsernameDoesNotExist"
            stubUserRepositoriesToThrowInvalidUserException(username)
        when:
            githubUserRepositoriesFacade.getUserRepositories(username)

        then:
            def exception = thrown(InvalidUsernameException)
            exception.getUsername() == username
    }

    def "should count sum of stars for user"() {
        given:
            def username = "allegro"
            def userRepositories = createUserRepositories(username)
            def userStars = createUserStars(username)
            githubUserRepositoriesProvider.getUserRepositories(username) >> userRepositories

        expect:
            githubUserRepositoriesFacade.getAllStarsUserRepositories(username) == userStars
    }

    def "should throw exception when find stars and username not exist"() {
        given:
            def username = "UsernameDoesNotExist"
            stubUserRepositoriesToThrowInvalidUserException(username)

        when:
            githubUserRepositoriesFacade.getAllStarsUserRepositories(username)g

        then:
            def exception = thrown(InvalidUsernameException)
            exception.getUsername() == username
    }

    private void stubUserRepositoriesToThrowInvalidUserException(String username) {
        githubUserRepositoriesProvider.getUserRepositories(username) >> {
            throw new InvalidUsernameException(username)
        }
    }

    private static GithubUserRepositories createUserRepositories(String username) {
        def userRepositories = GithubUserRepositoriesBuilder.create()
                .setUsername(username)
                .withRepo("1st repository", 0)
                .withRepo("2nd repository", 50)
                .build()
        return userRepositories
    }

    private static GithubUserStars createUserStars(String username) {
        def userStars = GithubUserStarsBuilder.create()
                .setUsername(username)
                .setStars(50)
                .build()
        return userStars
    }
}
