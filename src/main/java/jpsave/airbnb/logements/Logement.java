package jpsave.airbnb.logements;

import jpsave.airbnb.utilisateurs.Hote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Logement {
    @XmlAttribute
    private String nom;
    @XmlElement
    private Hote hote;
    @XmlElement
    private int tarifParNuit;
    @XmlElement
    private String adresse;
    @XmlElement
    private int superficie;
    @XmlElement
    private int nbVoyageursMax;

    public Logement() {
    }

    public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
        this.nom = "";
    }

    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
    public int getTarifParNuit() { return tarifParNuit; }
    public Hote getHote() { return hote; }
    public String getAdresse() { return adresse; }
    public int getSuperficie() { return superficie; }
    public int getNbVoyageursMax() { return nbVoyageursMax; }

    public abstract int getSuperficieTotal();

    public abstract void afficher();

}
