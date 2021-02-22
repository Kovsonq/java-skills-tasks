package course.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ThreadTest {

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    public static void methodOne() {
        final int SIZE = 10000000;
        float[] array = new float[SIZE];
        Arrays.fill(array,1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (double) i / 5) *
                    Math.cos(0.2f + (double) i / 5) * Math.cos(0.4f + (double) i / 2));
        }
        long b = System.currentTimeMillis();
        log.info("Spent: {}", b - a);
    }

    public static void methodTwo() {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] array = new float[SIZE];
        Arrays.fill(array,1.0f);
        long a = System.currentTimeMillis();

        float[] arrayOne = new float[HALF];
        float[] arrayTwo = new float[HALF];
        System.arraycopy(array, 0, arrayOne, 0, HALF);
        System.arraycopy(array, HALF, arrayTwo, 0, HALF);

        Thread first = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + (double) i / 5) *
                        Math.cos(0.2f + (double) i / 5) * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0, j = HALF; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + HALF + (double) j / 5) *
                        Math.cos(0.2f + HALF + (double) j / 5) * Math.cos(0.4f + HALF + (double) j / 2));
            }
        });

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            log.error("Was attempt to Interrupt this thread {}", Thread.currentThread());
            Thread.currentThread().interrupt();
        }

        System.arraycopy(arrayOne, 0, array, 0, HALF);
        System.arraycopy(arrayTwo, 0, array, HALF, HALF);

        long b = System.currentTimeMillis();
        log.info("Spent: {} ", b - a);
    }

}
