package processor;

import processor.type.Address;
import processor.type.Type;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<String, Type> values;

    private Address tmpKey;
    private Type tmpValue;

    public Memory() {
        values = new HashMap<>();
        tmpKey = null;
        tmpValue = null;
    }


    public void setValue(Address key, Type value) {

        tmpKey = key;
        tmpValue = value;

        values.put(tmpKey.getKey(), value);
    }

    public Type getValue(Address key) {

        Type value = null;

        if (tmpKey.equals(key)) {
            value = tmpValue;
        } else {
            value = values.get(key.getKey());
        }

        return value;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("Memory : \n");

        for (Map.Entry<String, Type> entry :
                values.entrySet()) {

            builder.append('[');
            builder.append(entry.getKey());
            builder.append('|');
            builder.append(entry.getValue());
            builder.append(']');
            builder.append('\n');
        }


        return new String(builder);
    }
}
