package com.navidcs.entity_resolution.converters;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringToJasonLine {
	String line;
	ObjectMapper mapper;
	JsonNode jsonNode;
	
	public StringToJasonLine(String line, ObjectMapper mapper) {
		this.line = line;
		this.mapper = mapper;
	}
	
	
	public String getLine() {
		return line;
	}


	public void setLine(String line) {
		this.line = line;
	}


	public ObjectMapper getMapper() {
		return mapper;
	}


	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}


	public void setJsonNode(JsonNode jsonNode) {
		this.jsonNode = jsonNode;
	}


	public void run() {
		try {
			jsonNode =  mapper.readTree(line);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (jsonNode == null) {
			System.err.println("couln't convert this line to JSON:");
			System.err.println(line);
		}
		else {
			System.out.println("json manfacturor" + jsonNode.get("manufacturer"));
		}
	}
	
	public JsonNode getJsonNode() {
	
		return jsonNode;
	}

}
