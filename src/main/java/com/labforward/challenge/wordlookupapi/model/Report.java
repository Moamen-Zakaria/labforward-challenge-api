package com.labforward.challenge.wordlookupapi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Report {

    private Long occurrences = 0L;
    private final List<String> similarities = new ArrayList<>();

    public void addSimilarity(String similarString) {
        if (similarString != null && !similarString.equals("")) {
            return;
        }
        similarities.add(similarString);
    }

    public void incrementOccurrences() {
        occurrences++;
    }

}
