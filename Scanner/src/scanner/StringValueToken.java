package scanner;

public class StringValueToken extends Token {

    String value;

    public StringValueToken(TokenType tokenType, String value, Position pos) {
        super(tokenType, pos);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)%s", tokenType, value, pos);
    }

}
