package script.expr;

public class BinOper extends Expr {

    private final Oper op;
    private Expr left;
    private Expr right;

    public BinOper(Oper op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the op
     */
    public Oper getOp() {
        return op;
    }

    /**
     * @return the lef
     */
    public Expr getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Expr getRight() {
        return right;
    }

    @Override
    public double eval() {
        double lv = left.eval();
        double rv = right.eval();
        switch (op) {
            case PLUS:
                return lv + rv;
            case MINUS:
                return lv - rv;
            case MLT:
                return lv * rv;
            case DIV:
                return lv / rv;
            default:
                throw new RuntimeException();

        }
    }

    static String wrap(String s) {
        return '(' + s + ')';
    }

    @Override
    public String toString() {
        String ls = left.toString();
        if (left.prt() < prt()) {
            ls = wrap(ls);
        }
        StringBuilder sb = new StringBuilder(ls);
        sb.append(op.toString());
        String rs = right.toString();
        if (right.prt() < prt()) {
            rs = wrap(ls);
        }
        return sb.append(rs).toString();
    }

    @Override
    public int prt() {
        return op.prt;
    }

    @Override
    public Expr optimize() {
        left = left.optimize();
        right = right.optimize();
        if (left instanceof Literal && right instanceof Literal) {
            return new Literal(eval());
        }
        return this;
    }

}
