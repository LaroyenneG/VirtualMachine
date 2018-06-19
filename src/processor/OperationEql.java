package processor;

public class OperationEql extends Operation {

    public OperationEql() {
        super(8);
    }

    @Override
    public void execute() {

        Integer[] destAddress = readAddress();
        Integer[] n1Address = readAddress();
        Integer[] n2Address = readAddress();

        Integer result = 0;

        if (processor.getMemory().getValue(n1Address).equals(processor.getMemory().getValue(n2Address))) {
            result = 1;
        }

        processor.getMemory().setValue(destAddress, result);
    }
}