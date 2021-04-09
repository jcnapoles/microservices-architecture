package com.acciona.tweetsmanager.service;

import java.util.List;
import java.util.Optional;

import com.acciona.tweetsmanager.model.Tweet;
import com.acciona.tweetsmanager.model.User;

public interface TweetService {

	List<Tweet> findAllTweets();

	Optional<Tweet> getTweet(Long tweetId);

	Tweet updateTweet(Tweet tweet);

	List<Tweet> getTweetValidatedByUser(User user);
	
	List<Tweet> getTweetsByUser(User user);
	
	List<Tweet> getTweetsByValidation(Boolean validation);
	
	List<Tweet> getTweetsByUserAndValidation(User user,Boolean validation);

	Tweet createTweet(Tweet tweet);
}
