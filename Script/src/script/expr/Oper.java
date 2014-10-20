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
public enum Oper {

    PLUS("+", 0),
    MINUS("-", 0),
    MLT("*", 1),
    DIV("/", 1);

    private Oper(String txt, int prt) {
        this.txt = txt;
        this.prt = prt;
    }

    String txt;
    int prt;



    @Override
    public String toString() {
        return txt;
    }
    
    

}
