package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class XmlValidator {
    private final static Logger logger = LogManager.getLogger(PapersStaxBuilder.class);
    public static boolean validatePapersXmlFile(String xmlFilePath) {
        final String fileName = "src/resources/Papers.xml";

        String schemaName = "src/resources/Papers.xsd";
        ClassLoader loader = XmlValidator.class.getClassLoader();
        URL resource = loader.getResource(schemaName);
        String schemaPath = new File(resource.getFile()).getAbsolutePath();
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaFile = new File(schemaPath);

        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.setErrorHandler(new PapersErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + "is not correct or valid");
        }
        return true;
    }
}
