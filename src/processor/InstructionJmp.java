package processor;

public class InstructionJmp extends Instruction {

    public InstructionJmp() {
        super(5);
    }

    @Override
    public void execute() {

        Integer nbLine = parameters.remove();

        processor.moveCursor(nbLine);
    }
}
