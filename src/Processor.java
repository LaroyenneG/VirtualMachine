import java.util.*;

public class Processor {

    public static final int ADDRESS_SIZE = 12;

    private int cursor;
    private List<Vector<Integer>> program;
    private Map<Integer, Instruction> instructions;
    private Memory memory;

    public Processor() {
        cursor = 0;
        program = new ArrayList<>();
        instructions = new HashMap<>();
        memory = new Memory();
    }

    public void moveCursor(int value) {
        cursor += value;
    }

    public void execute() {

        while (cursor < program.size()) {
            Vector<Integer> line = program.get(cursor);

            Instruction instruction = instructions.get(line.get(0));

            if (instruction == null) {
                System.err.println("invalid instruction");
                System.exit(-3);
            }

            for (int i = 1; i < line.size(); i++) {
                instruction.addParameters(line.get(i));
            }

            instruction.setProcessor(this);

            instruction.execute();

            cursor++;
        }

    }

    public Memory getMemory() {
        return memory;
    }

    public void setupNewInstruction(Instruction instruction) {
        instructions.put(instruction.getCode(), instruction);
    }

    public void addNewCommand(Vector<Integer> line) {

        program.add(line);
    }
}
