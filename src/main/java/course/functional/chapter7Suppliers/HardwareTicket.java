package course.functional.chapter7Suppliers;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HardwareTicket extends Ticket {
    private String device;
    private String model;
    private String serialNumber;

    public HardwareTicket(String customerName, int id, String description, int due,
                          String device, String model, String serialNumber) {
        super(customerName, id, description, due);
        this.device = device;
        this.model = model;
        this.serialNumber = serialNumber;
    }
}
