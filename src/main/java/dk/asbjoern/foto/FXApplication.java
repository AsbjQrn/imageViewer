package dk.asbjoern.foto;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class FXApplication extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        Text helloWorld = new Text("Hej Ella");
//        StackPane root = new StackPane(helloWorld);
//        stage.setScene(new Scene(root, 300, 120));
//        stage.centerOnScreen();
//        stage.show();
//    }

//    @Override
//    public void start(Stage stage) throws Exception {
//        Group root = new Group();
//        Scene scene = new Scene(root, 500, 500, Color.BLACK);
//        Rectangle r = new Rectangle(0, 0, 250, 250);
//        r.setFill(Color.BLUE);
//        root.getChildren().add(r);
//
//        TranslateTransition translate =
//                new TranslateTransition(Duration.millis(750));
//        translate.setToX(390);
//        translate.setToY(390);
//
//        FillTransition fill = new FillTransition(Duration.millis(750));
//        fill.setToValue(Color.RED);
//
//        RotateTransition rotate = new RotateTransition(Duration.millis(750));
//        rotate.setToAngle(360);
//
//        ScaleTransition scale = new ScaleTransition(Duration.millis(750));
//        scale.setToX(0.1);
//        scale.setToY(0.1);
//
//        ParallelTransition transition = new ParallelTransition(r,
//                translate, fill, rotate, scale);
//        transition.setCycleCount(Timeline.INDEFINITE);
//        transition.setAutoReverse(true);
//        transition.play();
//
//        stage.setTitle("JavaFX Scene Graph Demo");
//        stage.setScene(scene);
//        stage.show();
//    }


    @Override
    public void start(Stage stage) throws Exception {


        //Creating an image
        Image image1 = new Image(new FileInputStream("src/main/resources/imagesJPEG/DSC_0592.JPG"));
        Image image2 = new Image(new FileInputStream("src/main/resources/imagesJPEG/DSC_5330.JPG"));

        //Setting the image view
        ImageView imageView = new ImageView(image1);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(900);
        imageView.setFitWidth(925);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);


        //Creating a Group object
        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 1000, 1000);

        //Setting title to the Stage
        stage.setTitle("Loading an image");

        Button rotateKnap = new Button("Rotate");

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.L) {
                    imageView.setRotate(imageView.getRotate() + 90);
                }
                if (ke.getCode() == KeyCode.R) {
                    System.out.println("adsfasfdasdfasdfasfasf");

                    imageView.setRotate(imageView.getRotate() - 90);
                }
                if (ke.getCode() == KeyCode.DIGIT4 || ke.getCode() == KeyCode.DIGIT6  || ke.getCode() == KeyCode.KP_LEFT ) {
                    Image image = imageView.getImage();
                    if (image == image1)
                        imageView.setImage(image2);
                   else imageView.setImage(image1);
                }
                if (ke.getCode() == KeyCode.R) {
                    imageView.setRotate(imageView.getRotate() - 90);
                }
            }
        });



        Button testKnap = new Button("Test");
        testKnap.setOnAction((ActionEvent e) -> {
            Image image = imageView.getImage();
            if (image == image1)
                imageView.setImage(image2);
            else imageView.setImage(image1);
        });

        root.getChildren().add(testKnap);
        root.getChildren().add(rotateKnap);

        //Adding scene to the stage
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(FXApplication.class, args);
    }
}
