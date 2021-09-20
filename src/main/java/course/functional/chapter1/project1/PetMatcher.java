package course.functional.chapter1.project1;

import java.util.List;

@FunctionalInterface
public interface PetMatcher {

    List<Pet> match(Pet pet);

    default Pet first(Pet pet){
        int index = Pet.petList.indexOf(pet);
        return index > -1 ? Pet.petList.get(index) : null;
    }

}
