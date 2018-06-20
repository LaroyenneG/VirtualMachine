package processor.operation;

import processor.exception.InvalidTypeOperationException;
import processor.type.Address;
import processor.type.Bool;

public class OperationCon extends Operation {

    public OperationCon() {
        super(6);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address address = readAddress();

        Integer nbLine = parameters.remove();

        if (processor.getMemory().getValue(address).eql(new Bool(true))) {
            processor.moveCursor(nbLine - 1);
        }
    }
}
