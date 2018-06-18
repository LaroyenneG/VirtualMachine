import java.util.*;

public class Processor {

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

    public void execute() {

        do {
            Vector<Integer> line = program.get(cursor);

            Instruction instruction = instructions.get(line.get(0));

            for (int i = 1; i < line.size(); i++) {
                instruction.addParameters(line.get(i));
            }

            instruction.setProcessor(this);

            instruction.execute();

            cursor++;
        } while (cursor < program.size());

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
