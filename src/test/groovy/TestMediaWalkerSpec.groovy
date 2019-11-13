import dk.asbjoern.foto.mediasource.MediaWalker
import spock.lang.Specification

import java.nio.file.Path

class TestMediaWalkerSpec extends Specification {

    def "Test MediaWalker kan køre "() {

        MediaWalker mediaWalker = new MediaWalker(Path.of("src/main/resources/imagesJPEG"))
        when:
        int a = 2 + 3
        mediaWalker.filenext();

        then:
        a == 5


    }


}
