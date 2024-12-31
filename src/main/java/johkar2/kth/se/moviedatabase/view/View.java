package johkar2.kth.se.moviedatabase.view;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class View extends Pane {

    protected final int windowWidth, windowHeight;
    protected ApplicationState applicationState;
    protected final Border border = new Border(new BorderStroke(Color.web("0xF4F4F4"),BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT));
    protected final Background smallIconBackground = new Background(new BackgroundFill(Color.web("0x0f094d"),new CornerRadii(10),new Insets(-5)));
    protected final Font buttonTextFont = new Font("Book Antiqua Bold",20);

    public View(){
        this.applicationState = ApplicationState.MAIN_MENU;
        Rectangle2D screenSize = Screen.getPrimary().getBounds();
        System.out.println(screenSize);
        windowWidth = (int) (screenSize.getWidth()*0.9);
        windowHeight = (int) (screenSize.getHeight()*0.9); //big issues, I need to make every fixed component bind to screensize
        this.setPrefSize(windowWidth,windowHeight);
    }
}