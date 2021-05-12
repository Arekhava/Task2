package main;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.print.Paper;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static java.util.EnumSet.range;

public class PaperHandler extends DefaultHandler{

        private Set<Paper> papers;
        private Paper current;
        private PaperXMLTag currentXmlTag;
        private EnumSet<PaperXMLTag> withText;
        private static final String ELEMENT_PAPER="paper";
        public PaperHandler(){
            papers=new HashSet<Paper>();
            withText= EnumSet.range(PaperXMLTag.TITLE, PaperXMLTag.SUBSCRIPTION);
        }
        public Set<Paper> getPapers(){
            return papers;
        }
         public void statElement(String Uri,String localName,String qName, Attributes attrs){
                    if (ELEMENT_PAPER.equals(qName)){
                        current=new Paper();
                     //  current.setWebsite(attrs.getValue(0));
                        if(attrs.getLength()==2){
                          //  current.setPublisher(attrs.getValue(1));
                        }
                    }else {
                        PaperXMLTag temp=PaperXMLTag.valueOf(qName.toUpperCase());
                        if (withText.contains(temp)) {
                            currentXmlTag=temp;
                                            }
                  }
        }
     public void endElement(String uri, String localeName, String qName){
                    if (ELEMENT_PAPER.equals(qName)){
                        papers.add(current);
                    }
                        }

public void characters(char[] ch, int start, int length){
            String data=new String(ch,start, length).strip();
            if (currentXmlTag!=null){
                switch (currentXmlTag){
                  //  case TITLE->current.setTitle(data);
                 //   case SUBSCRIPTION->current.setSubscription(data);
                  //  case WEBSITE->current.serWebsite(data);
                  //  default->throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());

                }
            }
            currentXmlTag=null;
}

}
