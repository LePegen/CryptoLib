/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState;

import java.util.ArrayList;

import cryptolib.lib.CryptoKey;

/**
 *
 * @author prg08p-a67-08
 */
public class MDCryptoKey extends CryptoKey {

    private ArrayList key;

    public MDCryptoKey() {
        key = new ArrayList();
    }

    public ArrayList getKey() {
        return key;
    }

    public void setKey(ArrayList key) {
        this.key = key;
    }
    
    


}
