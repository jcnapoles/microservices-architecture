package com.acciona.storage.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acciona.storage.model.Hashtag;
@Component
public class HashtagHystrixFallbackFactory implements HashtagClient{

	@Override
	public ResponseEntity<List<Hashtag>> getTopHashTagsUsed(Integer pageSize) {		
		return ResponseEntity.ok(new ArrayList<Hashtag>());
	}

}
