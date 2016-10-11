package com.navidcs.entity_resolution.main;

import java.util.HashMap;
import java.util.HashSet;

import com.navidcs.entity_resolution.converters.HashMapToJsonFormatStringHashSetConverter;
import com.navidcs.entity_resolution.converters.ProductsAndListingsHashMapToResultsHashMapConverter;
import com.navidcs.entity_resolution.fileConnectors.NavidsFileWriter;

public class ResultBuilder {
	HashMap<String, HashSet<String>> productsHashMap;
	HashMap<String, HashSet<String>> listingsHashMap;
	HashMap<String, HashSet<String>> resultsFromProductNameToListingsHashMap;
	HashSet<String> processedResultsHashSet;

	final static String RESULTS_FILE_PATH_STRING = "src/main/resources/results.txt";

	public ResultBuilder(HashMap<String, HashSet<String>> productsHashMap,
			HashMap<String, HashSet<String>> listinngsHashMap) {
		this.productsHashMap = productsHashMap;
		this.listingsHashMap = listinngsHashMap;
		resultsFromProductNameToListingsHashMap = new HashMap<String, HashSet<String>>();
	}

	public void run() {
		createResultsHashMap();
		createProcessedResultsHashSet();
		writeResultsToFile();
	}

	public void createResultsHashMap() {
		ProductsAndListingsHashMapToResultsHashMapConverter productsAndListingsHashMapToResultsHashMapConverter = new ProductsAndListingsHashMapToResultsHashMapConverter(
				productsHashMap, listingsHashMap);
		productsAndListingsHashMapToResultsHashMapConverter.run();
		resultsFromProductNameToListingsHashMap = productsAndListingsHashMapToResultsHashMapConverter
				.getResultsHashMap();

	}

	public void createProcessedResultsHashSet() {
		HashMapToJsonFormatStringHashSetConverter hashMapToJsonFormatStringHashSetConverter = new HashMapToJsonFormatStringHashSetConverter(
				resultsFromProductNameToListingsHashMap);
		hashMapToJsonFormatStringHashSetConverter.run();
		processedResultsHashSet = hashMapToJsonFormatStringHashSetConverter.getProcessedResultsHashSet();
	}

	public void writeResultsToFile() {
		NavidsFileWriter navidsFileWriter = new NavidsFileWriter(processedResultsHashSet, RESULTS_FILE_PATH_STRING);
		navidsFileWriter.run();

	}

}
