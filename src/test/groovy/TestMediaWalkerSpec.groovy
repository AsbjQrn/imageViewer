import dk.asbjoern.foto.mediasource.MediaWalkerDefault
import spock.lang.Specification

class TestMediaWalkerSpec extends Specification {

    def "Test MediaWalker kan køre "() {

        setup:
        MediaWalkerDefault mediaWalker = new MediaWalkerDefault()
        mediaWalker.setMediaLocation(new File("src/main/resources/imagesJPEG"));

        when:
        File file = mediaWalker.getNextOrPrev(0)
        String absolutePath = file.getAbsolutePath();

        then:
        absolutePath.contains("src/main/resources/imagesJPEG")


    }


}
