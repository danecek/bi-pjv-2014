/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozice;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author danecek
 */
public class Kontejner extends Element {

    private static Bod evalRef(Element[] elementy) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Element e : elementy) {
            minX = Math.min(minX, e.getRefBod().getX());
            minY = Math.min(minY, e.getRefBod().getY());
        }
        return new Bod(minX, minY);
    }

    Kontejner(Element... elementy) {
        super(evalRef(elementy));
        this.elementy = Arrays.asList(elementy);
    }

    List<Element> elementy;

    @Override
    public double plocha() {
        double plocha = 0;
        for (Element element : elementy) {
            plocha += element.plocha();
        }
        return plocha;
    }

    @Override
    public int pocetElementu() {
        int pocet = 0;
        for (Element element : elementy) {
            pocet += element.pocetElementu();
        }
        return pocet;
    }

    @Override
    public void navsteva(Navstevnik n) {
        n.navstiv(this);
        for (Element element : elementy) {
            element.navsteva(n);
        }
    }

}
