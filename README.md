# 💡 General Information

Github User Repo Browser is a simple project to browse the Github repositories for a specific user. Application allows you to perfom search for all repositories of a given user or retrive sum of stars from all colletions.

## ⚙️ Pre-requisites

- Java 11
- Gradle 6+

## 🕛 Installation

### Setup

- Clone the project with the following command:

`git clone https://github.com/zborowskibartek/Gtihub-User-Repo-Browser.git`

### Running

- Build and run application with command:

`gradle bootRun`

### Testing

- Run tests with command:

`gradle test`

## ✨ Getting Started

The app connects to the Github API and provides two core features mentioned below. There are endpoints that can be called to retrieve said data:

- **GET** all public repositories for specific user

`http://localhost:8080/repositories?username={username}`

JSON resposne:

```json
{
    "username": "zborowskibartek",
    "repositories": [
        {
            "name": "Board-Game-Rental",
            "stars": 0
        },
        {
            "name": "Imperial-Settlers",
            "stars": 0
        },
        {
            "name": "Notion-To-Anki",
            "stars": 0
        }
    ]
}
```

- **GET** sum of starsł for specific user

`http://localhost:8080/repositories/stars?username={username}`

JSON response:

```json
{
    "username": "zborowskibartek",
    "sumStars": 0
}
```

## ⌨️ Technology Stack

- **Spring Boot**
- **Spock**
- **Wiremock**

## ⚠️ Possible Future Extensions

There are a couple of features I'd like to add:

- **Token Authentication** - increased functionality due to limitations for unauthenticated users 
(only 60 request per hour)
- **New endpoint** - to provide retreving repositories by organizations
- **Paggination** - for fetched user repositories
- **Extra query params** - for sorting and filtering user repositories
