package course.functional.chapter6Funtion.projectSales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Record {
    private String name;
    private String phoneNum;
    private int index;
}
