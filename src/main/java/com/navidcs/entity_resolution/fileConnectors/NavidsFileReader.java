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
	// HashMapBuilder hashMapBuilder;

	public ArrayList<String> convertFileToStringArrayList(String path) {

		// char ch;
		// int readerResult;

		// File file = new File(path);
		// try {
		// inputArrayList = (ArrayList<String>) FileUtils.readLines(file,
		// "UTF-8");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		

		 try {
		 File fileDir = new File(path);
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(new
		 FileInputStream(fileDir), "UTF8"));
		
		 String str;
		
		 while ((str = in.readLine()) != null) {
		 inputArrayList.add(str);
		 System.out.println("adding: " + str);
		 }
		
		 in.close();
		 } catch (UnsupportedEncodingException e) {
		 System.out.println(e.getMessage());
		 } catch (IOException e) {
		 System.out.println(e.getMessage());
		 } catch (Exception e) {
		 System.out.println(e.getMessage());
		 }

//		try {
//			fileInputStream = new FileInputStream(path);
//			inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//			System.out.println("path = " + path);
//			System.out.println(inputStreamReader.toString());
//			while ((readerResult = inputStreamReader.read()) != -1) {
//
//				ch = (char) readerResult;
//				System.out.print(ch);
//				if (ch == '\n') {
//					String correctDecoded = URLDecoder.decode(stringBuilder.toString(), "UTF-8");
//					inputArrayList.add(correctDecoded.toString());
//					System.out.println(stringBuilder.toString() + "\n has been added to arrayList");
//
//					stringBuilder.setLength(0);
//
//				} else {
//					stringBuilder.append(ch);
//				}
//
//			}
//			if (stringBuilder.length() != 0) {
//
//				String correctDecoded = URLDecoder.decode(stringBuilder.toString(), "UTF-8");
//				inputArrayList.add(correctDecoded.toString());
//				System.out.println(stringBuilder.toString() + "\n has been added to arrayList");
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		} finally {
//			closeStreams();
//
//		}

		// String line;
		// if (validPath(path)) {
		// try {
		// while ((line = bufferedReader.readLine()) != null) {
		// System.out.println(line);
		// inputArrayList.add(line);
		// }
		//
		// bufferedReader.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// }
		// if (inputArrayList.size() == 0) {
		// System.err.println("The file is empty. Please check the file path:");
		// System.err.println(path);
		//
		// }
		System.out.println("\nsize of arraylist in " + path + " is " + inputArrayList.size());

		return inputArrayList;

	}

	private void closeStreams() {

		try {

			if (fileInputStream != null)
				fileInputStream.close();

			if (inputStreamReader != null)

				inputStreamReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
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
