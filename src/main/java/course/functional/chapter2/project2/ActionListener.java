package course.functional.chapter2.project2;

import java.awt.event.ActionEvent;
import java.util.EventListener;

@FunctionalInterface
public interface ActionListener extends EventListener {
    void actionPerformed(ActionEvent event);
}
