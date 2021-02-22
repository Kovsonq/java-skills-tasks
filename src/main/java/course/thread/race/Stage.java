package course.thread.race;

import lombok.Data;

@Data
public abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car c);
}

