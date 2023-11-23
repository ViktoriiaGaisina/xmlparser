package com.example.xmlparser.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.parsers.SAXParserFactory;

@Configuration
public class SaxParserConfig {
    @Bean
    public SAXParserFactory saxParser() {
        return SAXParserFactory.newInstance();
    }
}
