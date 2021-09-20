package course.functional.chapter1.task1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamOpenerTest {

    public static void main(String[] args) {

        InputStreamOpener dataInputStream = new InputStreamOpener() {
            @Override
            public InputStream open(String s) {
                InputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
                return new DataInputStream(inputStream);
            }
        };

        InputStreamOpener objectInputStream = new InputStreamOpener() {
            @Override
            public InputStream open(String s) {
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
            }
        };

        InputStreamOpener bufferedInputStream = new InputStreamOpener() {
            @Override
            public InputStream open(String s) {
                InputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
                return new BufferedInputStream(inputStream);
            }
        };

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
