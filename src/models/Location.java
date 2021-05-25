package models;

import java.util.ArrayList;

public class Location {
    private int id_locataire;
    private int id_logement;
    private float prix;
    private String duree;

    public Location(int id_locataire, int id_logement, float prix, String duree) {
        this.id_locataire = id_locataire;
        this.id_logement = id_logement;
        this.prix = prix;
        this.duree = duree;
    }

    public int getId_locataire() {
        return id_locataire;
    }

    public int getId_logement() {
        return id_logement;
    }

    public float getPrix() {
        return prix;
    }

    public String getDuree() {
        return duree;
    }

    public void setId_locataire(int id_locataire) {
        this.id_locataire = id_locataire;
    }

    public void setId_logement(int id_logement) {
        this.id_logement = id_logement;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
