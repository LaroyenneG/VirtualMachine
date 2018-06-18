import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<Integer[], Integer> values;


    public Memory() {

        values = new HashMap<>();
    }


    public void setValue(Integer[] key, Integer value) {

        if (key.length != 12) {
            System.err.println("invalid addr");
            System.exit(-1);
        }

        values.put(key, value);
    }

    public Integer getValue(Integer[] key) {


        Integer value = values.get(key);

        if (key.length != 12 || value == null) {
            System.err.println("invalid addr");
            System.exit(-1);
        }

        return value;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
