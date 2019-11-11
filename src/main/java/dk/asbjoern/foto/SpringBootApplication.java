package dk.asbjoern.foto;

import dk.asbjoern.foto.fx.FXApplication;
import dk.asbjoern.foto.fx.FxApp;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements ApplicationRunner {



    FxApp fxApplication;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class);
    }


    public SpringBootApplication(FxApp fxApplication) {
        this.fxApplication = fxApplication;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        this.fxApplication.main(null);

    }
}
