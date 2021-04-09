package com.acciona.storage.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acciona.storage.client.HashtagClient;
import com.acciona.storage.client.TweetClient;
import com.acciona.storage.client.UserClient;
import com.acciona.storage.entity.HashtagItem;
import com.acciona.storage.entity.ValidatedItem;
import com.acciona.storage.entity.ValidatedTweet;
import com.acciona.storage.model.User;
import com.acciona.storage.repository.HashtagItemRepository;
import com.acciona.storage.repository.ValidatedItemRepository;
import com.acciona.storage.repository.ValidatedTweetRepository;

@Service
public class ValidatedTweetServiceImpl implements ValidatedTweetService{
	
	@Autowired
	ValidatedTweetRepository validatedTweetRepository;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	TweetClient tweetClient;
	
	@Autowired
	HashtagClient hashtagClient;
	
	@Autowired
	ValidatedItemRepository validatedItemRepository;
	
	@Autowired
	HashtagItemRepository hashtagItemRepository;

	@Override
	public List<ValidatedTweet> getAllValidatedTweets() {		
		return validatedTweetRepository.findAll();
	}

	@Override
	public ValidatedTweet validateTweetsByUser(Long userId) {
		User user = userClient.getUserById(userId).getBody();	
		ValidatedTweet validatedTweet = null;
		if (null != user) {
			tweetClient.getAllTweets(user.getId(), false).getBody().forEach(tweet -> {
				 tweetClient.validateTweet(tweet.getId(), tweet);
			});
			List<ValidatedItem> validatedItems = tweetClient.getAllTweets(user.getId(), true).getBody().stream()
					.map(tweet -> validatedItemRepository
							.save(ValidatedItem.builder().tweetId(tweet.getId()).tweet(tweet).build()))
					.collect(Collectors.toList());
			List<HashtagItem> hashtagItems = hashtagClient.getTopHashTagsUsed(null).getBody().stream()
					.map(hashtag -> hashtagItemRepository.save(HashtagItem.builder().text(hashtag.getText()).build()))
					.collect(Collectors.toList());
			
			validatedTweet = ValidatedTweet.builder().userId(user.getId()).hashtagItems(hashtagItems).validateItems(validatedItems).build();
		} else {
			return validatedTweet;
		}
		return validatedTweet;
	}

	@Override
	public Optional<ValidatedTweet> getValidatedTweet(Long id) {		
		return validatedTweetRepository.findById(id);
	}

}
