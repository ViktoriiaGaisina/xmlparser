package com.example.xmlparser.parser;

import com.example.xmlparser.entity.Obec;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObecHandler extends DefaultHandler {
    private Obec obec = null;
    private List<Obec> obecList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("OBEC")) {
            obec = new Obec();
            obec.setObecId(attributes.getValue("ID"));
            obec.setKod(Integer.parseInt(attributes.getValue("KOD")));
            obec.setNazev(attributes.getValue("NAZEV"));
            obec.setStatusCode(Integer.parseInt(attributes.getValue("STATUSCODE")));
            obec.setOkresKod(Integer.parseInt(attributes.getValue("OKRESKOD")));
            obec.setPouKod(Integer.parseInt(attributes.getValue("POUKOD")));
            obec.setPlatiOd(LocalDate.parse(attributes.getValue("PLATIOD")));
            obec.setIdTransakce(Long.parseLong(attributes.getValue("IDTRANSAKCE")));
            obec.setGlobalniIdNavrhZmeny(Long.parseLong(attributes.getValue("GLOBALNIIDNAVRHZMENY")));
            obec.setPad2(attributes.getValue("PAD2"));
            obec.setPad3(attributes.getValue("PAD3"));
            obec.setPad4(attributes.getValue("PAD4"));
            obec.setPad5(attributes.getValue("PAD5"));
            obec.setPad6(attributes.getValue("PAD6"));
            obec.setPad7(attributes.getValue("PAD7"));
            obec.setNutsLau(attributes.getValue("NUTSLAU"));
        }
    }


        @Override
        public void endElement (String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("OBEC")) {
                obecList.add(obec);
                if (obecList.size() > 100) {
                    obecList.clear();
                }
            }
        }

        public List<Obec> getObecList () {
            return obecList;
        }
    }
