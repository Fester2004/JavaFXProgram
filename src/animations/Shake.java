package animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;
    public  Shake (Node node) {
        node.setStyle("-fx-border-color: rgba(255,0,0,0.5)");
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(-1f);
        tt.setByX(10f);
        tt.setAutoReverse(true);
        tt.setCycleCount(4);

    }
    public  void play_anim () {
        tt.playFromStart();
    }
}
