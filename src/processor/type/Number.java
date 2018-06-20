package processor.type;

public class Number extends Type {

    public static final int CODE = 1;

    private int n;

    public Number(int n) {
        this.n = n;
    }


    @Override
    public Type add(Type type) {

        Type result = null;

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            result = new Number(n + number.n);
        }


        return result;
    }

    @Override
    public Type mod(Type type) {

        Type result = null;

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            result = new Number(n % number.n);
        }

        return result;
    }

    @Override
    public Type div(Type type) {

        Type result = null;

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            result = new Number(n / number.n);
        }


        return result;
    }

    @Override
    public Type sub(Type type) {

        Type result = null;

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            result = new Number(n - number.n);
        }

        return result;
    }

    @Override
    public boolean isSup(Type type) {

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            return n > number.n;
        }

        return false;
    }

    @Override
    public boolean isInf(Type type) {

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            return n < number.n;
        }

        return false;
    }

    @Override
    public boolean eql(Type type) {

        if (type.codeType() == CODE) {

            Number number = (Number) type;

            return n == number.n;
        }

        return false;
    }

    @Override
    public int codeType() {
        return CODE;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}

