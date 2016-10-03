package com.navidcs.entity_resolution.main;

import com.navidcs.entity_resolution.parsers.InputCompiler;

public class Organizer {

	public final static String PRODUCTS_PATH="resources/products.txt";
	public final static String LISTINGS_PATH="resources/listings.txt";

	
	InputCompiler inputCompiler;
	ResultBuilder resultBuilder;

	public void run() {
		inputCompiler = new InputCompiler(PRODUCTS_PATH,LISTINGS_PATH);
		inputCompiler.run();
		resultBuilder = new ResultBuilder(inputCompiler.getProductsHashMap(), inputCompiler.getListinngsHashMap());
		resultBuilder.run();
		System.out.println("intégré");
	}
}
