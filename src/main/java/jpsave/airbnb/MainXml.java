package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.logements.Maison;
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

    public static Set<Hote> hotes = new HashSet<>();
    public static Set<Maison> maisons = new HashSet<>();
    public static Set<Appartement> appartements = new HashSet<>();


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
        xmlLogements.getAppartements().forEach(xmlAppartement -> {
            hotes.add(xmlAppartement.getHote());
            appartements.add(xmlAppartement);
        });
        xmlLogements.getMaisons().forEach(xmlMaison -> {
            hotes.add(xmlMaison.getHote());
            maisons.add(xmlMaison);
        });

        System.out.println("Liste des hotes :");
        hotes.forEach(Hote::afficher);
        System.out.println();
        System.out.println();
        System.out.println("Liste des appartements :");
        appartements.forEach(Appartement::afficher);
        System.out.println();
        System.out.println();
        System.out.println("Liste des maisons :");
        maisons.forEach(Maison::afficher);


        System.out.println();
        System.out.println();
        System.out.println("La maison de Jean est :");
        findMaisonByName("Maison Jean").afficher();

        System.out.println();
        System.out.println();
        System.out.println("L'appartement de Michel est :");
        findAppartByName("Appart Michel").afficher();
    }


    private static Maison findMaisonByName(String nom) {
        for(Maison maison : maisons) {
            if(maison.getNom().equalsIgnoreCase(nom)) {
                return maison;
            }
        }
        return null;
    }

    private static Appartement findAppartByName(String nom) {
        for(Appartement appartement : appartements) {
            if(appartement.getNom().equalsIgnoreCase(nom)) {
                return appartement;
            }
        }
        return null;
    }
}
