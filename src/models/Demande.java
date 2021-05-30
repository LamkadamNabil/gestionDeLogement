package models;

import java.util.Date;

public class Demande {

    private  int id ;
    private  int id_client ;
    private  String id_logement ;
    private  boolean etat ;
    private  String description ;
    private Date date_rendez_vous ;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_rendez_vous(Date date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_logement(String id_logement) {
        this.id_logement = id_logement;
    }

    public boolean getEtat() {
        return etat;
    }

    public int getId() {
        return id;
    }

    public Date getDate_rendez_vous() {
        return date_rendez_vous;
    }

    public String getDescription() {
        return description;
    }

    public int getId_client() {
        return id_client;
    }

    public String getId_logement() {
        return id_logement;
    }

    public Demande(int id, int id_client, String id_logement, boolean etat, String description, Date date_rendez_vous) {
        this.id = id;
        this.id_client = id_client;
        this.id_logement = id_logement;
        this.etat = etat;
        this.description = description;
        this.date_rendez_vous = date_rendez_vous;
    }

    public Demande(){
        super();
    }

}
