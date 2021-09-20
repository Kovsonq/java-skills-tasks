package course.functional.chapter1.project1;

import java.util.ArrayList;
import java.util.List;

public class PetMatcherTest {

    private static void matchPet(String criteria, PetMatcher petMatcher, Pet pet){
        System.out.println("\n" + criteria + ":");
        System.out.println("First: " + petMatcher.first(pet));
        System.out.println("All matches: ");
        List<Pet> matches = petMatcher.match(pet);
        for (Pet p : matches){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Pet.petList.add(new Pet("Sam", "dog", "poodel", "white", 900));
        Pet.petList.add(new Pet("Max", "dog", "poodel", "yellow", 850));
        Pet.petList.add(new Pet("Tom", "cat", "poodel", "brown", 392));
        Pet.petList.add(new Pet("Jack", "dog", "poodel", "white", 400));
        Pet.petList.add(new Pet("Sirius", "cat", "poodel", "orange", 500));
        Pet.petList.add(new Pet("Toolly", "cat", "siamese", "black", 350));

        PetMatcher breedPetMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();

                for (Pet p : Pet.petList){
                    if (p.equals(pet)){
                        matches.add(p);
                    }
                } return matches;
            }
        };
        PetMatcher priceMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();

                for (Pet p : Pet.petList){
                    if (p.price <= pet.price){
                        matches.add(p);
                    }
                }
                return matches;
            }

            /**
             * Find minimum price from all list which is in match the filter
             * @param pet
             * @return
             */
            @Override
            public Pet first(Pet pet) {
                int indexMin = -1;
                for (int i = 0; i < Pet.petList.size(); i++) {
                    if (Pet.petList.get(i).price <= pet.price){
                        if (indexMin == -1){
                            indexMin = i;
                            continue;
                        }
                        if (Pet.petList.get(i).price < Pet.petList.get(indexMin).price){
                            indexMin = i;
                        }
                    }
                }
                if (indexMin == -1){
                    return null;
                } else {
                    return Pet.petList.get(indexMin);
                }
            }
        };

        matchPet("Poodels", breedPetMatcher, new Pet(null, "dog", "poodel", null, 0.0));
        matchPet("Pet's less than 600$", priceMatcher, new Pet(null,null,null,null,800.0));

    }
}
