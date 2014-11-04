package scanner;

public class LexicalException extends Exception {

    public LexicalException(String msg, Position pos) {
        super(msg + pos);
    }
}
