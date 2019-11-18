package dk.asbjoern.foto.fx;

import dk.asbjoern.foto.mediasource.MediaWalker;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class FXApplication extends Application implements FxApp {


//    @Autowired
    private MediaWalker mediaWalker;

    public FXApplication(MediaWalker mediaWalker) {
        this.mediaWalker = mediaWalker;
    }

    public FXApplication() {
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Creating an image
        Image image1 = new Image(new FileInputStream("src/main/resources/imagesJPEG/DSC_0592.JPG"));
        Image image2 = new Image(new FileInputStream("src/main/resources/imagesJPEG/DSC_5330.JPG"));


        //Setting the image view
        ImageView imageView = new ImageView(image1);

        //Setting the position of the image
//        imageView.setX(50);
//        imageView.setY(25);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        BorderPane pane = new BorderPane();
        pane.setPrefSize(-1, -1);
        pane.setCenter(imageView);

//        root.autosize();
        //Creating a scene object
        stage.setFullScreen(true);
//        Scene scene = new Scene(root, stadk.asbjoern.foto.fxge.getMaxWidth(), stage.getMaxHeight());
        Scene scene = new Scene(pane, -1, -1);
        scene.setFill(Color.BLACK);

        //setting the fit height and width of the image view
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        imageView.setFitHeight(1080 );
        imageView.setFitWidth( 1920);


        Button rotateKnap = new Button("Rotate");

        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.L) {
                    imageView.setRotate(imageView.getRotate() + 90);
                }
                if (ke.getCode() == KeyCode.R) {
                    imageView.setRotate(imageView.getRotate() - 90);
                }
                if (ke.getCode() == KeyCode.DIGIT4 || ke.getCode() == KeyCode.DIGIT6  || ke.getCode() == KeyCode.KP_LEFT ) {
                    Image image = imageView.getImage();
                    if (image == image1)
                        imageView.setImage(image2);
                   else imageView.setImage(image1);
                }

            }
        });

        pane.getChildren().add((new Button()));

        //Adding scene to the stage
        stage.setScene(scene);

        stage.show();
    }

    public void main(String[] args) {
        launch(FXApplication.class, args);
    }

}
