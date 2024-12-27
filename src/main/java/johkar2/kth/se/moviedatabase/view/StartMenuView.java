package johkar2.kth.se.moviedatabase.view;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StartMenuView extends View {

    private ImageView backGroundImageView, enterButtonImageView;
    private Image backgroundImage, enterButtonImage;
    private Pane enterButton;

    public StartMenuView(){
        super();
        initUI();
    }

    void addEventHandlers(Controller controller){
        enterButton.setOnMouseClicked(mouseEvent -> {
            controller.handleEnterSelected();
        });
    }

    private void initUI(){

        backgroundImage = new Image("backgroundImage.png");
        enterButtonImage = new Image("mainMenuOutlineIcon.png");

        backGroundImageView = new ImageView();
        enterButtonImageView = new ImageView();

        enterButton = new Pane();

        enterButton.relocate(500,500);
        enterButton.getChildren().add(enterButtonImageView);

        this.getChildren().add(backGroundImageView);
        this.getChildren().addAll(enterButton);

        backGroundImageView.setImage(backgroundImage);
        enterButtonImageView.setImage(enterButtonImage);

        AnimationHandler.startMoveTransition(backGroundImageView,this,30000,-3000,true,Animation.INDEFINITE,false);
    }
}