package dk.asbjoern.foto.fx;

import javafx.application.Application;
import javafx.stage.Stage;


public class FxApplication extends Application {


    Stage stage;

    public FxApplication() {

    }

    public void launch() {
        System.out.println("Launcher FX");
        launch(FxApplication.class, null);
        System.out.println("Launch ok");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Stage modtaget" + stage);
        this.stage = stage;
        System.out.println("Stage sat");
    }

    public Stage getStage() {
        return stage;
    }
}
