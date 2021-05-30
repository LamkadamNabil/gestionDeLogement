package models;

import java.util.Date;

public class Contrat {

    private int id ;
    private  int id_location ;
    private Date date ;
    private  String notaire ;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNotaire(String notaire) {
        this.notaire = notaire;
    }

    public int getId() {
        return id;
    }

    public int getId_location() {
        return id_location;
    }

    public Date getDate() {
        return date;
    }

    public String getNotaire() {
        return notaire;
    }

    public Contrat() {
    }

    public Contrat(int id, int id_location, Date date, String notaire) {
        this.id = id;
        this.id_location = id_location;
        this.date = date;
        this.notaire = notaire;
    }
}
