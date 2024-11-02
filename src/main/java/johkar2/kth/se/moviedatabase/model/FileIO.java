package johkar2.kth.se.moviedatabase.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileIO {

    static void writeMediaToFile(File file, Media media) throws IOException {
        if (file == null) throw new IllegalArgumentException();
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = new FileOutputStream("mediaList.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(media);
        }
        finally {
            assert oos != null;
            oos.close();
        }
    }
}