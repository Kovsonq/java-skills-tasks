package course.oop.firstlesson.animal;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@NoArgsConstructor
public abstract class Animal {
    @Getter
    private static Map<String, Integer> counter = new HashMap<>();
    @Getter
    private static int count;

    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    protected Animal(String type, String name, int maxRunDistance, int maxSwimDistance) {
        counter.merge(type,1, Integer::sum);
        count++;
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public void run(int runLength){
        if (maxRunDistance == 0) {
            log.info("this animal " + type + " " + name + " cant run " );
        } else if (runLength < maxRunDistance) {
            log.info(type + " " +  name + " ran distance " + runLength);
        } else {
            log.info(type + " " +  name + " can't run distance " + runLength);
        }
    }

    public void swim(int swimLength){
        if (maxSwimDistance == 0) {
            log.info("This " + type + " " + name + " cant swim " );
        } else if (swimLength < maxSwimDistance) {
            log.info(type + " " +  name + " swam distance " + swimLength);
        } else {
            log.info(type + " " +  name + " can't swim distance " + swimLength);
        }
    }
}
