/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pytel;

/**
 *
 * @author danecek
 */
public class Pytel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PytelImpl p = new PytelImpl();
        System.out.println(p);
        p.vloz("xxx");
        System.out.println(p);
        p.vloz("xxx");
        System.out.println(p);
        p.vyjmi(new String("xxx"));
        System.out.println(p);
        p.vysypat();
        System.out.println(p);
        p.vloz("1");
        p.vloz("2");
        p.vloz("3");
        p.vyjmi("1");
        System.out.println(p);
        for (p.startIterace(); p.jeDalsi();) {
            System.out.println(p.dalsi());
        }
        PytelImpl p2 = new PytelImpl(1);
        p2.vloz("1");
        p2.vloz("1");
        p2.vloz("1");
        p2.vloz("1");
        System.out.println(p2);
        // TODO code application logic here
    }

}
