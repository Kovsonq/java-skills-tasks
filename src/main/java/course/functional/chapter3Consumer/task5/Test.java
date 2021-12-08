package course.functional.chapter3Consumer.task5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    private static List<Product> dvdArrayList = List.of(
            new DVD("Vlastelin", "Pixaar", 2230.0),
            new DVD("Tony Hanks", "Pixaar", 3330.0),
            new DVD("Clancy Tomb", "Disnay", 543.5),
            new Audio("PinkFloyid", "Green", 2230.0),
            new Audio("Morgen", "Black", 2010.5),
            new Audio("RHCP", "White", 4000.0),
            new EBooks("Katehezis", 44, 20.0),
            new EBooks("Kolobok", 554, 30.0),
            new EBooks("Soika", 423, 40.5));

    private static final List<String> titles = new ArrayList<>();
    private static final List<Double> sizes = new ArrayList<>();

    public static void main(String[] args) {
        Consumer<Product> productConsumer = x -> {
            titles.add(x.title);
            sizes.add(x.size);
        };

        for (Product product : dvdArrayList){
            productConsumer.accept(product);
        }

        System.out.println(titles);
        System.out.println(sizes);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product {
        private String title;
        private Double size;
    }
    @Data
    public static class DVD extends Product {
        private String productionCompany;
        public DVD(String name, String productionCompany, Double size){
            super(name, size);
            this.productionCompany = productionCompany;
        }
    }
    @Data
    public static class Audio extends Product  {
        private String format;
        public Audio(String name, String format, Double size){
            super(name, size);
            this.format = format;
        }
    }
    @Data
    public static class EBooks extends Product  {
        private int pages;
        public EBooks(String name, int pages, Double size){
            super(name, size);
            this.pages = pages;
        }
    }
}
