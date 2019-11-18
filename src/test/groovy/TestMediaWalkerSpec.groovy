import dk.asbjoern.foto.mediasource.MediaWalkerDefault
import spock.lang.Specification

import java.nio.file.Path

class TestMediaWalkerSpec extends Specification {

    def "Test MediaWalker kan køre "() {

        MediaWalkerDefault mediaWalker = new MediaWalkerDefault(Path.of("src/main/resources/imagesJPEG"))
        when:
        int a = 2 + 3
        mediaWalker.filenext();

        then:
        a == 5


    }


}
