package processor.operation;

import processor.type.Address;
import processor.type.Number;

public class OperationSet extends Operation {

    public OperationSet() {
        super(7);
    }

    @Override
    public void execute() {

        Address address = readAddress();

        processor.getMemory().setValue(address, new Number(parameters.remove()));
    }
}
