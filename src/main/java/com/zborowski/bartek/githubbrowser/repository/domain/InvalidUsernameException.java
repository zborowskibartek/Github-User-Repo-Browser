package com.zborowski.bartek.githubbrowser.repository.domain;

public class InvalidUsernameException extends RuntimeException {

    private final String username;

    public InvalidUsernameException(String username) {
        super("Incorrect username: " + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}