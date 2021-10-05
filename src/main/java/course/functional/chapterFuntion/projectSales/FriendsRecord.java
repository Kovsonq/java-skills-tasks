package course.functional.chapterFuntion.projectSales;

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
