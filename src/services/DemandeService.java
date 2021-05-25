package services;

import models.Demande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandeService {

    public  static Demande findDemandeById(int id_demande){
        try {
        Connection connection = DBConnection.getDBConnection();
        String sql = "select * from demande where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id_demande);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Demande demande = new Demande(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6));
            return demande;
        }
        } catch (
             SQLException e) {
               return  null ;
         }
        return null;
    }

    public  static ArrayList<Demande> findDemandesByLogementId(int id_logement){
        try  {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from demande where id_logement= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_logement);
            ResultSet rs = ps.executeQuery();
            ArrayList<Demande> demandes = new ArrayList<Demande>();
            while (rs.next()) {
                Demande demande = new Demande(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6));
                demandes.add(demande);
            }
        return  demandes ;
        }catch (SQLException e) {
            return null;
        }
    }


    public  static ArrayList<Demande> findDemandesByClientId(int id_client){
        try  {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select  * from demande where id_client=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_client);
            ResultSet rs = ps.executeQuery();
            ArrayList<Demande> demandes = new ArrayList<Demande>();
            while (rs.next()) {
                Demande demande = new Demande(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6));
                demandes.add(demande);
            }
            return  demandes ;
        }catch (SQLException e) {
            return null;
        }
    }
}
