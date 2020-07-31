package programm;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.scene.control.Alert;

import java.sql.*;

public class DatabaseHendler extends  Configs {
    Connection db_conection;

    public  Connection getDb_conection()
            throws ClassNotFoundException, SQLException {
        try {
            String connectioURL = "jdbc:mysql://" + dbHost + ":" + dbPort
                    + "/" + dbName + "?useUnicode=true&serverTimezone=UTC&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            db_conection = DriverManager.getConnection(connectioURL, dbUser, dbPass);

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
    public ResultSet getUser (String username, String password){
        ResultSet resultSet = null;
        try {
            Statement statement = null;
            try {
                statement = getDb_conection().createStatement();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            resultSet = statement.executeQuery("SELECT  * FROM  users WHERE username='"+username+"'AND password='"+password+"'");
            return  resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  resultSet;
    }

}
