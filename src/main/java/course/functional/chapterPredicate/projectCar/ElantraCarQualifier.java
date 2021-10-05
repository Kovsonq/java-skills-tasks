package course.functional.chapterPredicate.projectCar;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ElantraCarQualifier implements CarQualifier{

    private final String qualifierName = "Elantra";

    private final List<Predicate<Customer>> predicates = Arrays.asList(
            customer -> customer.getGender().equals("female"),
            customer -> customer.getCity().equals("New Jersey") || customer.getCity().equals("Pennsylvania"),
            customer -> customer.getAge() > 40 && customer.getAge() < 50,
            customer -> customer.getEducation().equals("highschool"));

    @Override
    public String getQualifierName() {
        return this.qualifierName;
    }

    @Override
    public List<Predicate<Customer>> getCarQualifier() {
        return this.predicates;
    }
}
