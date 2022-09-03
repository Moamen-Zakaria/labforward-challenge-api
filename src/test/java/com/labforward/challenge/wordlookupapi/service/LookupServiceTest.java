package com.labforward.challenge.wordlookupapi.service;

import com.labforward.challenge.wordlookupapi.model.Report;
import org.junit.jupiter.api.*;

class LookupServiceTest {

    private LookupService lookupService = new LookupService();

    @Test
    @DisplayName("Call reportText with null arguments")
    void reportTextWithNullParameters() {
        Report report = lookupService.reportText(null, null);
        Assertions.assertEquals(0, report.getListOfWords().size());
        Assertions.assertEquals(0, report.getNoOfOccurrences());
    }

    @Test
    @DisplayName("Call reportText")
    void reportText() {
        Report report = lookupService.reportText("ext text", "text");
        Assertions.assertEquals(1, report.getListOfWords().size());
        Assertions.assertEquals(1, report.getNoOfOccurrences());
    }

    @Test
    @DisplayName("levenshtein algorithm")
    void levenshteinCompare() {
        Assertions.assertEquals(1, lookupService.levenshteinCompare("abc", "abd"));
        Assertions.assertEquals(2, lookupService.levenshteinCompare("zzc", "abc"));
        Assertions.assertEquals(2, lookupService.levenshteinCompare("abc", "a"));
    }

    @Test
    @DisplayName("check if Levenshtein Distance equal to one")
    void isLevenshteinDistanceEqualOne() {
        Assertions.assertEquals(true, lookupService.isLevenshteinDistanceEqualOne("abc", "abd"));
        Assertions.assertEquals(false, lookupService.isLevenshteinDistanceEqualOne("zzc", "abc"));
        Assertions.assertEquals(false, lookupService.isLevenshteinDistanceEqualOne("abc", "a"));
    }
}