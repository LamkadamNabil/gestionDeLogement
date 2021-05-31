package services;

import models.User;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserService {

    public static User findUserbyID(int id_user) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from user where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return user;
            }
        } catch (SQLException e) {
            return  null ;
        }
        return null;
    }

    public static User findUserbyEmail(String user_email) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from user where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user_email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return user;
            }
        } catch (SQLException e) {
          return  null ;
        }
        return null;
    }

    public static boolean addUser(User user ) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "insert into user(email, password, user_role) values (?, ?, ? )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            int i = ps.executeUpdate();
            while (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUserByEmail(String user_email) {
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "delete  from user where email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user_email);
            int i = ps.executeUpdate();
            while (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return  false ;
    }

    public  static ArrayList<User> findAll(){
        try {
            Connection connection = DBConnection.getDBConnection();
            String sql = "select * from user ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
          return  null;
        }
    }

}