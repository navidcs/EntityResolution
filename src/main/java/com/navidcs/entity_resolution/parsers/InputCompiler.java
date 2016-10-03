package com.navidcs.entity_resolution.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.fasterxml.jackson.databind.JsonNode;
import com.navidcs.entity_resolution.converters.StringToJasonArrayList;
import com.navidcs.entity_resolution.fileConnectors.NavidsFileReader;

public class InputCompiler {

	final static String[] PRODUCT_KEYS = { "product_name", "manufacturer", "model", "family" };
	final static String[] LISTING_KEYS = { "title", "manufacturer" };

	String productsPath;
	String listingsPath;

	ArrayList<String> productsStringArrayList;
	ArrayList<String> listingsStringArrayList;

	ArrayList<JsonNode> productsJsonArrayList;
	ArrayList<JsonNode> listingsJsonArrayList;

	HashMap<String, HashSet<String>> productsHashMap;
	HashMap<String, HashSet<String>> listingsHashMap;


	public InputCompiler(String pp, String lp) {
		productsPath = pp;
		listingsPath = lp;
	}

	public HashMap<String, HashSet<String>> getProductsHashMap() {
		return productsHashMap;
	}

	public HashMap<String, HashSet<String>> getListinngsHashMap() {
		return listingsHashMap;
	}

	public void run() {
		createStringArrayLists();
		createJsonArrayLists();
		createHashMaps();

	}

	public void createHashMaps() {
		KeyWordsHashMapBuilder keyWordsHashMapBuilder = new KeyWordsHashMapBuilder();
		productsHashMap = keyWordsHashMapBuilder.buildKeyWordsHashMap(productsJsonArrayList, PRODUCT_KEYS);
//		showHashMap(productsHashMap);
		listingsHashMap = keyWordsHashMapBuilder.buildKeyWordsHashMap(listingsJsonArrayList, LISTING_KEYS);
//		showHashMap(listingsHashMap);
	}

	public void showHashMap(HashMap<String, HashSet<String>> hashMap) {
		for (String key : hashMap.keySet()) {
			System.out.println("key = " + key);
			System.out.println("values are:");
			HashSet<String> hashSet = hashMap.get(key);
			for (String value : hashSet) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

//	 public void createProductsArrayList() {
	// JsonToProductConverter jsonToProductConverter = new
	// JsonToProductConverter(productsJsonArrayList);
	// productsArrayList = jsonToProductConverter.getProductArrayList();
//	 }

//	public void createListingsArrayList() {
//		JsonToListingConverter jsonToListingConverter = new JsonToListingConverter(listingsJsonArrayList);
//		listingsStringArrayList= jsonToListingConverter.getListingStringArrayList();
//	}

	public void createStringArrayLists() {
		productsStringArrayList = createStringArrayList(productsPath);
		listingsStringArrayList = createStringArrayList(listingsPath);

	}

	public ArrayList<String> createStringArrayList(String path) {
		NavidsFileReader navidsFileReader = new NavidsFileReader();
		return navidsFileReader.convertFileToStringArrayList(path);

	}

	public void createJsonArrayLists() {
		productsJsonArrayList = createJsonArrayList(productsStringArrayList);
		listingsJsonArrayList = createJsonArrayList(listingsStringArrayList);
	}

	public ArrayList<JsonNode> createJsonArrayList(ArrayList<String> stringArrayListArrayList) {
		StringToJasonArrayList stringToJasonArrayList = new StringToJasonArrayList(stringArrayListArrayList);
		stringToJasonArrayList.run();
		return stringToJasonArrayList.getJsonArrayList();

	}

	// public ArrayList<JsonNode>
	// convertStringArrayListToObject(ArrayList<String> stringArrayList) {
	// if (stringArrayList == null) {
	// System.out.println("null p string arraylilst ");
	// return null;
	// }
	// StringToJasonArrayList stringToJasonArrayList = new
	// StringToJasonArrayList(stringArrayList);
	// productsJsonArrayList = stringToJasonArrayList.getJsonArrayList();
	//
	// System.out.println("json:");
	// System.out.println(productsJsonArrayList.get(0).get("manufacturer").toString());
	//
	// }

}
