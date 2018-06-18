import java.util.ArrayDeque;
import java.util.Queue;

public abstract class Instruction {

    Processor processor;
    Queue<Integer> parameters;
    private int code;

    public Instruction(int code) {
        this.code = code;
        processor = null;
        parameters = new ArrayDeque<>();
    }

    public int getCode() {
        return code;
    }

    public void addParameters(int p) {
        parameters.add(p);
    }

    public Integer[] readAddress() {

        Integer[] address = new Integer[Processor.ADDRESS_SIZE];

        for (int i = 0; i < address.length; i++) {
            address[i] = parameters.remove();
        }

        return address;
    }

    public abstract void execute();

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
