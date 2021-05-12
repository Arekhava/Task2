package main;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PapersErrorHandler implements ErrorHandler {


    @Override
    public void warning(SAXParseException e) throws SAXException {

    }

    @Override
    public void error(SAXParseException e) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}
