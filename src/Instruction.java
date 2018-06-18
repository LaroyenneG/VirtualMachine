import java.util.Vector;

public abstract class Instruction {

    Processor processor;
    Vector<Integer> parameters;
    private int code;

    public Instruction(int code) {
        this.code = code;
        processor = null;
        parameters = new Vector<>();
    }

    public int getCode() {
        return code;
    }

    public void addParameters(int p) {
        parameters.add(p);
    }

    public abstract void execute();

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
