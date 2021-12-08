package course.functional.chapter3Consumer.task6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;

public class Test {
    private static final List<Apartment> building = List.of(
            new TwoRooms(3,4,5,6),
            new TwoRooms(3,4,5,6),
            new TwoRooms(6,3,4,6),
            new TwoRooms(6,3,4,6),
            new TwoRooms(6,3,4,6),
            new ThreeRooms(3,4,5,6, 2,3),
            new ThreeRooms(3,4,5,6, 2,3),
            new ThreeRooms(3,4,5,7, 2,5),
            new ThreeRooms(3,4,5,7, 2,5),
            new ThreeRooms(3,4,5,7, 2,5)
    );

    private static Double overallSquare = 0.;

    public static void main(String[] args) {
        Consumer<Apartment> calculate = x -> overallSquare +=x.calculateSquare();

        for (Apartment apartment : building){
            calculate.accept(apartment);
        }
        System.out.println(overallSquare);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Apartment {
        protected double firstRoomLength;
        protected double firstRoomWidth;
        protected double secondRoomLength;
        protected double secondRoomWidth;

        public Double calculateSquare(){
            return firstRoomLength*firstRoomWidth + secondRoomLength*secondRoomWidth;
        }
    }
    @Data
    private static class TwoRooms extends Apartment {
        public TwoRooms(double firstRoomLength, double firstRoomWidth, double secondRoomLength, double secondRoomWidth) {
            super(firstRoomLength, firstRoomWidth, secondRoomLength, secondRoomWidth);
        }
    }
    @Data
    private static class ThreeRooms extends Apartment {
        private double thirdRoomLength;
        private double thirdRoomWidth;
        public ThreeRooms(double firstRoomLength, double firstRoomWidth, double secondRoomLength, double secondRoomWidth,
                          double thirdRoomLength, double thirdRoomWidth) {
            super(firstRoomLength, firstRoomWidth, secondRoomLength, secondRoomWidth);
            this.thirdRoomLength = thirdRoomLength;
            this.thirdRoomWidth = thirdRoomWidth;
        }
        public Double calculateSquare(){
            return super.calculateSquare() + thirdRoomLength*thirdRoomWidth;
        }
    }
}
