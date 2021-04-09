package com.acciona.storage.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acciona.storage.model.Tweet;

@Component
public class TweetHystrixFallbackFactory implements TweetClient{

	@Override
	public ResponseEntity<List<Tweet>> getAllTweets(Long userId, Boolean validation) {		
		return ResponseEntity.ok(new ArrayList<Tweet>());
	}

	@Override
	public ResponseEntity<Tweet> validateTweet(Long id, Tweet tweet) {
		Tweet tweetDB = Tweet.builder().idSstr(null).language(null).place(null).text(null).user(null).validation(null)
				.hashtags(null).build();
		return ResponseEntity.ok(tweetDB);
	}

}
