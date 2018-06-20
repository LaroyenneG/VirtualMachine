package processor.type;

public class Boolean extends Type {

    public static final int CODE = 2;

    private boolean b;

    public Boolean(boolean b) {
        this.b = b;
    }


    @Override
    public Type add(Type type) throws InvalidTypeOperationException {

        if (type.codeType() != CODE) {
            throw new InvalidTypeOperationException(CODE, type);
        }

        Boolean bool = (Boolean) type;

        return new Boolean(b | bool.b);
    }

    @Override
    public Type mod(Type type) throws InvalidTypeOperationException {
        throw new InvalidTypeOperationException(CODE, type);
    }

    @Override
    public Type div(Type type) {
        return null;
    }

    @Override
    public Type sub(Type type) throws InvalidTypeOperationException {

        if (type.codeType() != CODE) {
            throw new InvalidTypeOperationException(CODE, type);
        }

        Boolean bool = (Boolean) type;

        return new Boolean(b & bool.b);
    }

    @Override
    public boolean isSup(Type type) throws InvalidTypeOperationException {

        throw new InvalidTypeOperationException(CODE, type);
    }

    @Override
    public boolean isInf(Type type) throws InvalidTypeOperationException {

        throw new InvalidTypeOperationException(CODE, type);
    }

    @Override
    public boolean eql(Type type) throws InvalidTypeOperationException {

        if (type.codeType() != CODE) {
            throw new InvalidTypeOperationException(CODE, type);
        }

        Boolean bool = (Boolean) type;

        return b == bool.b;
    }

    @Override
    public int codeType() {
        return CODE;
    }

    @Override
    public String toString() {
        return String.valueOf(b);
    }
}
