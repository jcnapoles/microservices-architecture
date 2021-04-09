package com.acciona.storage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acciona.storage.StorageServiceApplication;
import com.acciona.storage.entity.HashtagItem;
import com.acciona.storage.entity.ValidatedItem;
import com.acciona.storage.entity.ValidatedTweet;
import com.acciona.storage.model.Hashtag;
import com.acciona.storage.model.Tweet;
import com.acciona.storage.model.User;
import com.acciona.storage.repository.ValidatedTweetRepository;

@SpringBootTest(classes = StorageServiceApplication.class)
class ValidatedTweetServiceMockTest {
	
	@Autowired
	private ValidatedTweetRepository validatedTweetRepository;	
	
	@Autowired
	private ValidatedTweetService validatedTweetService;
	
	@BeforeEach	
	public void setUp() {			
		List<HashtagItem> hashtagItems = new ArrayList<HashtagItem>();
		hashtagItems.add(HashtagItem.builder().id(1L).hashtagId(1L).text("HelloWorld").hashtagId(1L)
				.hashtag(Hashtag.builder().id(1L).text("HelloWorld").build()).build());
		List<ValidatedItem> validatedItems = new ArrayList<ValidatedItem>();
		User user = User.builder().id(1L).name("User Test").screenName("user1").followersCount(1500)
				.build();
		validatedItems
				.add(ValidatedItem
						.builder().id(1L).tweetId(
								1L)
						.tweet(Tweet.builder().id(1L).idSstr("1").language("ES").place(null).text("testing tweet")
								.user(user).validation(true)
								.build())
						.build());
		ValidatedTweet validatedTweet01 = ValidatedTweet.builder().createAt(new Date()).id(1L).user(user).hashtagItems(hashtagItems).userId(user.getId()).validateItems(validatedItems).build();
		when(validatedTweetRepository.findById(1L)).thenReturn(Optional.of(validatedTweet01));
		when(validatedTweetRepository.save(validatedTweet01)).thenReturn(validatedTweet01);
		
	}

	@Test
	public void assertThatFoundValidatedTweet() {
		ValidatedTweet found = validatedTweetService.getValidatedTweet(1L).get();
		assertThat(found.getId()).isEqualTo(1L);
	}

}
