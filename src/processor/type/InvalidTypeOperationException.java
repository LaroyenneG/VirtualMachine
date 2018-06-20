package processor.type;

public class InvalidTypeOperationException extends Exception {

    public InvalidTypeOperationException(int expected, Type actual) {
        super("Invalid type\nactual : " + actual.codeType() + " excepted : " + expected);
    }

}
