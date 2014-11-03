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
public class LexicalException extends Exception {

    /**
     * Creates a new instance of <code>LexicalException</code> without detail
     * message.
     */
    public LexicalException() {
    }

    /**
     * Constructs an instance of <code>LexicalException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LexicalException(String msg) {
        super(msg);
    }
}
