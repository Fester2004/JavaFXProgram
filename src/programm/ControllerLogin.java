package programm;

import java.awt.*;
import java.awt.Dialog;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

public class ControllerLogin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button singUP_button;

    @FXML
    private Button SingIN_button;

    @FXML
    private TextField username_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Label git_label;

    @FXML
    void initialize() {
       singUP_button.setOnAction(event -> {
           SceneLoader sceneLoader = new SceneLoader();
           sceneLoader.SceneLoader("main", singUP_button);
       });

    }
     public void git_url () {
         if (Desktop.isDesktopSupported()) {
             Desktop desktop = Desktop.getDesktop();
             try {
                 desktop.browse(new URI("https://github.com/Fester2004/JavaFXProgram"));
             } catch (IOException | URISyntaxException e) {
                 e.printStackTrace();
             }

         } else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Error");
             alert.setHeaderText(null);
             alert.setContentText("Desktop  does not supported!");

             alert.showAndWait();
         }
     }

}
