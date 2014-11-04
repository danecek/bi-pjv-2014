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
public class CharToken extends Token {

    char c;

    public CharToken(char c, Position pos) {
        super(TokenType.CHAR, pos);
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("%S(%c)", super.toString(), c);
    }

}
