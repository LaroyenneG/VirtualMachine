package processor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<String, Integer> values;

    private String tmpKey;
    private Integer tmpValue;

    public Memory() {
        values = new HashMap<>();
        tmpKey = null;
        tmpValue = null;
    }


    public void setValue(Integer[] key, Integer value) {

        if (key.length != 12) {
            System.err.println("invalid addr : " + Arrays.toString(key));
            System.exit(-1);
        }

        tmpKey = Arrays.toString(key);
        tmpValue = value;

        values.put(tmpKey, value);
    }

    public Integer getValue(Integer[] key) {


        String string = Arrays.toString(key);


        Integer value = null;
        if (tmpKey.equals(string)) {
            value = tmpValue;
        } else {
            value = values.get(string);
        }

        if (key.length != 12 || value == null) {
            System.err.println("invalid addr : " + Arrays.toString(key));
            System.exit(-1);
        }

        return value;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
