/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossgenerator;

import java.util.SortedSet;
import java.util.TreeSet;
import scanner.StringValueToken;
import scanner.Token;

/**
 *
 * @author danecek
 */
public class Item {

    private StringValueToken token;
    private SortedSet<Integer> lines = new TreeSet<>();

    public Item(StringValueToken token) {
        this.token = token;
    }

    /**
     * @return the token
     */
    public StringValueToken getToken() {
        return token;
    }

    /**
     * @return the lines
     */
    public SortedSet<Integer> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return token.toString() + lines;
    }
    
    

}
