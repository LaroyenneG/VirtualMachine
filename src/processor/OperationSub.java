package processor;

public class OperationSub extends Operation {

    public OperationSub() {
        super(1);
    }

    @Override
    public void execute() {

        Integer[] destAddress = readAddress();
        Integer[] n1Address = readAddress();
        Integer[] n2Address = readAddress();

        Integer result = processor.getMemory().getValue(n1Address) - processor.getMemory().getValue(n2Address);

        processor.getMemory().setValue(destAddress, result);
    }
}