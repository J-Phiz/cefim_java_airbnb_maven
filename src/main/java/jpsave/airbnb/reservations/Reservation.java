package jpsave.airbnb.reservations;

import jpsave.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private static int nbIdentifiants = 1;
    private int identifiant = 0;
    private Sejour sejour;
    private Voyageur voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur, Date dateDeReservation) {
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.dateDeReservation = dateDeReservation;
        this.estValidee = false;
        this.identifiant = nbIdentifiants++;
    }

    public void afficher() {
        System.out.println("Réservation n°" + identifiant + " le " + dateDeReservation + " :");
        voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        sejour.afficher();
        System.out.println("");
    }
}
