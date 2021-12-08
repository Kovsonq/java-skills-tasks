package course.functional.chapter6Funtion.task4;

import course.functional.chapter6Funtion.overall.Function;
import course.functional.chapter4Predicate.task6.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskFourTest {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        Function<Integer, Card> deckCreator = x -> {
            Card card = new Card();

            while (deck.contains(card)) {
                card = new Card();
            }
            return card;
        };

        for (int i = 1; i < 53; i++) {
            deck.add(deckCreator.apply(i));
        }
        deck.stream().filter(x -> x.getSuite().equals("Spades")).forEach(x -> System.out.println(x));

        System.out.println("------------------------------------------");

        System.out.println(deck);
        System.out.println(deck.size());
        Function<List<Card>,Card[]> shuffleDeck = x -> {
            Card[] shuffledDeck = new Card[52];
            for (Card card : x){
                int randomIndex = new Random().nextInt(52);
                while (shuffledDeck[randomIndex] != null){
                    randomIndex = new Random().nextInt(52);
                }
                shuffledDeck[randomIndex] = card;
            }
            return shuffledDeck;
        };

        System.out.println(Arrays.toString(shuffleDeck.apply(deck)));

        Function<List<Card>, List<Card>> shuffledDeck2 = x -> {
            List<Card> shuffledDeck = new ArrayList<>(52);
            for (int i = 0; i < 52; i++) {
                int randomIndex = new Random().nextInt(52);
                while (shuffledDeck.contains(x.get(randomIndex))){
                    randomIndex = new Random().nextInt(52);
                }
                shuffledDeck.add(x.get(randomIndex));
            }
            return shuffledDeck;
        };
        System.out.println(shuffledDeck2.apply(deck));
    }
}
