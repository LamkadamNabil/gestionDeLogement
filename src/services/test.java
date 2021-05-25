package services;

import com.sun.javafx.collections.ElementObservableListDecorator;
import models.Image;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args)   {
        System.out.println("qsjdbcsdnvkjsdbv");
        Image objimage=new Image(89,155,"image221");
        ImageServices imageServices = new ImageServices();
        imageServices.addImage(objimage);
        //////
        System.out.println("delete image");
        imageServices.deleteImage(2);

        /////////////////////////////////
        System.out.println("getAll()");
        List<Image> listImage1 =imageServices.findAllImagesdeLogement(1544165);
        for(Image p:listImage1)
        {
            System.out.println(p.getId()+" " +p.getId_logement()+" " +p.getImages()  );
        }


    }

}

