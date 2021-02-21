package course.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class ExceptionRunner {
    public static void main(String[] args) {
        String[][] myArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        ExceptionRunner exceptionRunner = new ExceptionRunner();


        try {
            log.info("Sum is: {}", exceptionRunner.computeArray(myArray));
        } catch (MyArraySizeException e) {
            log.error("Wrong size of array");
        } catch (MyArrayDataException exception) {
            log.error("Wrong dataType in array");
        }

    }


    int computeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        int sum = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z-_=+\\\\|[{\\\\]};:'\\\",<>/]");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!pattern.matcher(array[i][j]).find()){
                    sum += Integer.parseInt(array[i][j]);
                } else throw new MyArrayDataException(i,j,array[i][j]);
            }
        }

        return sum;
    }


}

