package services;

import models.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageServices {
    Connection connection;

    {
        try {
            connection = DBConnection.getDBConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public  void addImage(Image obj) {
        PreparedStatement pst =null;
        String sql="insert into image(id,id_logement,image) values (?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setLong(1,obj.getId());
            pst.setLong(2,obj.getId_logement());
            pst.setString(3, String.valueOf(obj.getImages()));

            System.out.println("succes query add to Image");
            pst.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean deleteImage(int id) {
        PreparedStatement pst =null;
        String sql="delete from image  where Id=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            System.out.println("delete with succes ");
            int satusdelete=pst.executeUpdate();
            if(satusdelete>0)
            {System.out.println("delete with succes ");
                return true;
            }else {
                System.out.println("error delete ");
                return false;
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Image findImageById(int id) {
        PreparedStatement pst =null;
        ResultSet rs=null;
        String sql="select * from image  where id=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            System.out.println("succes query getOne");
            rs =pst.executeQuery();
            if (rs.next()){
                //System.out.println(rs.getInt("id_locataire")+" " + rs.getString("id_logement")+" " + rs.getString("prix"));
                return (new Image(rs.getInt("id"),rs.getInt("id_logement"),rs.getString("image")));
            }

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Image> findAllImagesdeLogement(int id) {
        ArrayList<Image> listdesImage =new ArrayList<Image>();
        PreparedStatement pst =null;
        ResultSet rs;
        String sql="select * from  image where Id_logement=?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            System.out.println("succes query ");
            rs =pst.executeQuery();
            while (rs.next()){
                //System.out.println(rs.getInt("id_locataire")+" " + rs.getString("id_logement")+" " + rs.getString("prix"));
                listdesImage.add(new Image(rs.getInt("id"),rs.getInt("id_logement"),rs.getString("image")));
            }
            return listdesImage;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}



