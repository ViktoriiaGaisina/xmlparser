package com.example.xmlparser.controller;

import com.example.xmlparser.service.CastObceService;
import com.example.xmlparser.service.ObecService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@RestController
public class MunicipalityController {
    private final ObecService obecService;
    private final CastObceService castObceService;

    public MunicipalityController(ObecService obecService, CastObceService castObceService) {
        this.obecService = obecService;
        this.castObceService = castObceService;
    }

    @PostMapping("/save")
    public void importToDb() {
        File file = new File("C:/Users/vicga/OneDrive/Dokumenty/ukol/20210331_OB_573060_UZSZ.xml");
        try {
            obecService.parseObec(file);
            castObceService.parseCastObce(file);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
