package course.functional.chapter4Predicate.projectCar;


import java.util.List;
import java.util.function.Predicate;

public interface CarQualifier {

    String getQualifierName();

    List<Predicate<Customer>> getCarQualifier();

}
