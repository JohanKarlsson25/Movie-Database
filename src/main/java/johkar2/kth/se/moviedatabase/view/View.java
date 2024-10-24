package johkar2.kth.se.moviedatabase.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Pane {

    private Button tv_seriesButton, movieButton;

    public View(Stage stage){
        initView();
    }

    private void initView(){
        tv_seriesButton = new Button();
        movieButton = new Button();

        this.getChildren().addAll(tv_seriesButton, movieButton);
    }

    void addEventHandlers(Controller controller){

    }
}
