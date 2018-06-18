public class InstructionSet extends Instruction {

    public InstructionSet() {
        super(007);
    }

    @Override
    public void execute() {


        Integer[] addr = new Integer[12];

        for (int i = 0; i < addr.length; i++) {
            addr[i] = parameters.get(i);
        }

        processor.getMemory().setValue(addr, parameters.get(addr.length));
    }
}
