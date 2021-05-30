package services;

import models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {
    Connection connection = DBConnection.getDBConnection();

    public AdminService() throws SQLException {
    }

    // Liste de tous les admins
    public ArrayList<Admin> findAllAdmins() {
        ArrayList<Admin> admins = new ArrayList<Admin>();
        PreparedStatement pst = null;
        ResultSet resultSet;
        String sql = "select * from admin";
        try {
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                admins.add(new Admin(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("cin"),
                        resultSet.getString("tele")));
            }
            return admins;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Trouver un admin par son ID
    public Admin findAdminById(int admin_id) {
        PreparedStatement pst = null;
        ResultSet resultSet;
        String sql = "select * from admin where id=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, admin_id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return (new Admin(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("cin"),
                        resultSet.getString("tele")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
