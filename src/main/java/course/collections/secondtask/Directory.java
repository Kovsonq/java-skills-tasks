package course.collections.secondtask;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Directory {
    private Map<String, Set<String>> phoneDirectory = new HashMap<>();

    public void add(String surname, String phone){
        this.phoneDirectory.putIfAbsent(surname, new HashSet<>());
        this.phoneDirectory.get(surname).add(phone);
    }

    public void get(String surname){
        this.phoneDirectory.entrySet().stream()
                .filter(o->o.getKey().equals(surname))
                .forEach(o->log.info("Phones for {} surname: {}", o.getKey(), o.getValue()));
    }

}
