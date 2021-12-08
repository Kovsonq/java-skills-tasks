package course.checkNPE;

import java.util.Comparator;
import java.util.List;

public class TestStreamMin {
    public static void main(String[] args) {
        List<Event> eventList = List.of(new Event(1, "somethins1"),
                new Event(2, "somethins2"),
                new Event(3, "somethins6"),
                new Event(4, "somethins3"),
                new Event(5, "somethins4"),
                new Event(6, "somethins5"));

        List<Event> eventOneList = List.of(new Event(1, "somethins1"));

        String result1 = eventList.stream()
                .filter(event -> null != event.lastTimestamp)
                .max(Comparator.comparing(Event::getLastTimestamp))
                .map(Event::getName)
                .map(String::toLowerCase)
                .orElse("nothing");

        System.out.println(result1);

        String result2 = eventOneList.stream()
                .filter(event -> null != event.lastTimestamp)
                .min(Comparator.comparing(Event::getLastTimestamp))
                .map(Event::getName)
                .map(String::toLowerCase)
                .orElse("nothing");
        System.out.println(result2);
    }




    static class Event {

        public Event(Integer lastTimestamp, String name) {
            this.lastTimestamp = lastTimestamp;
            this.name = name;
        }

        public Integer getLastTimestamp() {
            return lastTimestamp;
        }

        public void setLastTimestamp(Integer lastTimestamp) {
            this.lastTimestamp = lastTimestamp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Integer lastTimestamp;
        String name;
    }
}
