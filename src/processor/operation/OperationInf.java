package processor.operation;

import processor.type.Address;
import processor.type.Boolean;
import processor.type.InvalidTypeOperationException;
import processor.type.Type;

public class OperationInf extends Operation {

    public OperationInf() {
        super(9);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address destAddress = readAddress();
        Address n1Address = readAddress();
        Address n2Address = readAddress();

        Type result = null;

        if (processor.getMemory().getValue(n1Address).isInf(processor.getMemory().getValue(n2Address))) {
            result = new Boolean(true);
        } else {
            result = new Boolean(false);
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
