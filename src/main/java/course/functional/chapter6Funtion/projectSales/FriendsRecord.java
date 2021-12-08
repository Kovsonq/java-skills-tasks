package course.functional.chapter6Funtion.projectSales;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FriendsRecord extends Record{

    private String friends;

    public FriendsRecord(String name, String phoneNum, int index, String friends) {
        super(name, phoneNum, index);
        this.friends = friends;
    }
}
