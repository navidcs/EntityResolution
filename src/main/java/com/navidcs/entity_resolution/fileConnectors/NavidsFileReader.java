package com.navidcs.entity_resolution.fileConnectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class NavidsFileReader {

	BufferedReader bufferedReader = null;
	StringBuilder stringBuilder = new StringBuilder();
	ArrayList<String> inputArrayList = new ArrayList<String>();
	FileInputStream fileInputStream = null;
	InputStreamReader inputStreamReader = null;

	public ArrayList<String> convertFileToStringArrayList(String path) {

		if (!validPath(path)) {
			System.err.println("Could not find the input file");
			System.err.println("Please che the path:");
			System.err.println(path);
			return null;
		}
		
		try {
			File fileDir = new File(path);

			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String str;

			while ((str = in.readLine()) != null) {
				inputArrayList.add(str);
			}

			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return inputArrayList;

	}

	private void closeStreams() {

		try {

			if (fileInputStream != null)
				fileInputStream.close();

			if (inputStreamReader != null)

				inputStreamReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean validPath(String path) {

		try {
			bufferedReader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
