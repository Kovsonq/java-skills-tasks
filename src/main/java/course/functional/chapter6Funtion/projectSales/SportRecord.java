package course.functional.chapter6Funtion.projectSales;

import lombok.Data;

@Data
public class SportRecord extends Record{

    private String team;

    public SportRecord(String name, String phoneNum, int index, String team) {
        super(name, phoneNum, index);
        this.team = team;
    }

    @Override
    public String toString() {
        return "name: " + getName() + "\'" + " SportRecord " +
                "team='" + team + '\'';
    }
}
