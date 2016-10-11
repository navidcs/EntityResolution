/**
 * 
 */
package com.navidcs.entity_resolution.parsers;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author navid
 *
 */
public class InputCompilerTest {

	InputCompiler inputCompiler;
	String productsPath;
	String listingsPath;
	HashMap<String, HashSet<String>> expectedProductsHashMap;
	HashMap<String, HashSet<String>> expectedListingsHashMap;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		productsPath = "src/test/resources/p2.txt";
		listingsPath = "src/test/resources/l2.txt";
		inputCompiler = new InputCompiler(productsPath, listingsPath);
		inputCompiler.run();

		setUpExpectedProducts();

		setUpExpectedListings();

	}

	private void setUpExpectedProducts() {
		expectedProductsHashMap = new HashMap<String, HashSet<String>>();

		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("leica");
		hashSet1.add("digilux");
		expectedProductsHashMap.put("Leica_Digilux", hashSet1);

		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("sony");
		hashSet2.add("cyber");
		hashSet2.add("shot");
		hashSet2.add("dsc");
		hashSet2.add("w310");
		expectedProductsHashMap.put("Sony_Cyber-shot_DSC-W310", hashSet2);

	}

	private void setUpExpectedListings() {
		expectedListingsHashMap = new HashMap<String, HashSet<String>>();

		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("canon");
		hashSet1.add("powershot");
		hashSet1.add("a1200");
		hashSet1.add("black");
		hashSet1.add("canada");
		expectedListingsHashMap.put("Canon PowerShot A1200 (Black)", hashSet1);

		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("leica");
		hashSet2.add("digilux");
		hashSet2.add("4.3");
		hashSet2.add("2.4MP");
		hashSet2.add("digital");
		hashSet2.add("camera");
		hashSet2.add("w");
		hashSet2.add("3x");
		hashSet2.add("optical");
		hashSet2.add("zoom");
		expectedListingsHashMap.put("Leica_Digilux", hashSet2);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.navidcs.entity_resolution.parsers.InputCompiler#getProductsHashMap()}.
	 */
	@Test
	public void testProductsHashMapsSize() {
		assertEquals(expectedProductsHashMap.size(), inputCompiler.getProductsHashMap().size());
	}

	/**
	 * Test method for
	 * {@link com.navidcs.entity_resolution.parsers.InputCompiler#getListinngsHashMap()}.
	 */
	@Test
	public void testListingsHashMapsSize() {
		assertEquals(expectedListingsHashMap.size(), inputCompiler.getListinngsHashMap().size());
	}

}
