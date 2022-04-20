package course.functional.chapter7Suppliers;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SoftwareTicket extends Ticket {
    private String application;
    private String version;
    private Domain domain;

    public SoftwareTicket(String customerName, int id, String description, int due,
                          String application, String version, Domain domain) {
        super(customerName, id, description, due);
        this.application = application;
        this.version = version;
        this.domain = domain;
    }

    enum Domain {WEB_HOSTED, PHONE, PHONE_HOSTED};
}
