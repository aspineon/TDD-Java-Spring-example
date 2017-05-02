package com.application;

import com.application.components.bagofwords.BagOfWordsCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagOfWordsCalculatorUnitTests {

	@Test
	public void checkEmptyText() {
		String text = "";
		Integer threshold = 3;
		List<String> wordsToExclude = new ArrayList<>();
		Map<String, Integer> expectedResult = new HashMap<>();
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

	@Test
	public void checkEmptyResultBecauseOfThreshold() {
		String text = "a b c d e f a b c d e f f f f f";
		int threshold = Integer.MAX_VALUE;
		List<String> wordsToExclude = new ArrayList<>();
		Map<String, Integer> expectedResult = new HashMap<>();
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

	@Test
	public void checkThreshold() {
		String text = "a b c d e f";
		int threshold = 3;
		List<String> wordsToExclude = new ArrayList<>();
		Map<String, Integer> expectedResult = new HashMap<>();
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

	@Test
	public void checkLimit() {
		String text = "a b c d b a a";
		int threshold = 2;
		List<String> wordsToExclude = new ArrayList<>();
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("a", 3);
		expectedResult.put("b", 2);
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

	@Test
	public void checkExcludedWords() {
		String text = "a b c d b a a a";
		int threshold = 2;
		List<String> wordsToExclude = new ArrayList<>();
		wordsToExclude.add("a");
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("b", 2);
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

	@Test
	public void checkSplitCharacters() {
		String text = "a,b-a.b  b\na a a";
		int threshold = 2;
		List<String> wordsToExclude = new ArrayList<>();
		Map<String, Integer> expectedResult = new HashMap<>();
		expectedResult.put("a", 5);
		expectedResult.put("b", 3);
		Assert.assertEquals(expectedResult, BagOfWordsCalculator.getMostFrequentWords(text, threshold, wordsToExclude));
	}

}
