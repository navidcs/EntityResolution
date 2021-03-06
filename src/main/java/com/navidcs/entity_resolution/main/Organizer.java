package com.navidcs.entity_resolution.main;

import com.navidcs.entity_resolution.parsers.InputCompiler;

public class Organizer {

	public final static String PRODUCTS_PATH="src/main/resources/products.txt";
	public final static String LISTINGS_PATH="src/main/resources/listings.txt";

	
	InputCompiler inputCompiler;
	ResultBuilder resultBuilder;

	public void run() {
		System.out.println("Compiling input files ...");
		inputCompiler = new InputCompiler(PRODUCTS_PATH,LISTINGS_PATH);
		inputCompiler.run();
		System.out.println("Building the result ...");
		resultBuilder = new ResultBuilder(inputCompiler.getProductsHashMap(), inputCompiler.getListinngsHashMap());
		resultBuilder.run();
		System.out.println("results.txt is built successfully in \"src/main/resources/\" folder.");
	}
}
