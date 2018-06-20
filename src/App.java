import processor.Dictionnary;
import processor.Processor;
import processor.operation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {

        Dictionnary dictionnary = new Dictionnary();

        Processor processor = new Processor();

        processor.setupNewInstruction(new OperationSet());
        processor.setupNewInstruction(new OperationAdd());
        processor.setupNewInstruction(new OperationSub());
        processor.setupNewInstruction(new OperationJmp());
        processor.setupNewInstruction(new OperationCon());
        processor.setupNewInstruction(new OperationEql());
        processor.setupNewInstruction(new OperationInf());
        processor.setupNewInstruction(new OperationMod());
        processor.setupNewInstruction(new OperationMov());
        processor.setupNewInstruction(new OperationSup());
        processor.setupNewInstruction(new OperationNot());


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
