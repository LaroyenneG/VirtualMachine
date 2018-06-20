package processor.type;

public class Char extends Type {

    public static final int CODE = 4;

    private char c;

    public Char(char c) {
        this.c = c;
    }


    @Override
    public Type add(Type type) {
        return null;
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
        return String.valueOf(c);
    }
}
