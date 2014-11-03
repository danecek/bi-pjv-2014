/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static scanner.TokenType.*;

/**
 *
 * @author danecek
 */
public class Scanner {

    char actChar = ' ';
    Reader reader;
    private Position actPos;
    int actRow;
    int actCol;

    public Scanner(Reader reader) {
        this.reader = reader;
    }

    Token nextToken() throws IOException, LexicalException {
        skip();
        actPos = new Position(actRow, actCol);
        if (Character.isLetter(actChar)) {
            return ident();
        }
        if (Character.isDigit(actChar)) {
            return num();
        }
        for (;;) {
            switch (actChar) {
                case '/': {
                    nextChar();
                    if (actChar == '*') {
                        skipComent();
                        break;
                    }
                    if (actChar == '=') {
                        nextChar();
                        return new Token(DIVIDE_EQUAL, actPos);
                    } else {
                        return new Token(DIVIDE, actPos);
                    }

                }
                case '(': {
                    nextChar();
                    return new Token(LPAR, actPos);
                }
                case '+': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return new Token(PLUS_EQUAL, actPos);
                    }
                    return new Token(PLUS, actPos);

                }
                case 0xffff:
                    return null;
                default:
                    throw new LexicalException("unknown character:" + actChar);
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, LexicalException {
        Reader sr = new FileReader("src/scanner/Position.java"); //.new StringReader("sss ( 4444 += + \n 22 333");

        Scanner sc = new Scanner(sr);
        for (Token t = sc.nextToken(); t != null; t = sc.nextToken()) {
            System.out.println(t);
        }
    }

    private void skip() throws IOException {
        while (Character.isWhitespace(actChar)) {
            nextChar();
        }
    }

    private Token ident() throws IOException {
        StringBuilder sb = new StringBuilder(actChar);
        while (Character.isLetter(actChar) || Character.isDigit(actChar)) {
            sb.append(actChar);
            nextChar();
        }
        return new StringToken(ID, sb.toString(), actPos);
    }

    private Token num() throws IOException {
        int value = 0;
        while (Character.isDigit(actChar)) {
            value *= 10;
            value += actChar - '0';
            nextChar();
        }
        return new NumberToken(value, actPos);
    }

    private void nextChar() throws IOException {
        int c = reader.read();
        actCol++;
        if (c == '\n') {
            actCol = 0;
            actRow++;
        }

        if (c != -1) {
            actChar = (char) c;
        } else {
            actChar = 0xffff;
        }
    }

    private void skipComent() throws IOException {
        nextChar();
        for (;;) {
            while (actChar != '*') {
                nextChar();
            }
            nextChar();
            if (actChar == '/') {
                nextChar();
                return;
            }
        }

    }

}
