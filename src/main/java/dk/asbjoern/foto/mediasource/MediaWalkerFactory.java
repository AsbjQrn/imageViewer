package dk.asbjoern.foto.mediasource;


import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class MediaWalkerFactory {


    public MediaWalker getMediaWalker(Path path){

        return new MediaWalker(path);

    }

}
