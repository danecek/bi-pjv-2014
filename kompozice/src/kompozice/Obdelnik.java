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
public class Obdelnik extends Element {

    public Obdelnik(Bod refBod, int sirka, int vyska) {
        super(refBod);
        this.sirka = sirka;
        this.vyska = vyska;
    }

    private final int sirka;
    private final int vyska;

    public int getSirka() {
        return sirka;
    }

    public int getVyska() {
        return vyska;
    }

    @Override
    public double plocha() {
        return (double) sirka * vyska;
    }

    @Override
    public int pocetElementu() {
        return 1;
    }

    @Override
    public void navsteva(Navstevnik n) {
        n.navstiv(this);
    }

}
