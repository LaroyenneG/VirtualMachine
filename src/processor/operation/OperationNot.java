package processor.operation;

import processor.type.Address;
import processor.type.Boolean;
import processor.type.InvalidTypeOperationException;

public class OperationNot extends Operation {


    public OperationNot() {
        super(12);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {


        Address destAddress = readAddress();
        Address sourceAddress = readAddress();

        Boolean result = null;

        if (processor.getMemory().getValue(sourceAddress).eql(new Boolean(true))) {
            result = new Boolean(true);
        } else {
            result = new Boolean(false);
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
