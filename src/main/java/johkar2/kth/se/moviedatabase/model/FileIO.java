package johkar2.kth.se.moviedatabase.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    static void writeMediaToFile(List<Media> media) throws IOException {
        ObjectOutputStream oos = null;
        File file = new File("C:\\Movie Database\\src\\main\\resources\\media.ser");
        try {
            FileOutputStream fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(media);
        }
        finally {
            assert oos != null;
            oos.close();
        }
    }

    static List<Media> readMediaFromFile() throws Exception {
        ObjectInputStream ois = null;
        ArrayList<Media> list = null;
        try {
            FileInputStream fin = new FileInputStream("mediaList.ser");
            ois = new ObjectInputStream(fin);
            list = (ArrayList<Media>) ois.readObject();
        } finally {
            assert ois != null;
            ois.close();
        }
        return list;
    }
}