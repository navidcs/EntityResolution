package com.navidcs.entity_resolution.converters;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringToJasonArrayList {

	ArrayList<String> linesInTextFileString;
	ArrayList<JsonNode> jsonNodesArrayList;
	ObjectMapper mapper;
	

	public StringToJasonArrayList(ArrayList<String> stringArrayList) {
		linesInTextFileString = stringArrayList;
		jsonNodesArrayList = new ArrayList<JsonNode>();
	}

	public void run() {
//		ArrayList<JsonNode> jsonNodesArrayList = new ArrayList<JsonNode>();
		ObjectMapper mapper = new ObjectMapper();
//		System.out.println("after object mapper");
		for (String string : linesInTextFileString) {
//			System.out.println(count++);
//			System.out.println(string);
			StringToJasonLine stringToJasonLine = new StringToJasonLine(string, mapper);
			stringToJasonLine.run();
			jsonNodesArrayList.add(stringToJasonLine.getJsonNode());
		}
		
	}

	public ArrayList<JsonNode> getJsonArrayList() {

		return jsonNodesArrayList;
	}

}
