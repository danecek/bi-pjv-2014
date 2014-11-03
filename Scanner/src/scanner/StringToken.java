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
public class StringToken extends Token {

    String value;

    public StringToken(TokenType tokenType, String value, Position pos) {
        super(tokenType, pos);
        this.value = value;
    }


    @Override
    public String toString() {
        return super.toString() + "(" + value + ')';
    }

}
