package programm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
       
    }
}
