package main;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
;import java.io.IOException;

public class SaxConsoleMain {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            XMLReader reader=parser.getXMLReader();
            reader.setContentHandler(new ConsolePapersHandler());
            reader.setErrorHandler(new PapersErrorHandler());
            reader.parse("src/resources/Papers.xml");
        } catch (SAXException| IOException|ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
