package com.labforward.challenge.wordlookupapi.model;

import java.util.List;
import lombok.Data;

@Data
public class Report {

	private Long occurences;
	private List<String> similarities;
	
}
