package johkar2.kth.se.moviedatabase;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import johkar2.kth.se.moviedatabase.model.Model;
import johkar2.kth.se.moviedatabase.view.Controller;
import johkar2.kth.se.moviedatabase.view.View;

public class App extends Application {

    private View view;
    private Controller controller;
    private Model model;

    @Override
    public void start(Stage stage) {

        stage.initStyle(StageStyle.UNDECORATED);
        model = new Model();
        view = new View(stage);
        controller = new Controller(view, model);

        Scene scene = new Scene(view);
        stage.setTitle("Movie Database");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}