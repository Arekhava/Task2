package main;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PapersErrorHandler implements ErrorHandler {
    //private static Logger logger= LogManager.getLogger();
   // public void warning(SAXException e){
   //     logger.warn(getLineColumnNumber(e)+"-"+e.getMessage());
   // }
   // public void error(SAXException e){
   //     logger.error(getLineColumnNumber(e)+"-"+e.getMessage());
  //  }
   // public void fatalError(SAXException e){
    //    logger.fatal(getLineColumnNumber(e)+"-"+e.getMessage());
   // }

  //  private String getLineColumnNumber(SAXException e) {
    //    return e.getLineNumber()+":"+e.getColumnNumber();
  //  }

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
