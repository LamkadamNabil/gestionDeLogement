package services;

import models.Contrat;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContratService {

    public static Contrat findContratbyID(int id_contrat) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from contrat where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_contrat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contrat contrat = new Contrat(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4));
                return contrat;
            }
        } catch (SQLException e) {
            return  null ;
        }
        return null;
    }

    public static Contrat findContratByIdConsultation(int id_location) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from contrat where id_location=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_location);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contrat contrat = new Contrat(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4));
                return contrat;
            }
        } catch (SQLException e) {
            return  null ;
        }
        return null;
    }

}
