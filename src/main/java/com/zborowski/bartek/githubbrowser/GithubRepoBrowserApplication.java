package com.zborowski.bartek.githubbrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class GithubRepoBrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubRepoBrowserApplication.class, args);
	}

}
