package course.collections.secondtask;

public class DirectoryTest {
    public static void main(String[] args) {
        Directory directory = new Directory();

        directory.add("Mickle", "+375297745261");
        directory.add("Mickle", "+375297745262");
        directory.add("Mickle", "+375297745263");

        directory.get("Mickle");
    }
}
