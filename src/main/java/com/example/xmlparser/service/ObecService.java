package com.example.xmlparser.service;

import com.example.xmlparser.entity.Obec;
import com.example.xmlparser.parser.ObecHandler;
import com.example.xmlparser.repository.ObecRepository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ObecService {
    private final ObecRepository obecRepository;
    private final SAXParserFactory saxParserFactory;

    public ObecService(ObecRepository obecRepository, SAXParserFactory saxParserFactory) {
        this.obecRepository = obecRepository;
        this.saxParserFactory = saxParserFactory;
    }


    public String parseObec(File file) throws ParserConfigurationException, SAXException, IOException {
        if (file.getName().endsWith(".XML") && file.isFile()&& file.getName().contains("20210331_OB_573060_UZSZ")) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ObecHandler obecHandler = new ObecHandler();

            FileInputStream fileInputStream = new FileInputStream(file);
            saxParser.parse(fileInputStream, obecHandler);
            List<Obec> obecList = obecHandler.getObecList();
            obecRepository.saveAll(obecList);
            fileInputStream.close();
        }

        return null;
    }
}
