package processor;

public class OperationCon extends Operation {

    public OperationCon() {
        super(6);
    }

    @Override
    public void execute() {


        Integer[] address = readAddress();

        Integer nbLine = parameters.remove();

        if (processor.getMemory().getValue(address) == 1) {
            processor.moveCursor(nbLine - 1);
        }
    }
}
