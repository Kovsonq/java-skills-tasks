package course.functional.chapter6Funtion.projectSales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private String phoneNum;
    private String sport;
    private String team;
    private double gpa;
    private String subject;
    private int numFriends;
    private String friends;
}
