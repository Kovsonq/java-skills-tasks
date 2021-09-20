package course.functional.chapter1.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {
    String name;
    String animal;
    String breed;
    String color;
    double price;

    static List<Pet> petList = new ArrayList<>();

    public Pet(String name, String animal, String breed, String color, double price) {
        this.name = name;
        this.animal = animal;
        this.breed = breed;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", animal='" + animal + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return animal.equals(pet.animal) && breed.equals(pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal, breed);
    }
}
