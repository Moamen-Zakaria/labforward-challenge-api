package com.labforward.challenge.wordlookupapi.service;

import com.labforward.challenge.wordlookupapi.model.Report;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.function.Consumer;

@Service
public class LookupService {

    public Report reportText(String text, String queryWord) {

        if (text == null || text.equals("") || queryWord == null || queryWord.equals("")) {
            return new Report();
        }

        //trim query against quotes, spaces and newlines
        String trimmedWord = queryWord.replaceAll("('|\"|\\n|\\s)", "");

        Report resultReport = new Report();

        //routine to index token String in result report
        Consumer<String> indexTokenInReport = token -> {
            if (token.equals(trimmedWord)) {
                resultReport.incrementOccurrences();
            } else if (isLevenshteinDistanceEqualOne(trimmedWord, token)) {
                resultReport.addSimilarity(token);
            }
        };

        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(text));

        streamTokenizer.slashStarComments(false);
        streamTokenizer.slashSlashComments(false);

        try {
            streamTokenizer.nextToken();
            while (streamTokenizer.ttype != StreamTokenizer.TT_EOF) {

                //extract token whether it's number or string
                String token;
                if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    token = Double.toString(streamTokenizer.nval);
                    indexTokenInReport.accept(token);
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
                        || streamTokenizer.ttype == '\''
                        || streamTokenizer.ttype == '"') {
                    token = streamTokenizer.sval;
                    indexTokenInReport.accept(token);
                }
                streamTokenizer.nextToken();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultReport;
    }

    public int levenshteinCompare(String a, String b) {

        char[] string1 = a.toCharArray();
        char[] string2 = b.toCharArray();

        int[] prev = new int[string2.length + 1];

        for (int j = 0; j < string2.length + 1; j++) {
            prev[j] = j;
        }

        for (int i = 1; i < string1.length + 1; i++) {

            int[] curr = new int[string2.length + 1];
            curr[0] = i;

            for (int j = 1; j < string2.length + 1; j++) {
                int d1 = prev[j] + 1;
                int d2 = curr[j - 1] + 1;
                int d3 = prev[j - 1];
                if (string1[i - 1] != string2[j - 1]) {
                    d3 += 1;
                }
                curr[j] = Math.min(Math.min(d1, d2), d3);
            }

            prev = curr;
        }
        return prev[string2.length];
    }

    public boolean isLevenshteinDistanceEqualOne(String string1, String string2) {
        return levenshteinCompare(string1, string2) == 1;
    }


}
