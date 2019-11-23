package dk.asbjoern.foto.fx;

import org.springframework.stereotype.Component;

@Component
public class FxStarter {

    FxApplication fxApplication;

    public FxStarter() {
        FxApplication fxApplication = new FxApplication();
        this.fxApplication = fxApplication;
        fxApplication.launch();
    }


    public FxApplication getFxApplication() {
        return fxApplication;
    }
}
