package com.acciona.storage.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acciona.storage.model.Tweet;

@FeignClient(name = "tweetsmanager-service", fallback = TweetHystrixFallbackFactory.class)
@RequestMapping(value = "/api/tweets")
public interface TweetClient {
	
	@GetMapping
	public ResponseEntity<List<Tweet>> getAllTweets(@RequestParam(name = "user", required = false) Long userId,
			@RequestParam(name = "validation", required = false) Boolean validation);
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Tweet> validateTweet(@PathVariable(value = "id", required = false) final Long id,
			@RequestBody Tweet tweet);
}
