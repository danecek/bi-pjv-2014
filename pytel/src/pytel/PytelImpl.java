/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pytel;

import java.util.Arrays;

/**
 *
 * @author danecek
 */
public class PytelImpl implements InterfacePytel {

    private Object[] data;
    private int pocet = 0;
    int iterator;

    public PytelImpl() {
        this(1000);
    }

    public PytelImpl(int velikost) {
        if (velikost < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[velikost];
    }

    @Override
    public void vloz(Object o) {
        if (iterator > 0) {
            throw new RuntimeException("paraleni modifikace");
        }
        if (plny()) {
            Object[] d = new Object[2 * data.length];
            System.arraycopy(data, 0, d, 0, pocet);
            data = d;
        }
        data[pocet++] = o;
    }

    private int nalezt(Object o) {
        for (int i = 0; i < pocet; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void vyjmi(Object o) {
        int i = nalezt(o);
        if (i == -1) {
            return;
        }
        data[i] = data[--pocet];
        data[pocet] = null;
    }

    @Override
    public boolean obsahuje(Object o) {
        return nalezt(o) != -1;
    }

    @Override
    public int pocet() {
        return pocet;
    }

    @Override
    public void vysypat() {
        while (pocet > 0) {
            data[--pocet] = null;
        }
    }

    @Override
    public Object[] naPole() {
        return Arrays.copyOfRange(data, 0, pocet);
    }

    @Override
    public void vloz(InterfacePytel druhy) {
        if (pocet + druhy.pocet() > data.length) {
            throw new IllegalArgumentException("mala kapacita");
        }
        System.arraycopy(druhy.naPole(), 0, data, pocet, druhy.pocet());
    }

    @Override
    public void startIterace() {
        iterator = 0;
    }

    @Override
    public Object dalsi() {
        if (iterator >= pocet) {
            throw new RuntimeException();
        }
        return data[iterator++];
    }

    @Override
    public boolean jeDalsi() {
        if (iterator < pocet) {
            return true;
        } else {
            iterator = 0;
            return false;
        }
    }

    @Override
    public boolean plny() {
        return pocet == data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(naPole());
    }

}
