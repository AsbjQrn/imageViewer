package dk.asbjoern.foto.fx;

import org.springframework.stereotype.Component;

@Component
public class FxStarter {

    FxApplication fxApplication;

    public FxStarter() {

    }


    public FxApplication getFxApplication() {
        FxApplication fxApplication = new FxApplication();
        this.fxApplication = fxApplication;
        fxApplication.launch();
        return fxApplication;
    }
}
