package processor.operation;

public class InvalidCodeTypeException extends Exception {
    public InvalidCodeTypeException(int code) {
        super("Invalid code : " + code);
    }
}
