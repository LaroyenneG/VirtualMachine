package processor.operation;

import processor.type.Address;
import processor.type.Boolean;
import processor.type.InvalidTypeOperationException;

public class OperationCon extends Operation {

    public OperationCon() {
        super(6);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address address = readAddress();

        Integer nbLine = parameters.remove();

        if (processor.getMemory().getValue(address).eql(new Boolean(true))) {
            processor.moveCursor(nbLine - 1);
        }
    }
}
