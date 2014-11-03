/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

/**
 *
 * @author danecek
 */
public enum TokenType {

    ID,
    NUM,
    STRING,
    _for,
    _case,
    MLT,
    LT,
    LE,
    EQ,
    NE,
    LPAR("("),
    PLUS("+"),
    PLUS_EQUAL("+="),
    DIVIDE("/"),
    DIVIDE_EQUAL("/=")
    ;

    private TokenType() {
    }

    private TokenType(String str) {
        this.str = str;
    }

    String str;

    @Override
    public String toString() {
        if (str != null) {
            return str;
        }
        return super.toString();
    }

}
