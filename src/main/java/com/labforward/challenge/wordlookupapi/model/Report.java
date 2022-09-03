package com.labforward.challenge.wordlookupapi.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Report {

    private Long noOfOccurrences = 0L;
    private final Set<String> listOfWords = new HashSet<>();

    public void addSimilarity(String similarString) {
        if (similarString == null || similarString.equals("")) {
            return;
        }
        listOfWords.add(similarString);
    }

    public void incrementOccurrences() {
        noOfOccurrences++;
    }

}
