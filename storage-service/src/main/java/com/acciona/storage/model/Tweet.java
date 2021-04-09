package com.acciona.storage.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tweet {
	
	private Long id;
	
	private String idSstr;
	
	private String text;
	
	private Boolean validation;
	
	private String language;
	
	private User user;
	
	private Place place;
	
	private Hashtag[] hashtags;

}
