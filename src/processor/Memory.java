package processor;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<String, Integer> values;

    private Address tmpKey;
    private Integer tmpValue;

    public Memory() {
        values = new HashMap<>();
        tmpKey = null;
        tmpValue = null;
    }


    public void setValue(Address key, Integer value) {

        tmpKey = key;
        tmpValue = value;

        values.put(tmpKey.getKey(), value);
    }

    public Integer getValue(Address key) {

        Integer value = null;

        if (tmpKey.equals(key)) {
            value = tmpValue;
        } else {
            value = values.get(key.getKey());
        }

        return value;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
