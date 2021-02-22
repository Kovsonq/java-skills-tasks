package course.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ThreadTest {

    public static void main(String[] args) {
        methodOne();
        methodTwo();
        methodThree();
        methodFour();
    }

    public static void methodOne() {
        final int SIZE = 10000000;
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);
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
        Arrays.fill(array, 1.0f);
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

    public static void methodThree() {
        final int SIZE = 10000000;
        final int QUARTER = SIZE / 4;
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);

        long a = System.currentTimeMillis();

        float[] arrayOne = new float[QUARTER];
        float[] arrayTwo = new float[QUARTER];
        float[] arrayThree = new float[QUARTER];
        float[] arrayFour = new float[QUARTER];

        System.arraycopy(array, 0, arrayOne, 0, QUARTER);
        System.arraycopy(array, QUARTER, arrayTwo, 0, QUARTER);
        System.arraycopy(array, QUARTER * 2, arrayThree, 0, QUARTER);
        System.arraycopy(array, QUARTER * 3, arrayFour, 0, QUARTER);

        Thread first = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + (double) i / 5) *
                        Math.cos(0.2f + (double) i / 5) * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0, j = QUARTER; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread third = new Thread(() -> {
            for (int i = 0, j = QUARTER*2; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread fourth = new Thread(() -> {
            for (int i = 0, j = QUARTER*3; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        first.start();
        second.start();
        third.start();
        fourth.start();

        try {
            first.join();
            second.join();
            third.join();
            fourth.join();
        } catch (InterruptedException e) {
            log.error("Was attempt to Interrupt this thread {}", Thread.currentThread());
            Thread.currentThread().interrupt();
        }

        System.arraycopy(arrayOne, 0, array, 0, QUARTER);
        System.arraycopy(arrayTwo, 0, array, QUARTER, QUARTER);
        System.arraycopy(arrayThree, 0, array, QUARTER*2, QUARTER);
        System.arraycopy(arrayFour, 0, array, QUARTER*3, QUARTER);

        long b = System.currentTimeMillis();
        log.info("Spent: {} ", b - a);
    }

    public static void methodFour() {
        final int SIZE = 10000000;
        final int MIN = SIZE / 8;
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);

        long a = System.currentTimeMillis();

        float[] arrayOne = new float[MIN];
        float[] arrayTwo = new float[MIN];
        float[] arrayThree = new float[MIN];
        float[] arrayFour = new float[MIN];
        float[] arrayFive = new float[MIN];
        float[] arraySix = new float[MIN];
        float[] arraySeven = new float[MIN];
        float[] arrayEight = new float[MIN];

        System.arraycopy(array, 0, arrayOne, 0, MIN);
        System.arraycopy(array, MIN, arrayTwo, 0, MIN);
        System.arraycopy(array, MIN * 2, arrayThree, 0, MIN);
        System.arraycopy(array, MIN * 3, arrayFour, 0, MIN);
        System.arraycopy(array, MIN * 4, arrayFive, 0, MIN);
        System.arraycopy(array, MIN * 5, arraySix, 0, MIN);
        System.arraycopy(array, MIN * 6, arraySeven, 0, MIN);
        System.arraycopy(array, MIN * 7, arrayEight, 0, MIN);

        Thread first = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + (double) i / 5) *
                        Math.cos(0.2f + (double) i / 5) * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0, j = MIN; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread third = new Thread(() -> {
            for (int i = 0, j = MIN*2; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread fourth = new Thread(() -> {
            for (int i = 0, j = MIN*3; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread fifth = new Thread(() -> {
            for (int i = 0, j = MIN*4; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread sixth = new Thread(() -> {
            for (int i = 0, j = MIN*5; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread seventh = new Thread(() -> {
            for (int i = 0, j = MIN*7; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        Thread eights = new Thread(() -> {
            for (int i = 0, j = MIN*8; i < arrayTwo.length; i++, j++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + j + (double) j / 5) *
                        Math.cos(0.2f + j + (double) j / 5) * Math.cos(0.4f + j + (double) j / 2));
            }
        });

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();
        sixth.start();
        seventh.start();
        eights.start();

        try {
            first.join();
            second.join();
            third.join();
            fourth.join();
            fifth.join();
            sixth.join();
            seventh.join();
            eights.join();
        } catch (InterruptedException e) {
            log.error("Was attempt to Interrupt this thread {}", Thread.currentThread());
            Thread.currentThread().interrupt();
        }

        System.arraycopy(arrayOne, 0, array, 0, MIN);
        System.arraycopy(arrayTwo, 0, array, MIN, MIN);
        System.arraycopy(arrayThree, 0, array, MIN*2, MIN);
        System.arraycopy(arrayFour, 0, array, MIN*3, MIN);
        System.arraycopy(arrayThree, 0, array, MIN*4, MIN);
        System.arraycopy(arrayFour, 0, array, MIN*5, MIN);
        System.arraycopy(arrayThree, 0, array, MIN*6, MIN);
        System.arraycopy(arrayFour, 0, array, MIN*7, MIN);

        long b = System.currentTimeMillis();
        log.info("Spent: {} ", b - a);
    }

}
