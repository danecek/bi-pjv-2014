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
public interface InterfacePytel {
    void vloz(Object o);
    void vyjmi(Object o);
    boolean obsahuje(Object o);
    int pocet();
    void vysypat();
    Object[] naPole();
    void vloz(InterfacePytel druhy);    
    boolean plny();
    
    void startIterace();
    Object dalsi();
    boolean jeDalsi();    
        
}
