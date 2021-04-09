package com.acciona.storage.repository;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatedTweetRepositoryMockConfiguration {
	
	@MockBean
	private ValidatedTweetRepository validatedTweetRepository;
}
