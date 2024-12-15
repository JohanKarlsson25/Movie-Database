package johkar2.kth.se.moviedatabase.view;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AnimationHandler {

    static void startTransition(Node child, Pane parent, int animationDurationInMillis, int animationYTransition, boolean transitionAutoReverse, int transitionCycleCount, boolean removeNodeAfter){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(animationDurationInMillis));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(transitionAutoReverse);
        transition.setCycleCount(transitionCycleCount);
        transition.setNode(child);
        transition.play();
        if (removeNodeAfter) {
            transition.setOnFinished(actionEvent -> {
                parent.getChildren().remove(child);
            });
        }
    }

    static void rotateObject(Node node, int animationDurationInMillis, double angleOfRotation, boolean transitionAutoReversed, int transitionCycleCount){
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(animationDurationInMillis));
        rotateTransition.setByAngle(angleOfRotation);
        rotateTransition.setCycleCount(transitionCycleCount);
        rotateTransition.setAutoReverse(transitionAutoReversed);
        rotateTransition.setNode(node);
        rotateTransition.play();
    }
}
