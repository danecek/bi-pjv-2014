/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author danecek
 */
public enum TokenType {

    ID,
    NUM,
    CHAR,
    STRING,
    //
    EXCL("!"),
    TILDA("~"),
    //
    PLUS("+"),
    MINUS("-"),
    MLT("*"),
    DIV("/"),
    MOD("%"),
    SL("<<"),
    SR(">>"),
    AND("&"),
    OR("|"),
    XOR("^"),
    LAND("&&"),
    LOR("||"),
    //
    ASSIGN("="),
    PLUS_EQUAL("+="),
    MINUS_EQUAL("-="),
    MLT_EQUAL("*="),
    DIV_EQUAL("/="),
    MOD_EQUAL("%="),
    SL_EQUAL("<<="),
    SR_EQUAL(">>="),
    AND_EQUAL("&="),
    OR_EQUAL("|="),
    XOR_EQUAL("^="),
    //
    LT("<"),
    LE("<="),
    GT(">"),
    GE(">="),
    EQ("=="),
    NE("!="),
    //
    SEMICOLON(";"),
    COLON(":"), 
    COMMA(","),
    ATSIGN("@"),
    DOT("."),
    LBRACE("{"),
    RBRACE("}"),
    LBRACKET("["),
    RBRACKET("]"),
    LPAR("("),
    RPAR(")"),
    //
    _abstract, _continue, _for, _new, _switch, _assert, _default, _goto, _package,
    _synchronized, _boolean, _do, _if, _private, _this, _break, _double,
    _implements, _protected, _throw, _byte, _else, _import, _public, _throws,
    _case, _enum, _instanceof, _return, _transient, _catch, _extends, _int,
    _short, _try, _char, _final, _interface, _static, _void, _class, _finally,
    _long, _strictfp, _volatile, _const, _float, _native, _super, _while // ...
    ;

    private TokenType(String text) {
        this.text = text;
    }

    private TokenType() {
    }

    private String text;

    public static Map<String, TokenType> KeyWords = new HashMap<>();

    static {
        for (int i = _abstract.ordinal(); i <= _while.ordinal(); i++) {
            TokenType tt = values()[i];
            KeyWords.put(tt.name().substring(1), tt);
        }
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

}
