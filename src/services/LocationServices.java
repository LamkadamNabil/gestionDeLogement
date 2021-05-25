package services;

import models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationServices {
    Connection connection = DBConnection.getDBConnection();

    public LocationServices() throws SQLException {
    }

    public void addLocation(Location obj) throws SQLException {

        PreparedStatement pst =null;
        String sql="insert into location(id_locataire,id_logement,prix,duree) values (?,?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setLong(1,obj.getId_locataire());
            pst.setLong(2,obj.getId_logement());
            pst.setFloat(3,obj.getPrix());
            pst.setString(4,obj.getDuree());
            System.out.println("succes query ");
            pst.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void delete(long id) {
        PreparedStatement pst =null;
        String sql="delete from location  where Id_locataire=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setLong(1,id);
            System.out.println("succes query ");
            pst.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public Location findLocationByIdlocataire(long id) {
        PreparedStatement pst =null;
        ResultSet rs;
        String sql="select * from location  where Id_locataire=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setLong(1,id);
            System.out.println("succes query ");
            rs =pst.executeQuery();
            if (rs.next()){
                //System.out.println(rs.getInt("id_locataire")+" " + rs.getString("id_logement")+" " + rs.getString("prix"));
                return (new Location(rs.getInt("id_locataire"),rs.getInt("id_logement"),rs.getInt("prix"),rs.getString("duree")));
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Location findLocationByidlogement(long id) {
        PreparedStatement pst =null;
        ResultSet rs;
        String sql="select * from location  where id_logement=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setLong(1,id);
            System.out.println("succes query ");
            rs =pst.executeQuery();
            if (rs.next()){
                //System.out.println(rs.getInt("id_locataire")+" " + rs.getString("id_logement")+" " + rs.getString("prix"));
                return (new Location(rs.getInt("id_locataire"),rs.getInt("id_logement"),rs.getInt("prix"),rs.getString("duree")));
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Location> findAllLocation()  {
        ArrayList<Location> listdeslocation =new ArrayList<Location>();
        PreparedStatement pst =null;
        ResultSet rs;
        String sql="select * from location ";
        try {

            pst = connection.prepareStatement(sql);
            System.out.println("succes query ");
            rs =pst.executeQuery();
            while (rs.next()){
                //System.out.println(rs.getInt("id_locataire")+" " + rs.getString("id_logement")+" " + rs.getString("prix"));
                listdeslocation.add(new Location(rs.getInt("id_locataire"),rs.getInt("id_logement"),rs.getInt("prix"),rs.getString("duree")));
            }return listdeslocation;

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }



}
