package processor.operation;

import processor.Processor;
import processor.type.Address;
import processor.type.InvalidTypeOperationException;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class Operation {

    Processor processor;
    Queue<Integer> parameters;
    private int code;

    public Operation(int code) {
        this.code = code;
        processor = null;
        parameters = new ArrayDeque<>();
    }

    public int getCode() {
        return code;
    }

    public void addParameters(int p) {
        parameters.add(p);
    }

    Address readAddress() {

        Address address = new Address();

        for (int i = 0; i < Address.ADDRESS_SIZE; i++) {
            address.setValues(parameters.remove());
        }

        return address;
    }

    public abstract void execute() throws InvalidTypeOperationException, InvalidCodeTypeException;

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
