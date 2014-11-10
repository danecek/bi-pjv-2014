package scanner;

public class StringValueToken extends Token {

    private String value;

    public StringValueToken(TokenType tokenType, String value, Position pos) {
        super(tokenType, pos);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)%s", getTokenType(), value, getPos());
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

}
