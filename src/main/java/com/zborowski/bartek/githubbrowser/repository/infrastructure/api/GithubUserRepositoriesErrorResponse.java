package com.zborowski.bartek.githubbrowser.repository.infrastructure.api;

class GithubUserRepositoriesErrorResponse {

    private final GithubUserRepositoriesErrorResponseDetails error;

    GithubUserRepositoriesErrorResponse(String message) {
        this.error = new GithubUserRepositoriesErrorResponseDetails(message);
    }

    public GithubUserRepositoriesErrorResponseDetails getError() {
        return error;
    }

    private static class GithubUserRepositoriesErrorResponseDetails {
        private final String message;

        private GithubUserRepositoriesErrorResponseDetails(String message){
                this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}