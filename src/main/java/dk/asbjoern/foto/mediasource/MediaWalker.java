package dk.asbjoern.foto.mediasource;

import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public interface MediaWalker {


    void getNextOrPrev(ImageView imageView, boolean forward) throws FileNotFoundException;

}
