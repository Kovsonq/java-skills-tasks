package course.functional.chapterPredicate.task5;

import course.functional.chapterPredicate.overall.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RevenueServiceTest {
    public static void main(String[] args) {
        RevenuePerson paha = new RevenuePerson("Paha", false, true, false,
                19, 45, 9);
        RevenuePerson maha = new RevenuePerson("Maha", false, false, false,
                25, 100, 12);
        RevenuePerson fake = new RevenuePerson("Fake", true, true, false,
                23, 49, 4);
        Collection<RevenuePerson> someCollection = new ArrayList<>();
        Collections.addAll(someCollection, paha,maha,fake);

        Predicate<RevenuePerson> service = RevenuePerson::isYourChild;

        for (RevenuePerson person : someCollection) {
            System.out.println(service
                    .and(revenuePerson -> (revenuePerson.getAge() < 19 && revenuePerson.getAge() < 25) ||
                            (revenuePerson.isStudent() && revenuePerson.getAge() < 24))
                    .and(revenuePerson -> revenuePerson.getSupportAmount() < 50)
                    .and(revenuePerson -> !revenuePerson.isRefund())
                    .and(revenuePerson -> revenuePerson.getLiveWithMeMonths() < 6)
                    .test(person)
            );
        }
    }
}
