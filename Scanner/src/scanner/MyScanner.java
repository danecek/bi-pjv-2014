package scanner;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static scanner.TokenType.*;

public class MyScanner {

    private char actChar = ' ';
    private Reader reader;
    private Position actPos;
    private int actRow = 1;
    private int actCol;

    public MyScanner(Reader reader) {
        this.reader = reader;
    }

    private Token createToken(TokenType tokenType) {
        return new Token(tokenType, actPos);
    }

    public Token nextToken() throws IOException, LexicalException {
        for (;;) {
            actPos = new Position(actRow, actCol);
            if (Character.isLetter(actChar)) {
                return ident();
            }
            if (Character.isDigit(actChar)) {
                return num();
            }
            switch (actChar) {
                case '\t':
                case ' ':
                case '\n':
                case '\r': {
                    nextChar();
                    break;
                }
                case '+': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(PLUS_EQUAL);
                    } else {
                        return createToken(PLUS);
                    }
                }
                case '-': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(MINUS_EQUAL);
                    } else {
                        return createToken(MINUS);
                    }
                }
                case '*': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(MLT_EQUAL);
                    } else {
                        return createToken(MLT);
                    }
                }
                case '/': {
                    nextChar();
                    if (actChar == '*') {
                        skipComent();
                        break;
                    }
                    if (actChar == '=') {
                        nextChar();
                        return new Token(DIV_EQUAL, actPos);
                    } else {
                        return new Token(DIV, actPos);
                    }
                }
                case '%': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(MOD_EQUAL);
                    } else {
                        return createToken(MOD);
                    }
                }
                case '<': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(LE);
                    } else {
                        return createToken(LT);
                    }
                }
                case '>': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(GE);
                    } else {
                        return createToken(GT);
                    }
                }
                case '&': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(AND_EQUAL);
                    } else {
                        return createToken(AND);
                    }
                }
                case '|': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(OR_EQUAL);
                    } else {
                        return createToken(OR);
                    }
                }
                case '^': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(XOR_EQUAL);
                    } else {
                        return createToken(XOR);
                    }
                }
                case '=': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(EQ);
                    } else {
                        return createToken(ASSIGN);
                    }
                }
                case '!': {
                    nextChar();
                    if (actChar == '=') {
                        nextChar();
                        return createToken(NE);
                    } else {
                        return createToken(EXCL);
                    }
                }
                case ';': {
                    nextChar();
                    return createToken(SEMICOLON);
                }
                case ':': {
                    nextChar();
                    return createToken(COLON);
                }
                case '\'': {
                    CharToken t;
                    nextChar();
                    if (actChar != '\\') {
                        t = new CharToken(actChar, actPos);
                    } else {
                        char escChar;
                        nextChar();
                        switch (actChar) {
                            case '\\':
                                escChar = '\\';
                                break;
                            case '\'':
                                escChar = '\'';
                                break;
                            case 'n':
                                escChar = '\n';
                                break;
                            case 'r':
                                escChar = '\r';
                                break;
                            case 't':
                                escChar = '\t';
                                break;
                            default:
                                throw new LexicalException("invalid escape", actPos);
                        }
                        t = new CharToken(escChar, actPos);
                    }
                    nextChar();
                    if (actChar != '\'') {
                        throw new LexicalException("invalid character literal:" + actChar, actPos);
                    }
                    nextChar();
                    return t;
                }
                case '"': {
                    return string();
                }
                case '@': {
                    nextChar();
                    return createToken(ATSIGN);
                }
                case ',': {
                    nextChar();
                    return createToken(COMMA);
                }
                case '.': {
                    nextChar();
                    return createToken(DOT);
                }
                case '{': {
                    nextChar();
                    return createToken(LBRACE);
                }
                case '}': {
                    nextChar();
                    return createToken(RBRACE);
                }
                case '(': {
                    nextChar();
                    return createToken(LPAR);
                }
                case ')': {
                    nextChar();
                    return createToken(RPAR);
                }
                case '[': {
                    nextChar();
                    return createToken(LBRACKET);
                }
                case ']': {
                    nextChar();
                    return createToken(RBRACKET);
                }
                case 0xffff:
                    return null;
                default:
                    throw new LexicalException(String.format("unknown character: %c (%d)", actChar, (int) actChar), actPos);
            }
        }
    }

    private Token ident() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(actChar) || Character.isDigit(actChar) || actChar == '_') {
            sb.append(actChar);
            nextChar();
        }
        String ident = sb.toString();
        TokenType tt = TokenType.KeyWords.get(ident);
        if (tt != null) {
            return createToken(tt);
        }
        return new StringValueToken(ID, ident, actPos);
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
        actChar = (char) reader.read();
        actCol++;
        if (actChar == 10) {
            actCol = 0;
            actRow++;
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

    private Token string() throws IOException {
        nextChar();
        StringBuilder sb = new StringBuilder();
        while (actChar != '"') {
            sb.append(actChar);
            nextChar();
        }
        nextChar();
        return new StringValueToken(STRING, sb.toString(), actPos);
    }

    public static void main(String[] args) throws IOException, LexicalException {
        Reader sr = new FileReader("src/scanner/MyScanner.java");

        MyScanner sc = new MyScanner(sr);
        for (Token t = sc.nextToken(); t != null; t = sc.nextToken()) {
            System.out.println(t);
        }
    }

}
