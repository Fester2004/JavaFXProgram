package programm;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHendler extends  Configs {
    Connection db_conection;

    public  Connection getDb_conection()
            throws ClassNotFoundException, SQLException {
        try {
            String  connection_str = "jdbc:mysql://" + dbHost + ":"
                    + dbPort + "/" + dbName + "?useUnicode=true&serverTimezone=UTC&useSSL=false" ;
            Class.forName("com.mysql.jdbc.Driver");
            db_conection = DriverManager.getConnection(connection_str, dbUser,
                    dbPass);

        }catch (CommunicationsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Database does not connected!Please connect to your database, for it use Configs.");

            alert.showAndWait();

        }

        return  db_conection;
    }
    public  void SingUpUser (String firstname, String lastname,
                             String username, String password){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME +
                "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + ","
                + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDb_conection().prepareStatement(insert);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
