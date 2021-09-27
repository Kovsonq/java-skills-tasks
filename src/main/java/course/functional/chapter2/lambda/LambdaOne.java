package course.functional.chapter2.lambda;

import course.functional.chapter1.staticMethod.StringProcessor;

public class LambdaOne {

    static double notZero = 1;

    public static void main(String[] args) {

        /**
         * lambda_argument_list  -> lambda_body
         * the fields of the lambda should be final, or effectively final (not changed after initializing)
         */
        int zero = 0;
        StringProcessor stringProcessor = x -> x + zero + notZero;


        System.out.println(stringProcessor.process("lalal"));

    }

}
