package script.expr;

public class Literal extends Expr {

    private final double value;

    public Literal(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double eval() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public int prt() {
        return 3;
    }

    @Override
    public Expr optimize() {
        return this;
    }

}
