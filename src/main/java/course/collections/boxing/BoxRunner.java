package course.collections.boxing;

import course.collections.boxing.box.Box;
import course.collections.boxing.product.Apple;
import course.collections.boxing.product.Orange;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BoxRunner {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        log.info("Quantity in box: {}", appleBox.getFruitQuantity());
        log.info("Box weight: {}", appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        log.info("Quantity in box: {}", orangeBox.getFruitQuantity());
        log.info("Box weight: {}", orangeBox.getWeight());

        log.info("Boxes are equals: {}", appleBox.compare(orangeBox));

        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.changeBoxes(anotherAppleBox);
        log.info("Quantity in box: {}", appleBox.getFruitQuantity());
        log.info("Box weight: {}", appleBox.getWeight());

        log.info("Quantity in box: {}", anotherAppleBox.getFruitQuantity());
        log.info("Box weight: {}", anotherAppleBox.getWeight());


    }
}
