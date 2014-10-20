package script;

import script.expr.BinOper;
import script.expr.Expr;
import script.expr.Literal;
import script.expr.Oper;
import script.expr.Var;

public class Script {

    public static void main(String[] args) {
        Literal l = new Literal(1.1);
        System.out.println(l.eval() == 1.1);
        BinOper e = new BinOper(Oper.MLT, new BinOper(Oper.PLUS, new Literal(2), new Literal(3)), new Var("x", 5));
        System.out.printf("%s = %f\n", e.toString(), e.eval());
        Expr oe = e.optimize();
        System.out.println(oe);
//        InputStream is = Expr.class.getResourceAsStream("/resource.txt");
        
    }

}
