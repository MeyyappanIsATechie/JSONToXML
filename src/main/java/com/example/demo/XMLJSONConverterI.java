package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

public interface XMLJSONConverterI {
	public void convertJSONtoXML(File input, File output) throws IOException;
}
