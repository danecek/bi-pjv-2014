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
public class NumberToken extends Token {

    int value;

    public NumberToken(int value, Position pos) {
        super(TokenType.NUM, pos);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)%s", getTokenType(), value, getPos());
    }

}
