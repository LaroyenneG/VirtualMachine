package processor;

public class OperationNot extends Operation {


    public OperationNot() {
        super(12);
    }

    @Override
    public void execute() {


        Integer[] destAddress = readAddress();
        Integer[] sourceAddress = readAddress();


        Integer result = 1;

        if (processor.getMemory().getValue(sourceAddress).equals(1)) {
            result = 0;
        }

        processor.getMemory().setValue(destAddress, result);
    }
}
