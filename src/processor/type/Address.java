package processor.type;

public class Address extends Type {

    public static final int CODE = 0;

    public static final int ADDRESS_SIZE = 12;

    private Integer[] values;
    private int cursor;

    public Address() {

        values = new Integer[ADDRESS_SIZE];

        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }

        cursor = 0;
    }


    public void setValues(int v) {

        if (cursor >= values.length) {
            return;
        }

        values[cursor] = v;

        cursor++;
    }

    public String getKey() {

        StringBuffer buffer = new StringBuffer();

        for (Integer value : values) {
            buffer.append(value);
        }

        return new String(buffer);
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Address) {

            Address address = (Address) object;


            if (values.length != address.values.length) {
                return false;
            }


            for (int i = 0; i < values.length; i++) {

                if (!values[i].equals(address.values[i])) {
                    return false;
                }
            }
        }

        return false;
    }

    @Override
    public Type add(Type type) {

        Type result = null;

        if (type.codeType() == Address.CODE) {

            result = new Address();

        } else if (type.codeType() == CODE) {

            result = new Address();
        }

        return result;
    }

    @Override
    public Type mod(Type type) {
        return null;
    }

    @Override
    public Type div(Type type) {
        return null;
    }

    @Override
    public Type sub(Type type) {
        return null;
    }

    @Override
    public boolean isSup(Type type) {
        return false;
    }

    @Override
    public boolean isInf(Type type) {
        return false;
    }

    @Override
    public boolean eql(Type type) {
        return false;
    }

    @Override
    public int codeType() {
        return CODE;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        for (Integer value : values) {
            buffer.append(value);
        }

        return new String(buffer);
    }
}
