package com.navidcs.entity_resolution.converters;

import java.util.HashMap;
import java.util.HashSet;

public class ProductsAndListingsHashMapToResultsHashMapConverter {
	
	HashMap<String, HashSet<String>> productsHashMap;
	HashMap<String, HashSet<String>> listingsHashMap;	
	HashMap<String, HashSet<String>> resultsFromProductNameToListingsHashMap;	
	
	public ProductsAndListingsHashMapToResultsHashMapConverter(HashMap<String, HashSet<String>> productsHashMap,
			HashMap<String, HashSet<String>> listingsHashMap) {
		this.productsHashMap = productsHashMap;
		this.listingsHashMap = listingsHashMap;
		resultsFromProductNameToListingsHashMap = new HashMap<String, HashSet<String>>();
	}
	
	
	
	public HashMap<String, HashSet<String>> getProductsHashMap() {
		return productsHashMap;
	}



	public void setProductsHashMap(HashMap<String, HashSet<String>> productsHashMap) {
		this.productsHashMap = productsHashMap;
	}



	public HashMap<String, HashSet<String>> getListingsHashMap() {
		return listingsHashMap;
	}



	public void setListingsHashMap(HashMap<String, HashSet<String>> listingsHashMap) {
		this.listingsHashMap = listingsHashMap;
	}



	public HashMap<String, HashSet<String>> getResultsHashMap() {
		return resultsFromProductNameToListingsHashMap;
	}



	public void setResultsHashMap(HashMap<String, HashSet<String>> resultsHashMap) {
		this.resultsFromProductNameToListingsHashMap = resultsHashMap;
	}



	public void run() {

		for (String productKey : productsHashMap.keySet()) {
			HashSet<String> productHashSet = productsHashMap.get(productKey);
			HashSet<String> matchedListingsForProductKey = new HashSet<String>();
			for (String listingKey : listingsHashMap.keySet()) {
				HashSet<String> listingsHashSet = listingsHashMap.get(listingKey);
				boolean allElementsInProductExistInListing = true;
				for (String productElementInProductHashSet : productHashSet) {
					if (!listingsHashSet.contains(productElementInProductHashSet)) {
						allElementsInProductExistInListing = false;
						break;
					}
				}
				if (allElementsInProductExistInListing) {
					matchedListingsForProductKey.add(listingKey);
				}
			}
			if (matchedListingsForProductKey.size() != 0) {
				resultsFromProductNameToListingsHashMap.put(productKey, matchedListingsForProductKey);
				System.out.println("productKey = " + productKey);
				for (String string : productHashSet) {
					System.out.print(string + " ");
				}
				System.out.println("listings:");
				for (String string : matchedListingsForProductKey)
					System.out.println(string);
				System.out.println("-------------");
			}

		}

	}

}
