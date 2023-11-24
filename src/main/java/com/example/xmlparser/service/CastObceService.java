package com.example.xmlparser.service;

import com.example.xmlparser.entity.CastObce;
import com.example.xmlparser.parser.CastObceHandler;
import com.example.xmlparser.repository.CastObceRepository;
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
public class CastObceService {
    private final CastObceRepository castObceRepository;
    private final SAXParserFactory saxParserFactory;

    public CastObceService(CastObceRepository castObceRepository, SAXParserFactory saxParserFactory) {
        this.castObceRepository = castObceRepository;
        this.saxParserFactory = saxParserFactory;
    }


    public String parseCastObce(File file) throws ParserConfigurationException, SAXException, IOException {
        if (file.getName().endsWith(".XML") && file.isFile()&& file.getName().contains("20210331_OB_573060_UZSZ")) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            CastObceHandler castObceHandler = new CastObceHandler();

            FileInputStream fileInputStream = new FileInputStream(file);
            saxParser.parse(fileInputStream, castObceHandler);
            List<CastObce> castObceList = castObceHandler.getCastObceList();
            castObceRepository.saveAll(castObceList);
            fileInputStream.close();
        }

        return null;
    }
}
