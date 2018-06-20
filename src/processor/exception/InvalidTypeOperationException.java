package processor.exception;

import processor.type.Type;

public class InvalidTypeOperationException extends Exception {

    public InvalidTypeOperationException(int expected, Type actual) {
        super("Invalid type\nactual : " + actual.codeType() + " excepted : " + expected);
    }

    public InvalidTypeOperationException(String msg) {
        super(msg);
    }
}
