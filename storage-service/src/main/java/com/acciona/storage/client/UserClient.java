package com.acciona.storage.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acciona.storage.model.User;

@FeignClient(name = "tweetsmanager-service", fallback = UserHystrixFallbackFactory.class)
@RequestMapping(value = "/api/users")
@Component
public interface UserClient {
	
	@GetMapping
	public ResponseEntity<List<User>> getAllTweets();
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId);

}
