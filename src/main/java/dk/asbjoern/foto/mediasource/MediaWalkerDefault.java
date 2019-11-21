package dk.asbjoern.foto.mediasource;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class MediaWalkerDefault implements MediaWalker {

    private ArrayList<File> mediaList;

    private int currentMediaindex = 0;

    @Override
    public void setMediaLocation(File imageDirectory) {
        this.mediaList = (ArrayList<File>) Arrays.stream(imageDirectory.listFiles()).filter(File::isFile).collect(Collectors.toList());
        currentMediaindex = 0;
    }

    @Override
    public File getNextOrPrev(int prevOrNext) throws FileNotFoundException {

        calculateNext(prevOrNext);

        return mediaList.get(currentMediaindex);

    }

    @Override
    public File getCurrent() {
        return mediaList.get(currentMediaindex);
    }

    private void calculateNext(int prevOrNext) {

        currentMediaindex = currentMediaindex + prevOrNext;

        if (currentMediaindex < 0) currentMediaindex = mediaList.size() - 1;

        if (currentMediaindex >= mediaList.size()) currentMediaindex = 0;
    }


}
