package models;

import java.time.LocalDate;
import java.util.Date;

public class Paiement {
    private int id;
    private int id_location;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private Boolean etat_paiement;

    public Paiement(int id, int id_location, LocalDate date_debut, LocalDate date_fin, Boolean etat_paiement) {
        this.id = id;
        this.id_location = id_location;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat_paiement = etat_paiement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Boolean getEtat_paiement() {
        return etat_paiement;
    }

    public void setEtat_paiement(Boolean etat_paiement) {
        this.etat_paiement = etat_paiement;
    }
}
