/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package script.expr;

/**
 *
 * @author danecek
 */
public abstract class Expr {

    public Expr() {
    }

    public abstract double eval();
    
    public abstract int prt();
    
    public  abstract Expr optimize();
    
}
