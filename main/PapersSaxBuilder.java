package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.print.Paper;
import java.io.IOException;
import java.util.Set;

public class PapersSaxBuilder {
    private final static Logger logger = LogManager.getLogger();
    private Set<Paper> papers;
    private PapersSaxHandler handler = new PapersSaxHandler();
    private PapersErrorHandler errorHandler = new PapersErrorHandler();
    private XMLReader reader;

    public PapersSaxBuilder() {
        super();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error("Error in PapersSaxBuilder: " + e.getMessage());
        }
        reader.setContentHandler(handler);
        reader.setErrorHandler(errorHandler);
    }
    public Set<Paper> getPapers(){
        return papers;
    }
    public void buildSetPapers(String fileName){
        try{
            reader.parse(fileName);
        }catch (IOException|SAXException e){
            e.printStackTrace();
        }
        //TODO
        // papers=handler.getPapers();
    }
}
