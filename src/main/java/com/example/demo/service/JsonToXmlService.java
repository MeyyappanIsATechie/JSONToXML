package com.example.demo.service;

import com.example.demo.XMLJSONConverterI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JsonToXmlService implements XMLJSONConverterI {

	private final ObjectMapper jsonMapper;
	private final XmlMapper xmlMapper;

	public JsonToXmlService() {
		this.jsonMapper = new ObjectMapper();
		this.xmlMapper = new XmlMapper();
	}

	public void convertJSONtoXML(File inputFile, File outputFile) throws IOException {
		JsonNode jsonNode = jsonMapper.readTree(inputFile);
		xmlMapper.writeValue(outputFile, jsonNode);
	}
}
