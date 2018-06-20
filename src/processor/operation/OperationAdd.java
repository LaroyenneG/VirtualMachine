package processor.operation;

import processor.exception.InvalidTypeOperationException;
import processor.type.Address;
import processor.type.Type;

public class OperationAdd extends Operation {

    public OperationAdd() {
        super(0);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address destAddress = readAddress();
        Address n1Address = readAddress();
        Address n2Address = readAddress();

        Type result = processor.getMemory().getValue(n1Address).add(processor.getMemory().getValue(n2Address));

        processor.getMemory().setValue(destAddress, result);
    }
}
