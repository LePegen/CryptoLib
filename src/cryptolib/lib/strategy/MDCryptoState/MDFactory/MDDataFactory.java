/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.strategy.MDCryptoState.MDFactory;

import lib.strategy.MDCryptoState.MDCryptoData;

/**
 *
 * @author prg08p-a67-08
 */
public class MDDataFactory {

    private int dim;
    public MDDataFactory(int dim) {
        this.dim=dim;
    }

    public MDCryptoData createData(byte[] data){
        MDCryptoData cryptoData=new MDCryptoData();

        return cryptoData;
    }
    
}
