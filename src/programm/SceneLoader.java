package programm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public void SceneLoader (String scene, Node node){
        node.getScene().getWindow().hide();
        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(getClass().getResource("/programm/"+ scene +".fxml"));
        try {
            loader.load();
        }catch (IOException e) {
            System.out.println(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
