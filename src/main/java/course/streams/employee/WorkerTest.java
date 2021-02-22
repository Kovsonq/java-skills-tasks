package course.streams.employee;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
public class WorkerTest {
    public static void main(String[] args) {
        final int N = 3;
        Worker[] workers = {
                new Worker("Alex", 22, 355),
                new Worker("Gabi",34,554),
                new Worker("Sam",65,626),
                new Worker("Sanya", 66, 365),
                new Worker("Moisha",15,524),
                new Worker("Gleb",43,646)
        };

        log.info("{}", Arrays.stream(workers).mapToDouble(Worker::getSalary).average());

        log.info(Arrays.stream(workers).sorted(Comparator.comparingInt(Worker::getAge).reversed())
                .map(Worker::getName)
                .limit(N)
                .collect(Collectors.joining(", ",N + " oldest worket names: " ,".")));

    }
}
