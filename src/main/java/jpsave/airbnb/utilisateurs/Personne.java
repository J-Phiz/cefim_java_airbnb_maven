package jpsave.airbnb.utilisateurs;

import javax.xml.bind.annotation.XmlElement;

public class Personne implements Comparable<Personne> {

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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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

    @Override
    public int compareTo(Personne o) {
        if (o == null) throw new NullPointerException();
        return this.age - o.age;
    }
}
