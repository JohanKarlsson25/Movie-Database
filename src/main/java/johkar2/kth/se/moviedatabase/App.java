package johkar2.kth.se.moviedatabase;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import johkar2.kth.se.moviedatabase.view.Controller;
import johkar2.kth.se.moviedatabase.view.StartMenuView;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.initStyle(StageStyle.UNDECORATED);
        StartMenuView startMenuView = new StartMenuView();
        Scene scene = new Scene(startMenuView);
        Controller controller = new Controller(startMenuView,scene,stage);
        stage.setTitle("Movie Database");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}