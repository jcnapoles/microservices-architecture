package com.acciona.storage.service;

import java.util.List;
import java.util.Optional;

import com.acciona.storage.entity.ValidatedTweet;

public interface ValidatedTweetService {
	
	List<ValidatedTweet> getAllValidatedTweets();
	
	ValidatedTweet validateTweetsByUser(Long user);	
	
	Optional<ValidatedTweet> getValidatedTweet(Long id);
	

}
