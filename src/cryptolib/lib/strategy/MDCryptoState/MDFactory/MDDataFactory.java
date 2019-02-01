/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import java.util.ArrayList;

/**
 *
 * @author prg08p-a67-08
 */
public class MDDataFactory {

    private int dim;

    public MDDataFactory(int dim) {
        this.dim = dim;
    }

    public MDCryptoData createData(byte[] data) {
        MDCryptoData cryptoData = new MDCryptoData();
        ArrayList curArray = createData();
        return cryptoData;
    }

    public void popluateBlock(byte[] data) {
        
    }

    public ArrayList createData() {
        ArrayList curArray = new ArrayList();
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < 4; j++) {
                curArray.add(new ArrayList());
            }
        }
        //4 is standard
        return curArray;
    }

}
