package com.acciona.storage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acciona.storage.entity.ValidatedTweet;
import com.acciona.storage.service.ValidatedTweetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ValidatedTweetResource {
	
	@Autowired
	ValidatedTweetService validatedTweetService;

	@GetMapping(value = "/validatedtweets")
	public ResponseEntity<List<ValidatedTweet>> getAllValidatedTweet(){
		log.debug("REST request to retrieve validated tweets: ");
		List<ValidatedTweet> validatedTweets = new ArrayList<ValidatedTweet>();
		validatedTweets = validatedTweetService.getAllValidatedTweets();
		if (validatedTweets.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(validatedTweets);
	}
	
	@PatchMapping(value = "/validatedtweets/{id}")
	public ResponseEntity<ValidatedTweet> saveValidatedTweet(@PathVariable("user") Long userId){
		log.info("Validating Tweet by usder Id {}", userId);
		ValidatedTweet validatedTweet = validatedTweetService.validateTweetsByUser(userId);		
		if (null == validatedTweet) {
			log.error("Twwet with user id {} not found.", userId);
            return  ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(validatedTweet);
	}
}
