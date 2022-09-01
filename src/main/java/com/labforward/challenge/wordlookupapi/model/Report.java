package com.labforward.challenge.wordlookupapi.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Report {

    private Long occurrences = 0L;
    private final Set<String> similarities = new HashSet<>();

    public void addSimilarity(String similarString) {
        if (similarString == null || similarString.equals("")) {
            return;
        }
        similarities.add(similarString);
    }

    public void incrementOccurrences() {
        occurrences++;
    }

}
