package course.functional.chapter4Predicate.projectCar;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PriusCarQualifier implements CarQualifier{

    private final String qualifierName = "Prius";

    private final List<Predicate<Customer>> predicates = Arrays.asList(
            customer -> customer.getGender().equals("male"),
            customer -> customer.getCity().equals("New York"),
            customer -> customer.getAge() > 20 && customer.getAge() < 30,
            customer -> customer.getEducation().equals("bachelor"));

    @Override
    public String getQualifierName() {
        return this.qualifierName;
    }

    @Override
    public List<Predicate<Customer>> getCarQualifier() {
        return this.predicates;
    }
}
