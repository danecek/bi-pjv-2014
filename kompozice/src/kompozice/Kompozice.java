/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozice;

/**
 *
 * @author danecek
 */
public class Kompozice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kontejner k = new Kontejner(new Obdelnik(new Bod(1, 2), 2, 4), new Obdelnik(new Bod(2, 1), 1, 1));
        System.out.println(k.getRefBod());
        System.out.println(k.plocha());
        System.out.println(k.pocetElementu());
        
        PocitadloElementu pe = new PocitadloElementu();
        k.navsteva(pe);
        System.out.println(pe.getPocet());
        
        ScitacPloch sp = new ScitacPloch();
        k.navsteva(sp);
        System.out.println(sp.plocha);
        
    }
    
}
