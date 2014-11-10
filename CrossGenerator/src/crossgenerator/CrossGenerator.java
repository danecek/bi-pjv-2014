/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossgenerator;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.SortedMap;
import java.util.TreeMap;
import scanner.LexicalException;
import scanner.MyScanner;
import scanner.StringValueToken;
import scanner.Token;
import scanner.TokenType;

/**
 *
 * @author danecek
 */
public class CrossGenerator {

    private static void printItem(Item item, PrintWriter pw) {
        pw.printf("%s %s\n", item.getToken().getValue(), item.getLines());
    }

    private static void printGen(SortedMap<String, Item> items, Writer out) {
        try (PrintWriter pw = new PrintWriter(out)) {
            for (Item i : items.values()) {
                printItem(i, pw);
            }
        }
    }

    public static void generator(Reader in, Writer out) throws IOException, LexicalException {
        MyScanner ms = new MyScanner(in);
        SortedMap<String, Item> items = new TreeMap<>();
        for (Token t = ms.nextToken(); t != null; t = ms.nextToken()) {
            if (t.getTokenType() != TokenType.ID) {
                continue;
            }
            StringValueToken st = (StringValueToken) t;
            Item i = items.get(st.getValue());
            if (i == null) {
                i = new Item(st);
                items.put(st.getValue(), i);
            }
            i.getLines().add(t.getPos().getRow());
        }
        printGen(items, out);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, LexicalException {
        generator(new FileReader("src/crossgenerator/CrossGenerator.java"), new PrintWriter(System.out));
    }

}
