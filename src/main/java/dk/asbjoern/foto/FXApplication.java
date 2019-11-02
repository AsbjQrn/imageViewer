package dk.asbjoern.foto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text helloWorld = new Text("Hello world");
        StackPane root = new StackPane(helloWorld);
        stage.setScene(new Scene(root, 300, 120));
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(FXApplication.class, args);
    }
}
