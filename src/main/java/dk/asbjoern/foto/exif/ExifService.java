package dk.asbjoern.foto.exif;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public interface ExifService {


    default void handleException(File file, Exception e) {
        System.out.println(file.getAbsolutePath());
        e.printStackTrace();
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e1) {
            System.exit(100);
        }
    }

    default void readExif(File file) throws ImageProcessingException, IOException {

        Metadata metadata = ImageMetadataReader.readMetadata(file);

        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.format("[%s] - %s = %s",
                        directory.getName(), tag.getTagName(), tag.getDescription());
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }

    }

    Optional<LocalDate> readExifDate(Optional<Metadata> metadata);
}
