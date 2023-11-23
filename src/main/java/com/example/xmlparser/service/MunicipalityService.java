package com.example.xmlparser.service;

import com.example.xmlparser.entity.Municipality;
import com.example.xmlparser.parser.MunicipalityParser;
import com.example.xmlparser.repository.MunicipalityRepository;
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
public class MunicipalityService {
    private final MunicipalityRepository municipalityRepository;
    private final SAXParserFactory saxParserFactory;

    public MunicipalityService(MunicipalityRepository municipalityRepository, SAXParserFactory saxParserFactory) {
        this.municipalityRepository = municipalityRepository;
        this.saxParserFactory = saxParserFactory;
    }


    public String parseMunicipality(File file) throws ParserConfigurationException, SAXException, IOException {
        if (file.getName().endsWith(".XML") && file.isFile()&& file.getName().contains("AS_ADDHOUSE_TYPES")) {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MunicipalityParser municipalityParser = new MunicipalityParser();

            FileInputStream fileInputStream = new FileInputStream(file);
            saxParser.parse(fileInputStream, municipalityParser);
            List<Municipality> municipalityList = municipalityParser.getMunicipalityList();
            municipalityRepository.saveAll(municipalityList);
            fileInputStream.close();
        }

        return null;
    }
}
