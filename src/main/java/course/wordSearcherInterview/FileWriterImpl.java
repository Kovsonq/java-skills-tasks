package course.wordSearcherInterview;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterImpl implements FileWriter {

    @Override
    public void saveData(String path, String result) {
        try (PrintWriter out = new PrintWriter(path)) {
            out.println(result);
            System.out.println("Result saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error during saving");
        }
    }
}
