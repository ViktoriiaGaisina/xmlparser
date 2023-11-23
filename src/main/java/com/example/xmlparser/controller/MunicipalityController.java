package com.example.xmlparser.controller;

import com.example.xmlparser.service.MunicipalityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@RestController
public class MunicipalityController {
    private final MunicipalityService municipalityService;

    public MunicipalityController( MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @PostMapping("/save")
    public void importToDb() {
        File file = new File("C:/Users/vicga/OneDrive/Dokumenty/ukol/20210331_OB_573060_UZSZ.xml");
        try {
            municipalityService.parseMunicipality(file);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
