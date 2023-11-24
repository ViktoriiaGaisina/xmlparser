package com.example.xmlparser.parser;

import com.example.xmlparser.entity.CastObce;
import com.example.xmlparser.entity.Obec;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CastObceHandler extends DefaultHandler {
    private CastObce obec = null;
    private List<CastObce> obecList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("CASTOBCE")) {
            obec = new CastObce();
            obec.setObecId(attributes.getValue("ID"));
            obec.setKod(Integer.parseInt(attributes.getValue("KOD")));
            obec.setNazev(attributes.getValue("NAZEV"));
            obec.setPlatiOd(LocalDate.parse(attributes.getValue("PLATIOD")));
            obec.setIdTransakce(Long.parseLong(attributes.getValue("IDTRANSAKCE")));
            obec.setGlobalniIdNavrhZmeny(Long.parseLong(attributes.getValue("GLOBALNIIDNAVRHZMENY")));
            obec.setPad2(attributes.getValue("PAD2"));
            obec.setPad3(attributes.getValue("PAD3"));
            obec.setPad4(attributes.getValue("PAD4"));
            obec.setPad5(attributes.getValue("PAD5"));
            obec.setPad6(attributes.getValue("PAD6"));
            obec.setPad7(attributes.getValue("PAD7"));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("CASTOBCE")) {
            obecList.add(obec);
            if (obecList.size() > 100) {
                obecList.clear();
            }
        }
    }

    public List<CastObce> getCastObceList() {
        return obecList;
    }
}
