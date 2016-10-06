package com.navidcs.entity_resolution.fileConnectors;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class NavidsFileWriter {
	HashSet<String> processedResultsHashSet;
	String path;
	public NavidsFileWriter(HashSet<String> processedResultsHashSet, String path) {
		this.processedResultsHashSet = processedResultsHashSet;
		this.path = path;
	}

	public void run() {

		Writer writer = null;
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
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
