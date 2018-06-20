package processor.type;

public class Bool extends Type {

    public static final int CODE = 2;

    private boolean b;

    public Bool(boolean b) {
        this.b = b;
    }


    @Override
    public Type add(Type type) throws InvalidTypeOperationException {

        if (type.codeType() != CODE) {
            throw new InvalidTypeOperationException(CODE, type);
        }

        Bool bool = (Bool) type;

        return new Bool(b | bool.b);
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

        Bool bool = (Bool) type;

        return new Bool(b & bool.b);
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

        Bool bool = (Bool) type;

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
