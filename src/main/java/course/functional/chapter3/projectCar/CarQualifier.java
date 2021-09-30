package course.functional.chapter3.projectCar;


import java.util.List;
import java.util.function.Predicate;

public interface CarQualifier {

    String getQualifierName();

    List<Predicate<Customer>> getCarQualifier();

}
