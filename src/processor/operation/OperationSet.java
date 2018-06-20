package processor.operation;

import processor.exception.InvalidCodeTypeException;
import processor.type.Address;
import processor.type.Bool;
import processor.type.Number;
import processor.type.Type;

public class OperationSet extends Operation {

    public OperationSet() {
        super(7);
    }

    @Override
    public void execute() throws InvalidCodeTypeException {

        Address address = readAddress();

        int code = parameters.remove();

        Type type = null;

        switch (code) {

            case Address.CODE:
                type = readAddress();
                break;

            case Number.CODE:
                type = new Number(parameters.remove());
                break;

            case Bool.CODE:
                type = new Bool(Boolean.parseBoolean(String.valueOf(parameters.remove())));
                break;

            default:
                throw new InvalidCodeTypeException(code);
        }

        processor.getMemory().setValue(address, type);
    }
}
