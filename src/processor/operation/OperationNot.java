package processor.operation;

import processor.exception.InvalidTypeOperationException;
import processor.type.Address;
import processor.type.Bool;

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
