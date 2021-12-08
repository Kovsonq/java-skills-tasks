package course.functional.chapter4Predicate.task6;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class Card {
    private static List<String> faceValues = Arrays.asList("2","3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace");
    private static List<String> suiteValues = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");

    private String face;
    private String suite;

    public Card() {
        this.face = faceValues.get(new Random().nextInt(13));
        this.suite = suiteValues.get(new Random().nextInt(4));
    }
}
