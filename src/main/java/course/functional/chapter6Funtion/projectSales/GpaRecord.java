package course.functional.chapter6Funtion.projectSales;

import lombok.Data;

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
