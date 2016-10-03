package com.navidcs.entity_resolution.converters;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductsAndListingsHashMapToResultsHashMapConverterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetResultsHashMap() {
		HashMap<String, HashSet<String>> productHashMap = new HashMap<String, HashSet<String>>();
		HashSet<String> productHashSet = new HashSet<String>();
		productHashSet.add("Leica".toLowerCase());
		productHashSet.add("Digilux".toLowerCase());
		productHashSet.add("4.3".toLowerCase());
		productHashMap.put("Leica_Digilux_4.3", productHashSet);
		
		
		HashMap<String, HashSet<String>> listingsHashMap = new HashMap<String, HashSet<String>>();
		HashSet<String> listingHashSet1 = new HashSet<String>();
		listingHashSet1.add("Canon".toLowerCase());
		listingHashSet1.add("PowerShot".toLowerCase());
		listingHashSet1.add("A1200".toLowerCase());
		listingHashSet1.add("Black".toLowerCase());
		listingHashSet1.add("Canada".toLowerCase());
		listingHashSet1.add("Canon".toLowerCase());
		listingHashSet1.add("Canon".toLowerCase());
		String listingString1 = "\"{\"title\":\"Canon PowerShot A1200 (Black)\",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"129.99\"}";
		listingsHashMap.put(listingString1, listingHashSet1);
		
		HashSet<String> listingHashSet2 = new HashSet<String>();
		listingHashSet2.add("Leica".toLowerCase());
		listingHashSet2.add("DIGILUX".toLowerCase());
		listingHashSet2.add("3".toLowerCase());
		listingHashSet2.add("4.3MP".toLowerCase());
		listingHashSet2.add("Digital".toLowerCase());
		listingHashSet2.add("SLR".toLowerCase());
		listingHashSet2.add("Camera".toLowerCase());
		listingHashSet2.add("with".toLowerCase());
		listingHashSet2.add("Leica".toLowerCase());
		listingHashSet2.add("D".toLowerCase());
		listingHashSet2.add("4".toLowerCase());
		listingHashSet2.add("50mm".toLowerCase());
		listingHashSet2.add("f".toLowerCase());
		listingHashSet2.add("2.8".toLowerCase());
		listingHashSet2.add("3.4".toLowerCase());
		listingHashSet2.add("ASPH".toLowerCase());
		listingHashSet2.add("".toLowerCase());
		String listingString2 = "\"{\"title\":\"Leica DIGILUX 3 4.3MP Digital SLR Camera with Leica"
				+ " D 4-50mm f/2.8-3.4 ASPH Lens\",\"manufacturer\":\"Leica Canada\",\"currency\":\"CAD\",\"price\":\"119.99\"}";
		listingsHashMap.put(listingString2, listingHashSet2);
		
		HashSet<String> listingHashSet3 = new HashSet<String>();
		listingHashSet3.add("Leica".toLowerCase());
		listingHashSet3.add("DIGILUX".toLowerCase());
		listingHashSet3.add("4.3".toLowerCase());
		listingHashSet3.add("2.4MP".toLowerCase());
		listingHashSet3.add("Digital".toLowerCase());
		listingHashSet3.add("Camera".toLowerCase());
		listingHashSet3.add("w".toLowerCase());
		listingHashSet3.add("3x".toLowerCase());
		listingHashSet3.add("Optical".toLowerCase());
		listingHashSet3.add("Zoom".toLowerCase());
		String listingString3 = "\"{\"title\":\"Leica DIGILUX 4.3 2.4MP Digital Camera w/ 3x Optical Zoom\""
				+ ",\"manufacturer\":\"Leica Canada\",\"currency\":\"CAD\",\"price\":\"119.99\"}";
		listingsHashMap.put(listingString3, listingHashSet3);
		
		ProductsAndListingsHashMapToResultsHashMapConverter productsAndListingsHashMapToResultsHashMapConverter = new ProductsAndListingsHashMapToResultsHashMapConverter(productHashMap, listingsHashMap);
		productsAndListingsHashMapToResultsHashMapConverter.run();
		HashMap<String, HashSet<String>> resultsHashMap = productsAndListingsHashMapToResultsHashMapConverter.getResultsHashMap();
		assertEquals(1, resultsHashMap.size());
		String productName = "Leica_Digilux_4.3";
		assertTrue(resultsHashMap.containsKey(productName));
		assertFalse(resultsHashMap.get(productName).contains(listingString1));
		assertFalse(resultsHashMap.get(productName).contains(listingString2));
		assertTrue(resultsHashMap.get(productName).contains(listingString3));
			
		
	}

}
