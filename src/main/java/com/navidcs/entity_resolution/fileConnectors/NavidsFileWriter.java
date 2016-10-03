package com.navidcs.entity_resolution.fileConnectors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

public class NavidsFileWriter {
	final static String RESULTS_FILE_PATH_STRING = "resources/results.txt";
	HashSet<String> processedResultsHashSet;

	public NavidsFileWriter(HashSet<String> processedResultsHashSet) {
		this.processedResultsHashSet = processedResultsHashSet;
	}

	public void run() {

		Writer writer = null;
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(RESULTS_FILE_PATH_STRING), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			for (String lineString : processedResultsHashSet) {
				writer.write(lineString);
				writer.write('\n');
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
