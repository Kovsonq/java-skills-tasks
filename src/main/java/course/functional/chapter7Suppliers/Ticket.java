package course.functional.chapter7Suppliers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public abstract class Ticket implements Comparable<Ticket> {
    private String customerName;
    private int id;
    private String description;
    private LocalDate dueDate;
    private LocalDate servicedDate;

    public Ticket(String customerName, int id, String description, int due) {
        this.customerName = customerName;
        this.id = id;
        this.description = description;
        this.dueDate = LocalDate.now().plusDays(due);
        this.servicedDate = LocalDate.now().minusDays(1);
    }

    @Override
    public int compareTo(Ticket o) {
        return dueDate.compareTo(o.dueDate);
    }
}
