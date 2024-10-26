package johkar2.kth.se.moviedatabase.view;

public class MainMenuBackground implements Runnable{

    private ApplicationState applicationState;
    private int yPixelValue = 0;
    private final View view;
    private long previousTime = System.nanoTime();

    public MainMenuBackground(View view){
        this.view = view;
        this.applicationState = ApplicationState.MAIN_MENU;
    }
//Kanske måste byta helt till en game-loop. Med update och view byggt mot applicationstate.
    @Override
    public void run() {
        while(applicationState == ApplicationState.MAIN_MENU) {

            long currentTime = System.nanoTime();
            long elapsedNanos = currentTime - previousTime;

            if (elapsedNanos > 100_000.0) {
                view.setViewPort(yPixelValue++);
                if (yPixelValue > 1500) yPixelValue = 0;
            }

            previousTime = currentTime;
        }
    }

    public void setApplicationState(ApplicationState applicationState){
        this.applicationState = applicationState;
    }
}
