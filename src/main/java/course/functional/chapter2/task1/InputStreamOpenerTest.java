package course.functional.chapter2.task1;

import course.functional.chapter1.task1.InputStreamOpener;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamOpenerTest {

    public static void main(String[] args) {

        InputStreamOpener dataInputStream = s -> new DataInputStream(
                new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8))
        );

        InputStreamOpener objectInputStream = s -> {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeBytes(s);
                objectOutputStream.flush();
                byte[] bytes = outputStream.toByteArray();
                InputStream inputStream = new ByteArrayInputStream(bytes);
                return new ObjectInputStream(inputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return null;
            }
        };

        InputStreamOpener bufferedInputStream = s -> new BufferedInputStream(
                new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8))
        );

        try (InputStream is = dataInputStream.open("My string for data 3")) {
            System.out.println(is.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(objectInputStream.open("My string for object").available());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(bufferedInputStream.open("My string for buffered").available());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
