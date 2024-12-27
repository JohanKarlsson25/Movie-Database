package johkar2.kth.se.moviedatabase.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class IconObject extends Pane {

    private ImageView mainImageView, dotsImageView;
    private Controller controller;

    Rectangle imageRectangle = new Rectangle(0,0,180,180);

    public IconObject(String title, Controller controller){
        this.controller = controller;
        initUI(title);
        addEventHandlers();
    }

    private void addEventHandlers(){
        mainImageView.setOnMouseEntered(mouseEvent -> {
            fullSize();
            controller.handleHover(this);});
        mainImageView.setOnMouseExited(mouseEvent -> {
            normalSize();
            controller.handleHoverEnded(this);});
    }

    private void initUI(String title){
        this.setPrefSize(190,190);
        this.mainImageView = new ImageView();
        this.dotsImageView = new ImageView();

        mainImageView.setPreserveRatio(true);
        mainImageView.setFitWidth(180);
        mainImageView.setFitHeight(180);
        mainImageView.relocate(5,5);

        imageRectangle.setArcHeight(35);
        imageRectangle.setArcWidth(35);

        mainImageView.setImage(new Image(title + ".png")); //All images are going to need the same properties size wise
        mainImageView.setClip(imageRectangle);

        this.setBorder(new Border(new BorderStroke(Color.web("0x747e7d"), BorderStrokeStyle.SOLID,new CornerRadii(20),BorderStroke.THICK)));

        this.getChildren().addAll(mainImageView);
    }

    private void fullSize(){
        this.setPrefSize(200,200);
        mainImageView.setFitWidth(190);
        mainImageView.setFitHeight(190);
        imageRectangle.setHeight(190);
        imageRectangle.setWidth(190);
    }

    private void normalSize(){
        this.setPrefSize(190,190);
        mainImageView.setFitWidth(180);
        mainImageView.setFitHeight(180);
        imageRectangle.setHeight(180);
        imageRectangle.setWidth(180);
    }
}
