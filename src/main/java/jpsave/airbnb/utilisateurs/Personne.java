package jpsave.airbnb.utilisateurs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Personne {

    @XmlElement
    private String nom;
    @XmlElement
    private String prenom;
    @XmlElement
    private int age;

    public Personne() {
    }

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }


    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Personne) {
            Personne p = (Personne)anObject;
            return prenom.equals(p.prenom) && nom.equals(p.nom);
        }
        return false;
    }
}
