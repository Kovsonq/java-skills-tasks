package course.functional.chapterPredicate.projectCar;


import java.util.List;
import java.util.function.Predicate;

public interface CarQualifier {

    String getQualifierName();

    List<Predicate<Customer>> getCarQualifier();

}
