package course.functional.ivanTask;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private int contributions;
}
