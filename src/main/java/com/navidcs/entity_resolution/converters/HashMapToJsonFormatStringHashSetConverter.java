package com.navidcs.entity_resolution.converters;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class HashMapToJsonFormatStringHashSetConverter {
	
	final static String PRODUCT_NAME_STRING= "product_name";
	final static String LISTINGS_STRING = "listings";
	
	HashMap<String, HashSet<String>> resultsHashMap ;
	HashSet<String> processedResultsHashSet;
	public HashMapToJsonFormatStringHashSetConverter(HashMap<String, HashSet<String>> hashMap) {
		this.resultsHashMap = hashMap;
		processedResultsHashSet = new HashSet<String>();
	}


	public HashMap<String, HashSet<String>> getResultsHashMap() {
		return resultsHashMap;
	}


	public void setResultsHashMap(HashMap<String, HashSet<String>> resultsHashMap) {
		this.resultsHashMap = resultsHashMap;
	}


	public HashSet<String> getProcessedResultsHashSet() {
		return processedResultsHashSet;
	}


	public void setProcessedResultsHashSet(HashSet<String> processedResultsHashSet) {
		this.processedResultsHashSet = processedResultsHashSet;
	}


	public void run() {
		for (Map.Entry<String, HashSet<String>> entry : resultsHashMap.entrySet()) {
			processedResultsHashSet.add(hashMapEnteryToJsonFormatStringHashSetEnteryConverter(entry));
			
		}
		
	}
	
	public String hashMapEnteryToJsonFormatStringHashSetEnteryConverter (Map.Entry<String, HashSet<String>> entry) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");

		stringBuilder.append("\"");
		stringBuilder.append(PRODUCT_NAME_STRING);
		stringBuilder.append("\"");

		stringBuilder.append(":");

		stringBuilder.append("\"");
		stringBuilder.append(entry.getKey());
		stringBuilder.append("\"");
	
		stringBuilder.append(",");

		stringBuilder.append("\"");
		stringBuilder.append(LISTINGS_STRING);
		stringBuilder.append("\"");

		stringBuilder.append(":");
		
		stringBuilder.append("[");
		
		for (String listingString : entry.getValue()) {
			
			stringBuilder.append(listingString);

			stringBuilder.append(",");
		}
		
		if (!entry.getKey().isEmpty()) {
			stringBuilder.setLength(stringBuilder.length() -1);
		}
		stringBuilder.append("]");
		
		stringBuilder.append("}");
		
		return stringBuilder.toString();
	}
	
	

}
