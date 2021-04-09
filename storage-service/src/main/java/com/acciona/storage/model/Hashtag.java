package com.acciona.storage.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hashtag {
	
	private Long id;
	
	private String text;
}
