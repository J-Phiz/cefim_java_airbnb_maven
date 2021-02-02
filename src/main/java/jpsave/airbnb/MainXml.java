package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.utilisateurs.Hote;
import jpsave.airbnb.utilisateurs.Personne;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        LogementsXMLFile xmlLogements = (LogementsXMLFile) um.unmarshal(new FileReader(XML_FILE));

        // Récupérer la Liste des hotes
        Set<Hote> hotes = new HashSet<>();
        Set<Logement> logements = new HashSet<>();
        xmlLogements.getAppartements().forEach(xmlAppartement -> {
            hotes.add(xmlAppartement.getHote());
            logements.add(xmlAppartement);
        });
        xmlLogements.getMaisons().forEach(xmlMaison -> {
            hotes.add(xmlMaison.getHote());
            logements.add(xmlMaison);
        });

        System.out.println("Liste des hotes :");
        hotes.forEach(Hote::afficher);
        System.out.println();
        System.out.println();
        System.out.println("Liste des logements :");
        logements.forEach(Logement::afficher);

    }
}
