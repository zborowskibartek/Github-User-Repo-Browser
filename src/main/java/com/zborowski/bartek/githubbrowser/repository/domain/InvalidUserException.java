package com.zborowski.bartek.githubbrowser.repository.domain;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String message) {
        super(message);
    }

}
