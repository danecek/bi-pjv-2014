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
public class PocitadloElementu extends Navstevnik {

    private int pocet;

    @Override
    public void navstiv(Kontejner k) {
    }

    @Override
    public void navstiv(Obdelnik o) {
        pocet++;
    }

    /**
     * @return the pocet
     */
    public int getPocet() {
        return pocet;
    }

}
