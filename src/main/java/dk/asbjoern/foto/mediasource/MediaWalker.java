package dk.asbjoern.foto.mediasource;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MediaWalker {

    private File[] files;
    private int currentFile = 0;
    private boolean forward;
    private boolean backward;

    MediaWalker(File dir) {
        files = dir.listFiles();

    }

    public void getNextOrPrev(ImageView imageView, boolean forward) throws FileNotFoundException {
        if(forward) this.forward = forward;
        else backward = true;

        calculateNextImage(forward);
        imageView.setImage(new Image(new FileInputStream(files[currentFile])));
    }

    private int calculateNextImage(boolean forward) {
        if (forward)
        if (currentFile == 0) {
            return forward ? currentFile++ : files.length - 1;
        } else {
            return files.length - 1;
        }
        if(currentFile == files.length - 1){
            return forward ?  0 : files.length - 2;
        }


    {

    }

}


}