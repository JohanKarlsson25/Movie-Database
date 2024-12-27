package johkar2.kth.se.moviedatabase.view;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AnimationHandler {
//TODO Functions can start before one is finished, duplicate child added
    static void startMoveTransition(Node child, Pane parent, int animationDurationInMillis, int animationYTransition, boolean transitionAutoReverse, int transitionCycleCount, boolean removeNodeAfter){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(animationDurationInMillis));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(transitionAutoReverse);
        transition.setCycleCount(transitionCycleCount);
        transition.setNode(child);
        transition.play();
        //TODO // I think i want a function for making the startScreen background "roll" infinite. Probably having to pictures and a imageview that switches between.
        //TODO // Also ugly function FIX
    }

    static void startFadeTransition(Node child, Pane parent, int animationDurationInMillis, int animationYTransition, boolean transitionAutoReverse, int transitionCycleCount, boolean removeNodeAfter){

        ParallelTransition parallelTransition = new ParallelTransition();
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(animationDurationInMillis));
        transition.setToY(animationYTransition);
        transition.setAutoReverse(transitionAutoReverse);
        transition.setCycleCount(transitionCycleCount);
        transition.setNode(child);

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(child);
        fadeTransition.setDuration(Duration.millis(animationDurationInMillis));

        if (removeNodeAfter) {
            fadeTransition.setFromValue(1.0f);
            fadeTransition.setToValue(0f);
            transition.setOnFinished(actionEvent -> {
                parent.getChildren().remove(child);
            });
        } else {
            fadeTransition.setFromValue(0.3f);
            fadeTransition.setToValue(1.0f);
        }
        parallelTransition.getChildren().addAll(transition,fadeTransition);
        parallelTransition.play();
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
