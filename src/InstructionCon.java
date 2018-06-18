public class InstructionCon extends Instruction {

    public InstructionCon() {
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
