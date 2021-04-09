package com.acciona.storage.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acciona.storage.model.User;
@Component
public class UserHystrixFallbackFactory implements UserClient{

	@Override
	public ResponseEntity<List<User>> getAllTweets() {		
		return ResponseEntity.ok(new ArrayList<User>());
	}

	@Override
	public ResponseEntity<User> getUserById(long userId) {
		User user = User.builder().name(null).screenName(null).followersCount(null).build();
		return ResponseEntity.ok(user);
	}

}
