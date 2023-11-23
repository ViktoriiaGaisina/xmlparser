package com.example.xmlparser.parser;

import com.example.xmlparser.entity.Municipality;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MunicipalityParser extends DefaultHandler {
    private Municipality municipality = null;
    private List<Municipality> municipalityList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("HOUSETYPE")) {
            municipality = new Municipality();
            municipality.setId(Long.parseLong(attributes.getValue("ID")));


        }
    }


        @Override
        public void endElement (String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("HOUSETYPE")) {
                municipalityList.add(municipality);
                if (municipalityList.size() > 100) {
                    municipalityList.clear();
                }
            }
        }

        public List<Municipality> getMunicipalityList () {
            return municipalityList;
        }
    }
