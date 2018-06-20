package processor.operation;

public class OperationJmp extends Operation {

    public OperationJmp() {
        super(5);
    }

    @Override
    public void execute() {

        Integer nbLine = parameters.remove();

        processor.moveCursor(nbLine);
    }
}
