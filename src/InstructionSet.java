public class InstructionSet extends Instruction {

    public InstructionSet() {
        super(7);
    }

    @Override
    public void execute() {


        Integer[] address = readAddress();

        processor.getMemory().setValue(address, parameters.remove());
    }
}
