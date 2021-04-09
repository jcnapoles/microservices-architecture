package com.acciona.storage.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acciona.storage.model.Hashtag;

@FeignClient(name = "tweetsmanager-service", fallback = HashtagHystrixFallbackFactory.class)
@RequestMapping(value = "/api/hashtags")
public interface HashtagClient {
	
	@GetMapping
	public ResponseEntity<List<Hashtag>> getTopHashTagsUsed(@RequestParam(name = "pageSize", required = false) Integer pageSize);

}
