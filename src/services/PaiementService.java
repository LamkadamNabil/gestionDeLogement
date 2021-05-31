package services;

import models.Paiement;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaiementService {
    Connection connection = DBConnection.getDBConnection();

    public PaiementService() throws SQLException {
    }

    // Trouver un paiement par son ID
    public Paiement findPaiementById(int paiement_id) {
        PreparedStatement pst = null;
        ResultSet resultSet;
        String sql = "select * from paiement where id=?";
        Date dateD;
        Date dateF;
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, paiement_id);
            System.out.println("successful query");
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                dateD = resultSet.getDate("date_debut");
                dateF = resultSet.getDate("date_fin");
                return (new Paiement(resultSet.getInt("id"),
                        resultSet.getInt("id_location"),
                        dateD.toLocalDate(),
                        dateF.toLocalDate(),
                        resultSet.getBoolean("etat_paiement")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Trouver un paiement par l ID du Location
    public ArrayList<Paiement> findPaiementsByIdLocation(int location_id) {
        ArrayList<Paiement> paiements = new ArrayList<Paiement>();
        PreparedStatement pst = null;
        ResultSet resultSet;
        Date dateD;
        Date dateF;
        try {
            String sql = "select * from paiement where id_location=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, location_id);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                dateD = resultSet.getDate("date_debut");
                dateF = resultSet.getDate("date_fin");
                paiements.add(new Paiement(resultSet.getInt("id"),
                        resultSet.getInt("id_location"),
                        dateD.toLocalDate(),
                        dateF.toLocalDate(),
                        resultSet.getBoolean("etat_paiement")));
            }
            return paiements;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Liste de tous les paiements
    public ArrayList<Paiement> findAllPaiements() {
        ArrayList<Paiement> paiements = new ArrayList<Paiement>();
        PreparedStatement pst = null;
        ResultSet resultSet;
        String sql = "select * from paiement";
        Date dateD;
        Date dateF;
        try {
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                dateD = resultSet.getDate("date_debut");
                dateF = resultSet.getDate("date_fin");
                paiements.add(new Paiement(resultSet.getInt("id"),
                        resultSet.getInt("id_location"),
                        dateD.toLocalDate(),
                        dateF.toLocalDate(),
                        resultSet.getBoolean("etat_paiement")));
            }
            return paiements;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Liste des paiements selon l etat du paiement
    public ArrayList<Paiement> findPaiementsByEtatPaiement(Boolean etat) {
        ArrayList<Paiement> paiements = new ArrayList<Paiement>();
        PreparedStatement pst = null;
        ResultSet resultSet;
        String sql = "select * from paiement where etat_paiement=?";
        Date dateD;
        Date dateF;
        try {
            pst = connection.prepareStatement(sql);
            pst.setBoolean(1, etat);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                dateD = resultSet.getDate("date_debut");
                dateF = resultSet.getDate("date_fin");
                paiements.add(new Paiement(resultSet.getInt("id"),
                        resultSet.getInt("id_location"),
                        dateD.toLocalDate(),
                        dateF.toLocalDate(),
                        resultSet.getBoolean("etat_paiement")));
                return paiements;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Supprimer un paiement
    public void deletePaiement(int id_paiement) throws SQLException {
        PreparedStatement pst =null;
        String sql="delete from Paiement where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id_paiement);
            System.out.println("successful query");
            pst.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Mise a jour de l etat du paiement
    public void updatePaiement(int paiement_id, boolean etat) {
        PreparedStatement pst = null;
        String sql = "update paiement set etat_paiement=? where id=?";
        ResultSet resultSet;
        try {
            pst = connection.prepareStatement(sql);
            pst.setBoolean(1, etat);
            pst.setInt(2, paiement_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Ajouter un nouveau paiement
    public static void addPaiement(Paiement paiement) throws SQLException {
        Connection connection = DBConnection.getDBConnection();
        PreparedStatement pst =null;
        String sql="insert into paiement(id,id_location,date_debut,date_fin,etat_paiement) values (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,paiement.getId());
            pst.setInt(2,paiement.getId_location());
            pst.setDate(3, Date.valueOf((LocalDate) paiement.getDate_debut()));
            pst.setDate(4, Date.valueOf((LocalDate) paiement.getDate_fin()));
            pst.setBoolean(5,paiement.getEtat_paiement());
            System.out.println("succes query ");
            pst.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}