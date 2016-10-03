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
		ObjectMapper mapper = new ObjectMapper();
		for (String string : linesInTextFileString) {
			StringToJasonLine stringToJasonLine = new StringToJasonLine(string, mapper);
			stringToJasonLine.run();
			jsonNodesArrayList.add(stringToJasonLine.getJsonNode());
		}
		
	}

	public ArrayList<JsonNode> getJsonArrayList() {

		return jsonNodesArrayList;
	}

}
