package dk.asbjoern.foto.mediasource;

import java.io.File;
import java.io.FileNotFoundException;

public interface MediaWalker {
    void setMediaLocation(File imageDirectory);

    File getNextOrPrev(int prevOrNext) throws FileNotFoundException;

    File getCurrent();
}
