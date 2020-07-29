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
       SingIN_button.setOnAction(event -> {
           SceneLoader sceneLoader = new SceneLoader();
           sceneLoader.SceneLoader("login", SingIN_button);
       });
    }
}
