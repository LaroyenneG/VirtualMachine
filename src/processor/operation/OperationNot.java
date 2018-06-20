package processor.operation;

import processor.type.Address;
import processor.type.Bool;
import processor.type.InvalidTypeOperationException;

public class OperationNot extends Operation {


    public OperationNot() {
        super(12);
    }

    @Override
    public void execute() throws InvalidTypeOperationException {


        Address destAddress = readAddress();
        Address sourceAddress = readAddress();

        Bool result = null;

        if (processor.getMemory().getValue(sourceAddress).eql(new Bool(true))) {
            result = new Bool(true);
        } else {
            result = new Bool(false);
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
