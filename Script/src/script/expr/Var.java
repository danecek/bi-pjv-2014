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
public class Var extends Expr {
    
    private String name;
    private double value;

    public Var(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public Var(String name) {
        this.name = name;
    }
    
    @Override
    public double eval() {
        return value;
    }

    @Override
    public int prt() {
        return 3;
    }

    @Override
    public Expr optimize() {
        return this;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s[%f]", name, value);
    }
    
    
    
}
