package course.functional.chapter4Predicate.task6;

import course.functional.chapter4Predicate.overall.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokerTest {
    public static void main(String[] args) {
        List<Card> myHand = new ArrayList<>();
        List<Card> yourHand = new ArrayList<>();
        List<Card> clownHand = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            myHand.add(new Card());
            yourHand.add(new Card());
            clownHand.add(new Card());
        }

        Predicate<List<Card>> straight = predicateStraight();
        Predicate<List<Card>> flush = predicateFlush();
        Predicate<List<Card>> fullHouse = predicateFullHouse();

        System.out.println("My Hand is :" + myHand);
        System.out.println("My Hand is straight :" + straight.test(myHand));
        System.out.println("My Hand is flush :" + flush.test(myHand));
        System.out.println("My Hand is fullHouse :" + fullHouse.test(myHand));

        System.out.println("yourHand is :" + yourHand);
        System.out.println("yourHand is straight :" + straight.test(yourHand));
        System.out.println("yourHand is flush :" + flush.test(yourHand));
        System.out.println("yourHand is fullHouse :" + fullHouse.test(yourHand));

        System.out.println("clownHand is :" + clownHand);
        System.out.println("clownHand is straight :" + straight.test(clownHand));
        System.out.println("clownHand is flush :" + flush.test(clownHand));
        System.out.println("clownHand is fullHouse :" + fullHouse.test(clownHand));

    }

    private static Predicate<List<Card>> predicateStraight() {
        return cards -> (Objects.equals(cards.get(0).getFace(), "2") &&
                Objects.equals(cards.get(1).getFace(), "3") &&
                Objects.equals(cards.get(2).getFace(), "4") &&
                Objects.equals(cards.get(3).getFace(), "5") &&
                Objects.equals(cards.get(4).getFace(), "6")) ||
                (Objects.equals(cards.get(0).getFace(), "3") &&
                        Objects.equals(cards.get(1).getFace(), "4") &&
                        Objects.equals(cards.get(2).getFace(), "5") &&
                        Objects.equals(cards.get(3).getFace(), "6") &&
                        Objects.equals(cards.get(4).getFace(), "7")) ||
                (Objects.equals(cards.get(0).getFace(), "4") &&
                        Objects.equals(cards.get(1).getFace(), "5") &&
                        Objects.equals(cards.get(2).getFace(), "6") &&
                        Objects.equals(cards.get(3).getFace(), "7") &&
                        Objects.equals(cards.get(4).getFace(), "8")) ||
                (Objects.equals(cards.get(0).getFace(), "5") &&
                        Objects.equals(cards.get(1).getFace(), "6") &&
                        Objects.equals(cards.get(2).getFace(), "7") &&
                        Objects.equals(cards.get(3).getFace(), "8") &&
                        Objects.equals(cards.get(4).getFace(), "9")) ||
                (Objects.equals(cards.get(0).getFace(), "6") &&
                        Objects.equals(cards.get(1).getFace(), "7") &&
                        Objects.equals(cards.get(2).getFace(), "8") &&
                        Objects.equals(cards.get(3).getFace(), "9") &&
                        Objects.equals(cards.get(4).getFace(), "10")) ||
                (Objects.equals(cards.get(0).getFace(), "7") &&
                        Objects.equals(cards.get(1).getFace(), "8") &&
                        Objects.equals(cards.get(2).getFace(), "9") &&
                        Objects.equals(cards.get(3).getFace(), "10") &&
                        Objects.equals(cards.get(4).getFace(), "Jack")) ||
                (Objects.equals(cards.get(0).getFace(), "8") &&
                        Objects.equals(cards.get(1).getFace(), "9") &&
                        Objects.equals(cards.get(2).getFace(), "10") &&
                        Objects.equals(cards.get(3).getFace(), "Jack") &&
                        Objects.equals(cards.get(4).getFace(), "Queen")) ||
                (Objects.equals(cards.get(0).getFace(), "9") &&
                        Objects.equals(cards.get(1).getFace(), "10") &&
                        Objects.equals(cards.get(2).getFace(), "Jack") &&
                        Objects.equals(cards.get(3).getFace(), "Queen") &&
                        Objects.equals(cards.get(4).getFace(), "King")) ||
                (Objects.equals(cards.get(0).getFace(), "10") &&
                        Objects.equals(cards.get(1).getFace(), "Jack") &&
                        Objects.equals(cards.get(2).getFace(), "Queen") &&
                        Objects.equals(cards.get(3).getFace(), "King") &&
                        Objects.equals(cards.get(4).getFace(), "Ace"));
    }

    private static Predicate<List<Card>> predicateFlush() {
        return cards -> cards.get(0).getSuite().equals(cards.get(1).getSuite()) &&
                cards.get(1).getSuite().equals(cards.get(2).getSuite()) &&
                cards.get(2).getSuite().equals(cards.get(3).getSuite()) &&
                cards.get(3).getSuite().equals(cards.get(4).getSuite());
    }

    private static Predicate<List<Card>> predicateFullHouse() {
        return cards -> {
            int twoCards = 0;
            int threeCards = 0;
            int fourCards = 0;
            int fiveCards = 0;
            int sixCards = 0;
            int sevenCards = 0;
            int eightCards = 0;
            int nineCards = 0;
            int tenCards = 0;
            int jackCards = 0;
            int queenCards = 0;
            int kingCards = 0;
            int aceCards = 0;

            for (Card card : cards) {
                switch (card.getFace()) {
                    case "2":
                        twoCards++;
                        break;
                    case "3":
                        threeCards++;
                        break;
                    case "4":
                        fourCards++;
                        break;
                    case "5":
                        fiveCards++;
                        break;
                    case "6":
                        sixCards++;
                        break;
                    case "7":
                        sevenCards++;
                        break;
                    case "8":
                        eightCards++;
                        break;
                    case "9":
                        nineCards++;
                        break;
                    case "10":
                        tenCards++;
                        break;
                    case "Jack":
                        jackCards++;
                        break;
                    case "Queen":
                        queenCards++;
                        break;
                    case "King":
                        kingCards++;
                        break;
                    case "Ace":
                        aceCards++;
                        break;
                }
            }
            if (twoCards == 3 || threeCards == 3 || fourCards == 3 || fiveCards == 3 || sixCards == 3 ||
                    sevenCards == 3 || eightCards == 3 || nineCards == 3 || tenCards == 3 || jackCards == 3 ||
                    queenCards == 3 || kingCards == 3 || aceCards == 3) {
                return true;
            }
            return false;
        };
    }
}
