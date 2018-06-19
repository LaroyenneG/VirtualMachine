import processor.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class App {


    public static Vector<Integer> convertor(String string) {


        Vector<Integer> addr = new Vector<>();

        for (int i = 0; i < string.length(); i++) {
            addr.add(Integer.parseInt(String.valueOf(string.charAt(i))));
        }

        return addr;
    }

    public static void main(String[] args) throws IOException {

        final String headAddr = "0123456789";


        Dictionnary dictionnary = new Dictionnary();

        Processor processor = new Processor();

        processor.setupNewInstruction(new InstructionSet());
        processor.setupNewInstruction(new InstructionAdd());
        processor.setupNewInstruction(new InstructionSub());
        processor.setupNewInstruction(new InstructionJmp());
        processor.setupNewInstruction(new InstructionCon());
        processor.setupNewInstruction(new InstructionEql());
        processor.setupNewInstruction(new InstructionInf());
        processor.setupNewInstruction(new InstructionMod());


        BufferedReader reader = new BufferedReader(new FileReader("prog.txt"));


        String line = null;
        while ((line = reader.readLine()) != null) {
            processor.addNewCommand(dictionnary.formatLine(dictionnary.translateLine(line)));
        }

        long debut = System.currentTimeMillis();

        processor.execute();

        System.out.println("Time : " + (System.currentTimeMillis() - debut));


        System.out.println(processor.getMemory());
    }
}
