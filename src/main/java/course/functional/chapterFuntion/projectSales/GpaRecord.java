package course.functional.chapterFuntion.projectSales;

import lombok.Data;
import lombok.ToString;

@Data
public class GpaRecord extends Record{

    private String subject;

    public GpaRecord(String name, String phoneNum, int index, String subject) {
        super(name, phoneNum, index);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "name: " + getName() + '\'' + "GpaRecord{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
