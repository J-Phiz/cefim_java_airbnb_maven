package jpsave.airbnb.utilisateurs;

import javax.xml.bind.annotation.XmlElement;

public class Hote extends Personne {

    private static final int DELAI_REPONSE_STANDARD = 48;
    @XmlElement(name = "delaiReponse")
    private int delaiDeReponse;

    public Hote() {
    }

    public Hote(String prenom, String nom, int age) {
        super(prenom, nom, age);
        this.delaiDeReponse = DELAI_REPONSE_STANDARD;
    }

    public Hote(String prenom, String nom, int age, int delaiDeReponse) {
        super(prenom, nom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        if(delaiDeReponse == 1) {
            System.out.print(" qui s'engage à répondre dans l'heure");
        } else {
            System.out.print(" qui s'engage à répondre dans les " + delaiDeReponse + " heures");
        }
    }
}
