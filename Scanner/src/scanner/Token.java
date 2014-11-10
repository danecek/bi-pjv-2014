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

    private TokenType tokenType;
    private Position pos;

    public Token(TokenType tokenType, Position pos) {
        this.tokenType = tokenType;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return tokenType.toString() + pos;
    }

    /**
     * @return the tokenType
     */
    public TokenType getTokenType() {
        return tokenType;
    }

    /**
     * @return the pos
     */
    public Position getPos() {
        return pos;
    }

}
