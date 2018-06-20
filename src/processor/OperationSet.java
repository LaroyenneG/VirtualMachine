package processor;

public class OperationSet extends Operation {

    public OperationSet() {
        super(7);
    }

    @Override
    public void execute() {

        Address address = readAddress();

        processor.getMemory().setValue(address, parameters.remove());
    }
}
