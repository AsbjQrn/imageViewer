package dk.asbjoern.foto.exif;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

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

    default Optional<Metadata> readExif(File file) {

        Optional<Metadata> metadata = Optional.empty();

        try {

            System.out.println(String.format("Reading exif for %s", file.getAbsolutePath()));

//          Frameworket kan i særlige tilfælde kaste en nullPointer selvom der er exifdata.
            try {
                ImageMetadataReader.readMetadata(file);
                metadata = Optional.ofNullable(ImageMetadataReader.readMetadata(file));
            } catch (NullPointerException e) {
                System.out.println("Nullpointer i framework i filen: " + file.getAbsolutePath());
                e.printStackTrace();
            }



        } catch (
                ImageProcessingException e) {
            handleException(file, e);
        } catch (
                IOException e) {
            handleException(file, e);
        }

        return metadata;


    }

    Optional<LocalDate> readExifDate(Optional<Metadata> metadata);
}
