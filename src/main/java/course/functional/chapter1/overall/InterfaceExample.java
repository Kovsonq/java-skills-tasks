package course.functional.chapter1.overall;

import java.util.Random;

interface InterfaceExample {
    String s = "I2";

    /**
     * In java 8
     * Static method can be called without creation of an object
     */
    static void method1(){
        System.out.println(s);
    }

    /**
     * In java 8
     * Default method provided by the interface that does not have to be overriden by an  implementing class
     * @param x
     * @return
     */
    default String method2(String x){
        return s + x;
    }

    /**
     * In java 9
     * Private methods are userful for the default method
     * @return
     */
    private int getNumberRundomTwoHundred(){
        return new Random().nextInt(200);
    }

    default String message(String message){
        return message + getNumberRundomTwoHundred();
    }

    /**
     * In java 9
     * Static private method are useful to call from static methods
     * This method can only be called by public static methods defined in the interface becouse it can be
     * called without creation of an implementing object
     * @return
     */
    static private int getNumberOneHundred(){
        return (new Random().nextInt(100));
    }

    public static void m1(String message){
        System.out.println(message + getNumberOneHundred());
    }
}
