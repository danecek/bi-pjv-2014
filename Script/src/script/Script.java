package script;

import java.io.Reader;
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
        Expr e2 = Script.parse("1+2");
        System.out.printf("%s = %f\n", e.toString(), e.eval());
        Expr oe = e.optimize();
        System.out.println(oe);
//        InputStream is = Expr.class.getResourceAsStream("/resource.txt");
        
    }

    private static Expr parse(Reader in) {
        
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
