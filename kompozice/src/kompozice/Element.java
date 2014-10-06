/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozice;

public abstract class Element {

    private final Bod refBod;

    public Element(Bod refBod) {
        this.refBod = refBod;
    }

    public Bod getRefBod() {
        return refBod;
    }

    public abstract double plocha();

    public abstract int pocetElementu();

    public abstract void navsteva(Navstevnik n);

}
