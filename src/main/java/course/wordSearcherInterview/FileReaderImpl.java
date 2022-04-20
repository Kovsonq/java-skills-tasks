package course.wordSearcherInterview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> loadContent(String path) {
        try {
            return Files
                    .lines(Paths.get(path))
                    .map(line -> line.replaceAll("[^a-zA-Z' ']+", ""))
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error during reading file");
        }
        return new ArrayList<>();
    }
}
