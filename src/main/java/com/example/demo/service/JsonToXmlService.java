package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JsonToXmlService {

    private final ObjectMapper jsonMapper;
    private final XmlMapper xmlMapper;

    public JsonToXmlService() {
        this.jsonMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
    }

    public void convertJsonToXml(File inputFile, File outputFile) throws IOException {
        // Read JSON data into a JsonNode
        JsonNode jsonNode = jsonMapper.readTree(inputFile);
        
        // Write JsonNode as XML
        xmlMapper.writeValue(outputFile, jsonNode);
    }
}
