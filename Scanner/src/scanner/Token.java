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
public class Token {

    TokenType tokenType;
    Position pos;

    public Token(TokenType tokenType, Position pos) {
        this.tokenType = tokenType;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return tokenType.toString() + pos;
    }

}
