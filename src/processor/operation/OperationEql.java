package processor.operation;

import processor.type.Address;
import processor.type.Bool;
import processor.type.InvalidTypeOperationException;
import processor.type.Type;

public class OperationEql extends Operation {

    public OperationEql() {
        super(8);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {

        Address destAddress = readAddress();
        Address n1Address = readAddress();
        Address n2Address = readAddress();

        Type result = null;

        if (processor.getMemory().getValue(n1Address).eql(processor.getMemory().getValue(n2Address))) {
            result = new Bool(true);
        } else {
            result = new Bool(false);
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
