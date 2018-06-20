package processor.operation;

import processor.type.Address;
import processor.type.InvalidTypeOperationException;
import processor.type.Type;

public class OperationMod extends Operation {

    public OperationMod() {
        super(3);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address destAddress = readAddress();
        Address n1Address = readAddress();
        Address n2Address = readAddress();

        Type result = processor.getMemory().getValue(n1Address).mod(processor.getMemory().getValue(n2Address));

        processor.getMemory().setValue(destAddress, result);
    }
}
