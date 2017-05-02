package com.application.components.bagofwords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chlitsas, 28.04.17.
 */
public class BagOfWordsCalculator {
    /**
     *
     * @param text the input text
     * @param threshold include in the bag only words with frequency >= threshold
     * @param wordsToExclude list of words to exclude from the bag
     * @return the bag of words as a map of words (the keys) with numbers (the frequencies)
     */
    public static Map<String, Integer> getMostFrequentWords(
            String text,
            Integer threshold,
            List<String> wordsToExclude
    ) {
        return filter(getFrequencyTable(text), threshold, wordsToExclude);
    }

    private static Map<String, Integer> getFrequencyTable(String text) {
        String words[] = text.split("\\W+");
        Map<String, Integer> result =
                Arrays.asList(words).stream().reduce(new HashMap<String, Integer>(),
                        (map, word) -> {
                            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
                            return map;
                        },
                        (map1, map2) -> null);
        return result;
    }

    private static Map<String, Integer> filter(
            Map<String, Integer> frequencyTable,
            Integer threshold,
            List<String> wordsToExclude
    ) {
        Map<String, Integer> result = frequencyTable.entrySet().stream()
                .filter(element -> element.getValue() >= threshold && !wordsToExclude.contains(element.getKey()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        return result;
    }
}
