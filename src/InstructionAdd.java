public class InstructionAdd extends Instruction {

    public InstructionAdd() {
        super(0);
    }

    @Override
    public void execute() {

        Integer[] destAddress = readAddress();
        Integer[] n1Address = readAddress();
        Integer[] n2Address = readAddress();

        Integer result = processor.getMemory().getValue(n1Address) + processor.getMemory().getValue(n2Address);

        processor.getMemory().setValue(destAddress, result);
    }
}
