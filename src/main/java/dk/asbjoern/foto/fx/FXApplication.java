package dk.asbjoern.foto.fx;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import dk.asbjoern.foto.mediasource.MediaWalker;
import dk.asbjoern.foto.mediasource.MediaWalkerDefault;
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
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Component
public class FXApplication extends Application implements FxApp {


    private MediaWalker mediaWalker = new MediaWalkerDefault();

    public FXApplication() {
    }

    @Override
    public void start(Stage stage) throws Exception {


        //Getting images
        mediaWalker.setMediaLocation(new File("src/main/resources/imagesJPEG"));
        mediaWalker.setMediaLocation(new File("/media/asbjoern/a78b1484-dfe0-47b8-9e7e-0214b1caad70/fotoOrganiserOutput/2010/JANUARY"));


        //Setting the image view
        ImageView imageView = new ImageView(new Image(new FileInputStream(mediaWalker.getNextOrPrev(0))));

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
        imageView.setFitHeight(1080);
        imageView.setFitWidth(1920);


        Button rotateKnap = new Button("Rotate");



        try {
            Optional<Metadata> metadata = Optional.ofNullable(ImageMetadataReader.readMetadata((mediaWalker.getCurrent())));
            metadata.get().getDirectories();
        } catch (NullPointerException | ImageProcessingException | IOException e) {
            System.out.println("Nullpointer i framework i filen: " + mediaWalker.getCurrent().getAbsolutePath());
            e.printStackTrace();
        }

        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                if (ke.getCode() == KeyCode.F11) {
                    stage.setFullScreen(stage.isFullScreen() ? false : true);
                }

                if (ke.getCode() == KeyCode.L) {
                    imageView.setRotate(imageView.getRotate() + 90);
                }
                if (ke.getCode() == KeyCode.R) {
                    imageView.setRotate(imageView.getRotate() - 90);
                }

                try {
                    int next = 0;
                    if (ke.getCode() == KeyCode.Z) next = -1;
                    if (ke.getCode() == KeyCode.X) next = 1;
                    imageView.setImage(new Image(new FileInputStream(mediaWalker.getNextOrPrev(next))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
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
