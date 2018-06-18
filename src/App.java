import java.util.Vector;

public class App {

    public static void main(String[] args) {

        Processor processor = new Processor();

        processor.setupNewInstruction(new InstructionSet());


        Vector<Integer> line = new Vector<>();
        line.add(007);

        for (int i = 0; i < 12; i++) {
            line.add(i);
        }

        line.add(1589);

        processor.addNewCommand(line);

        processor.execute();

        System.out.println(processor.getMemory());
    }
}
