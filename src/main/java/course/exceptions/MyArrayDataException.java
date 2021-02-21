package course.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * wrong datatype in array
 */
@Slf4j
public class MyArrayDataException extends MyException {
    public MyArrayDataException(int row, int column, String value) {
        log.info("Wrong value in row={}, column={}, value={}", row, column, value);
    }
}
