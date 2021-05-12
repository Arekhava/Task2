package main;
import entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.print.Paper;
import java.io.IOException;

import java.util.HashSet;

public class PapersDomBuilder extends AbstractPaperBuilder {

    private final static Logger logger = LogManager.getLogger(PapersDomBuilder.class);

    private DocumentBuilder documentBuilder;

    public PapersDomBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Error in PapersDomBuilder: " + e.getMessage());
        }
    }

    @Override
    public void buildSetPapers(String path) throws PapersException {
        Document document;
        try {
            document = documentBuilder.parse(path);
            buildPapersByElementName(document, PaperXMLTag.MAGAZINE);
            buildPapersByElementName(document, PaperXMLTag.NEWSPAPER);
        } catch (SAXException e) {
            logger.error("Error in dom buildSetPapers:" + e.getMessage());
            throw new PapersException();
        } catch (IOException e) {
            logger.error("Problems with path: " + path + " in dom buildSetPapers");
            throw new PapersException();
        }
        logger.info("Papers in buildSetPapers method from dom builder are:\n" + papers);
    }

    private void buildPapersByElementName(Document document,final PaperXMLTag ELEMENT_NAME) {
        Element root = document.getDocumentElement();
        NodeList papersList = root.getElementsByTagName(ELEMENT_NAME.getTitle());
        for (int i = 0; i < papersList.getLength(); i++) {
            Element paperElement = (Element) papersList.item(i);
            Paper paper=null;
            switch (ELEMENT_NAME) {
                case MAGAZINE:
                    paper = buildMagazine(paperElement);
                    break;
                case NEWSPAPER:
                    paper= buildNewspaper(paperElement);
                    break;
                default:
                    logger.error("Illegal argument " + ELEMENT_NAME + " in getPaperByElementName method");
            }
            papers.add(paper);
        }
    }
    @Override
    public HashSet<Paper> getPapers() {
        return (HashSet<Paper>) papers.clone();
    }
    private Magazine buildMagazine (Element element) {
        Magazine paper=new Magazine();
        setPaperCharacteristics(element, paper);
        paper.setMagazine(getElementTextContent(element, PaperXMLTag.MAGAZINE.getTitle()));

        return paper;
    }

    private Newspaper buildNewspaper(Element element) {
        Newspaper paper= new Newspaper();
        setPaperCharacteristics(element,paper);

       paper.setNewspaper(getElementTextContent(element, PaperXMLTag.NEWSPAPER.getTitle()));
        return paper;
    }

    private void setPaperCharacteristics(Element element, Magazine paper) {
        paper.setTitle(element.getAttribute(PaperXMLTag.TITLE.getTitle()));

        paper.setPublisher(getElementTextContent(element, PaperXMLTag.PUBLISHER.getTitle()));
        paper.setWebsite(getElementTextContent(element, PaperXMLTag.WEBSITE.getTitle()));

        paper.setGlossy(getElementTextContent(element, PaperXMLTag.GLOSSY.getTitle()));
        paper.setDate(paper.getDate());
        paper.setSubscription(getElementTextContent(element, PaperXMLTag.SUBSCRIPTION.getTitle()));

    }
    private void setPaperCharacteristics(Element element, Newspaper paper) {
        paper.setTitle(element.getAttribute(PaperXMLTag.TITLE.getTitle()));

        paper.setPublisher(getElementTextContent(element, PaperXMLTag.PUBLISHER.getTitle()));
        paper.setWebsite(getElementTextContent(element, PaperXMLTag.WEBSITE.getTitle()));

        paper.setGlossy(getElementTextContent(element, PaperXMLTag.GLOSSY.getTitle()));
        paper.setDate(paper.getDate());
        paper.setSubscription(getElementTextContent(element, PaperXMLTag.SUBSCRIPTION.getTitle()));

    }
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
