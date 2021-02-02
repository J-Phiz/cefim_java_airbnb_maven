package jpsave.airbnb.logements;

import jpsave.airbnb.utilisateurs.Hote;

import javax.xml.bind.annotation.XmlElement;

public class Appartement extends Logement {
    @XmlElement
    private int numeroEtage;
    @XmlElement
    private int superficieBalcon;

    public Appartement() {
    }

    public Appartement(Hote hote,
                       int tarifParNuit,
                       String adresse,
                       int superficie,
                       int nbVoyageursMax,
                       int numeroEtage,
                       int superficieBalcon) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.numeroEtage = numeroEtage;
        this.superficieBalcon = superficieBalcon;
    }

    public int getSuperficieTotal() {
        return this.getSuperficie() + superficieBalcon;
    }

    public void afficher() {
        String numEtageString = "";
        if(numeroEtage == 1)
            numEtageString = "1er";
        else
            numEtageString = String.format("%dème", numeroEtage);

        this.getHote().afficher();
        System.out.print(".\nLe logement \"" + this.getNom() + "\" est un appartement situé " + this.getAdresse() + " au " + numEtageString + " étage.");
        System.out.print("\nSuperficie : " + getSuperficie() + "m2");
        if(superficieBalcon > 0)
            System.out.print("\nBalcon : Oui (" + superficieBalcon + "m2)");
        else
            System.out.print("\nBalcon : Non");
        System.out.print("\nSuperficie Totale : " + getSuperficieTotal() + "m2");
    }
}
