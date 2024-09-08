package com.example.demo;

import com.example.demo.service.JsonToXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import java.io.File;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private JsonToXmlService jsonToXmlService;
//    private ConverterFactory converterFactory;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 2) {
			System.out.println("ok! to execute: java -jar <build-name> <input.json> <output.xml>");
			return;
		}
		File inputFile = null, outputFile = null;
		String path1 = args[0];
		try {
			Paths.get(path1);
			inputFile = new File(path1);
		} catch (InvalidPathException e) {
			throw new Exception("invalid file path");
		}
		if (path1.length() < 6 || !(path1.substring(path1.length() - 5, path1.length()).equals(".json"))) {
			throw new Exception("not json file");
		}

		String path2 = args[1];
		try {
			Paths.get(path2);
			outputFile = new File(path2);
		} catch (InvalidPathException e) {
			throw new Exception("invalid file path");
		}
		
		if (path2.length() < 5 || !(path2.substring(path2.length() - 4, path2.length()).equals(".xml"))) {
			throw new Exception("not xml file");
		}

		jsonToXmlService.convertJSONtoXML(inputFile, outputFile);
		System.out.println("conversion completed at: " + outputFile.getAbsolutePath());
//        converterFactory.convert(inputFile, outputFile);

	}
}
