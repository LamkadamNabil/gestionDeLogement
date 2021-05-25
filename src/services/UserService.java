package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    public static String findUserbyID() {
        try {
            Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            String sql = "select email from user where id='1'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return resultSet.getString(1);
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
