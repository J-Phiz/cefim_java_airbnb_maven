package jpsave.airbnb;

import jpsave.airbnb.logements.Appartement;
import jpsave.airbnb.logements.Logement;
import jpsave.airbnb.logements.Maison;
import jpsave.airbnb.utilisateurs.Hote;

public class MainGenericity {
    public static void main(String[] args) {
        // hotes
        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
        Hote hote2 = new Hote("Agathe", "Feeling", 55, 1);

        // logements
        Maison maison1 = new Maison(hote1, 50, "81 Rue Colbert, 37000 Tours", 140, 5, 500, true);
        maison1.setNom("maison1");
        Maison maison2 = new Maison(hote2, 100, "Grand Place, 59000 Lille", 90, 4, 0, false);
        maison2.setNom("maison2");
        Appartement appartement1 = new Appartement(hote1, 10, "18 Rue de Bordeaux, 37000 Tours", 35, 2, 3, 7);
        appartement1.setNom("appartement1");
        Appartement appartement2 = new Appartement(hote2, 20, "29 Avenue Le Corbusier, 59800 Lille", 42, 3, 1, 0);
        appartement2.setNom("appartement2");

        Genericity genericity = new Genericity(maison1, maison2);
        System.out.println("Parmis " + maison1.getNom() + " et " + maison2.getNom() + " c'est " +
                ((Maison) genericity.getLower()).getNom() + " la moins chère.");
        genericity = new Genericity(appartement1, appartement2);
        System.out.println("Parmis " + appartement1.getNom() + " et " + appartement2.getNom() + " c'est " +
                ((Appartement) genericity.getHigher()).getNom() + " le plus cher.");


    }
}
