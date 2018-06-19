package processor;

public class OperationOr extends Operation {

    public OperationOr() {
        super(14);
    }

    @Override
    public void execute() {

        Integer[] destAddress = readAddress();
        Integer[] n1Address = readAddress();
        Integer[] n2Address = readAddress();

        Integer result = 0;

        if (processor.getMemory().getValue(n1Address).equals(1) || processor.getMemory().getValue(n2Address).equals(1)) {
            result = 1;
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
