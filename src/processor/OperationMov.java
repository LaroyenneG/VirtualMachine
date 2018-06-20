package processor;

public class OperationMov extends Operation {

    public OperationMov() {
        super(10);
    }

    @Override
    public void execute() {

        Address destAddress = readAddress();
        Address sourceAddress = readAddress();

        processor.getMemory().setValue(destAddress, processor.getMemory().getValue(sourceAddress));
    }
}
