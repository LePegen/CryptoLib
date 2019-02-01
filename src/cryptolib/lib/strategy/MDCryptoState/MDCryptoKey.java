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

    private ArrayList ket;

    public MDCryptoKey() {
        ket = new ArrayList();
    }

    public ArrayList getData() {
        return this.ket;
    }

}
