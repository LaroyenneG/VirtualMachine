package processor.type;

public abstract class Type {

    public abstract Type add(Type type) throws InvalidTypeOperationException;

    public abstract Type mod(Type type) throws InvalidTypeOperationException;

    public abstract Type div(Type type) throws InvalidTypeOperationException;

    public abstract Type sub(Type type) throws InvalidTypeOperationException;

    public abstract boolean isSup(Type type) throws InvalidTypeOperationException;

    public abstract boolean isInf(Type type) throws InvalidTypeOperationException;

    public abstract boolean eql(Type type) throws InvalidTypeOperationException;

    public abstract int codeType();
}
