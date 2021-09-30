package course.functional.chapter3.task5;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevenuePerson {
    private String name;
    private boolean isYourChild;
    private boolean isStudent;
    private boolean isRefund;
    private int age;
    private double supportAmount;
    private int liveWithMeMonths;
}
