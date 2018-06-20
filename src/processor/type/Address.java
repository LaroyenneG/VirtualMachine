package processor.type;

public class Address extends Type {

    public static final int CODE = 0;

    public static final int ADDRESS_SIZE = 12;

    public static final int USER_ADDRESS_SIZE = 2;
    public static final int PROGRAM_ADDRESS_SIZE = 1;

    public static final int BASE = Integer.MAX_VALUE;

    private int[] values;
    private int[] user;
    private int[] program;

    private int cursor;

    public Address() {

        values = new int[ADDRESS_SIZE];
        user = new int[USER_ADDRESS_SIZE];
        program = new int[PROGRAM_ADDRESS_SIZE];

        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }

        for (int i = 0; i < user.length; i++) {
            user[i] = 0;
        }

        for (int i = 0; i < program.length; i++) {
            program[i] = 0;
        }

        cursor = 0;
    }


    public Address(Address address) {

        values = new int[address.values.length];
        user = new int[address.user.length];
        program = new int[address.program.length];

        for (int i = 0; i < values.length; i++) {
            values[i] = address.values[i];
        }

        for (int i = 0; i < user.length; i++) {
            user[i] = address.user[i];
        }

        for (int i = 0; i < program.length; i++) {
            program[i] = address.program[i];
        }

        cursor = 0;
    }

    private void addValue(int c, int v) {

        if (c >= values.length) {
            return;
        }

        long r = values[c] + v - BASE;

        if (r >= 0) {
            values[c] = (int) r;
            addValue(c + 1, 1);
        } else {
            values[c] += v;
        }
    }

    private void subValue(int c, int v) {

        if (c >= values.length) {
            return;
        }

        if (values[c] - v < 0) {

            long r = values[c] * BASE;

            values[c] = (int) (r - v);
            subValue(c + 1, 1);
        } else {
            values[c] -= v;
        }
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

        for (int value : user) {
            buffer.append(value);
        }

        for (int value : program) {
            buffer.append(value);
        }

        for (int value : values) {
            buffer.append(value);
        }

        return new String(buffer);
    }


    @Override
    public Type add(Type type) {

        Type result = null;

        if (type.codeType() == CODE) {

            result = new Address();

        } else if (type.codeType() == Number.CODE) {

            result = new Address(this);

            ((Address) result).addValue(0, ((Number) type).getValue());
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
        Type result = null;

        if (type.codeType() == CODE) {

            result = new Address();

        } else if (type.codeType() == Number.CODE) {

            result = new Address(this);

            ((Address) result).subValue(0, ((Number) type).getValue());
        }

        return result;
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

        if (type.codeType() == CODE) {
            return false;
        }

        Address address = (Address) type;

        if (address.values.length != values.length) {
            return false;
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] != address.values[i]) {
                return false;
            }
        }

        for (int i = 0; i < program.length; i++) {
            if (program[i] != address.program[i]) {
                return false;
            }
        }

        for (int i = 0; i < user.length; i++) {
            if (user[i] != address.user[i]) {
                return false;
            }
        }

        return true;
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
