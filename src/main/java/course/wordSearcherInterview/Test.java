package course.wordSearcherInterview;

//1) принимает на вход три параметра:
// имя входного файла,
// список слов для поиска,
// параметр показывающий учитывать ли регистр символов при поиске
//2) ищет во входном файле количества вхождений для каждого из слов для поиска,
// учитывая/или не учитывая регистр в зависимости от переданного параметра
//3) записывает результат в выходной файл

//Код должен быть написан с учётом того чтобы в будущем он был поддерживаемым и расширяемым.

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> content = fileReader.loadContent("C:\\Users\\kovso\\IdeaProjects\\untitled2\\src\\wordSearcher\\Test.txt");

        WordSearcher worldSearcher = new WordSearcherImpl();
        Map<String, Long> words = worldSearcher.calculateWords(content, List.of("fox", "quiz"), false);

        if (words != null) {
            FileWriter fileWriter = new FileWriterImpl();
            fileWriter.saveData("resultMap.txt", words.toString());
        }
    }
}
