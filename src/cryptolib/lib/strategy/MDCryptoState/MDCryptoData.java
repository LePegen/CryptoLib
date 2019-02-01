/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState;

import java.util.ArrayList;

import cryptolib.lib.CryptoData;

/**
 *
 * @author prg08p-a67-08
 */
public class MDCryptoData extends CryptoData {

    private ArrayList data;

    public MDCryptoData() {
        data = new ArrayList();
    }

    public ArrayList getData() {
        return this.data;
    }

    public void setData(ArrayList recDecrypt) {
        this.data = recDecrypt;
    }

}
