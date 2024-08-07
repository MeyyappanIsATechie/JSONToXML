package com.example.demo;

import com.example.demo.service.JsonToXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private JsonToXmlService jsonToXmlService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java -jar <input.json> <output.xml>");
            return;
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        jsonToXmlService.convertJsonToXml(inputFile, outputFile);
        System.out.println("Conversion completed: " + outputFile.getAbsolutePath());
    }
}
