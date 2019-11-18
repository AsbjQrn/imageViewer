package dk.asbjoern.foto.mediasource;


import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class MediaWalkerDefault implements MediaWalker {


    public void getNextOrPrev(ImageView imageView, boolean forward) throws FileNotFoundException {

    }

}