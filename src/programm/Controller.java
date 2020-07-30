package programm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button singUP_button;

    @FXML
    private Button SingIN_button;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField username_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private CheckBox privacy_checkbox;

    @FXML
    void initialize() {
        DatabaseHendler databaseHendler = new DatabaseHendler();
       SingIN_button.setOnAction(event -> {
           SceneLoader sceneLoader = new SceneLoader();
           sceneLoader.SceneLoader("login", SingIN_button);
       });
       singUP_button.setOnAction(event -> {
           String firstname = firstname_field.getText().trim();
           String surname = surname_field.getText().trim();
           String username = username_field.getText().trim();
           String password  = password_field.getText().trim();
           if(!firstname.equals("") && !surname.equals("") && !username.equals("")
                   && !password.equals("") && privacy_checkbox.isSelected()){
               databaseHendler.SingUpUser(firstname, surname, username, password);
           }
       });
    }

}
