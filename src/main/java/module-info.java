module johkar2.kth.se.moviedatabase {
    requires javafx.controls;
    requires javafx.fxml;


    opens johkar2.kth.se.moviedatabase to javafx.fxml;
    exports johkar2.kth.se.moviedatabase;
}