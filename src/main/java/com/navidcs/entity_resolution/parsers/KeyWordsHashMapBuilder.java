package com.navidcs.entity_resolution.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.JsonNode;

public class KeyWordsHashMapBuilder {
	// JsonNode jsonNode;
	// String[] constantKeys;
	//
	// public KeyWordsHashMapBuilder(String[] constantKeys) {
	// this.constantKeys = constantKeys;
	// }

	TreeMap<Character, Integer> charCounter;

	public KeyWordsHashMapBuilder() {
		charCounter = new TreeMap<Character, Integer>();
	}

	public HashMap<String, HashSet<String>> buildKeyWordsHashMap(ArrayList<JsonNode> jsonNodeArrrayList,
			String[] constantKeys) {
		if (constantKeys.length == 0) {
			System.err.println("Error: The size of the constant key array is zero.");
			return null;
		}

		HashMap<String, HashSet<String>> splitedWordsHashMap = new HashMap<String, HashSet<String>>();
		if (jsonNodeArrrayList == null) {
			System.err.println("jsonNode is null");
			return null;
		}

		Boolean isProduct;
		if (constantKeys[0].equals("product_name")) {
			System.out.println("inside products:");
			isProduct = true;
		} else if (constantKeys[0].equals("title")) {
			System.out.println("inside listings:");
			isProduct = false;

		} else {
			System.err.println("Wrong input format: "
					+ "The first element of JSON file should be either \"title\" or \"product_name\"");
			return null;
		}

		for (JsonNode jsonNode : jsonNodeArrrayList) {
			String hashMapKey;
			if (isProduct) {
				hashMapKey = jsonNode.get("product_name").asText();
			} 
			
			else {
				hashMapKey = jsonNode.toString();
			}
			
			HashSet<String> splitedWordsHashSet = buildKeyWordsHashSet(jsonNode, constantKeys);
			splitedWordsHashMap.put(hashMapKey, splitedWordsHashSet);
		}

		showCharCounter();

		return splitedWordsHashMap;
	}

	public HashSet<String> buildKeyWordsHashSet(JsonNode jsonNode, String[] constantKeys) {

		HashSet<String> splitedWordsHashSet = new HashSet<String>();
		for (String key : constantKeys) {
			JsonNode valueJsonNode = jsonNode.get(key);
			if (valueJsonNode == null) {
				// System.err.println("There is no value for key: \"" + key +
				// "\" in line:");
				// System.err.println(jsonNode.asText().toString());
				continue;
			}
			String valueString = valueJsonNode.asText();
			if (valueString == null) {
				System.err.println("bad input at this line");
				System.err.println(jsonNode.asText());
				System.err.println("there is not value for key = " + key);
				return null;
			}
			addStringToCharCounter(valueString);
			String[] splitedValueArray = valueString.split("[^A-Za-z0-9.]");
			for (String splitedWord : splitedValueArray) {
				splitedWord = splitedWord.toLowerCase();
				if (!splitedWordsHashSet.contains(splitedWord)) {
					splitedWordsHashSet.add(splitedWord);
				}
			}

		}
		return splitedWordsHashSet;

	}
	
	private void showCharCounter() {
		for(char c: charCounter.keySet()){
			System.out.println(c+" "+charCounter.get(c));
		}

	}

	private void addStringToCharCounter(String valueString) {
		for (char ch : valueString.toCharArray()) {
			
			if (charCounter.containsKey(ch)) {
				charCounter.put(ch, charCounter.get(ch) + 1);
			} else {
				
				charCounter.put(ch, 1);
			}
		}
	}

}
