package jpsave.airbnb;

import jpsave.airbnb.file.LogementsXMLFile;
import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.utilisateurs.Hote;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class MainXml {

    private static final String XML_FILE = "/Users/jpsave/IdeaProjects/AirBnB-maven/src/main/resources/logements-final.xml";

    public static Set<Hote> hotes = new HashSet<>();
    public static Set<Logement> logements = new HashSet<>();


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
            logements.add(xmlAppartement);
        });
        xmlLogements.getMaisons().forEach(xmlMaison -> {
            hotes.add(xmlMaison.getHote());
            logements.add(xmlMaison);
        });

//        System.out.println("Liste des hotes :");
//        hotes.forEach(Hote::afficher);
//        System.out.println();
//        System.out.println();
//        System.out.println("Liste des appartements :");
//        appartements.forEach(Appartement::afficher);
//        System.out.println();
//        System.out.println();
//        System.out.println("Liste des maisons :");
//        maisons.forEach(Maison::afficher);


        System.out.println();
        System.out.println();
        System.out.println("La maison de Jean est :");
        Maison maisonDeJean = (Maison)findLogementByNameWithGenericity("Maison Jean");
        maisonDeJean.afficher();

        System.out.println();
        System.out.println();
        System.out.println("L'appartement de Michel est :");
        Appartement appartDeMichel = (Appartement)findLogementByNameWithGenericity("Appart Michel");
        appartDeMichel.afficher();

        System.out.println();
        System.out.println();
        System.out.println("L'appartement de Toto est :");
        try {
            Appartement appartDeToto = (Appartement) findLogementByNameWithGenericity("Appart Toto");
            appartDeToto.afficher();
        } catch (NullPointerException e) {
            System.out.println("Toto n'a pas d'appartement");
        }
    }


    private static <T extends Logement> T findLogementByNameWithGenericity(String nom) {
        for(Logement logement : logements) {
            if(logement.getNom().equalsIgnoreCase(nom)) {
                return (T) logement;
            }
        }
        throw  new NullPointerException();
    }
}
