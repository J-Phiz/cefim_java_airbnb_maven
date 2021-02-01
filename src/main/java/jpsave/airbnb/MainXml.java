package jpsave.airbnb;

import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Personne;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

public class MainXml {

    private static final String XML_FILE = "/Users/jpsave/IdeaProjects/AirBnB-maven/src/main/resources/logements-final.xml";
    public static void main(String[] args) {
        try {
            testJaxb();
        }
        catch (Exception e) {
            System.out.println("Exception dans mon Main : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testJaxb() throws Exception {

        JAXBContext context = JAXBContext.newInstance(LogementsXMLFile.class);
        Unmarshaller um = context.createUnmarshaller();
        LogementsXMLFile logements = (LogementsXMLFile) um.unmarshal(new FileReader(XML_FILE));

        logements.getAppartements().forEach(appartement -> {
            appartement.afficher();
            System.out.println();
        });
        logements.getMaisons().forEach(maison -> {
            maison.afficher();
            System.out.println();
        });
    }
}
