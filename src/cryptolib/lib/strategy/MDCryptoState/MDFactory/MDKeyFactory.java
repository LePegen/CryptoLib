/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import cryptolib.lib.CryptoKey;
import java.util.ArrayList;

/**
 *
 * @author prg08p-a67-08
 */
public class MDKeyFactory extends CryptoKey {

    public ArrayList createData() {
        
        byte[] defaultKey = {0, 0, 0, 0}; //randomize key (byte)
        
        ArrayList curArray = new ArrayList();
        
        for (int i = 0; i < 4; i++) {
            ArrayList tempList3d=new ArrayList();
            for (int j = 0; j < 4; j++) {
                            ArrayList tempList2d=new ArrayList();
                for (int k = 0; k < i; k++) {
                                ArrayList tempList1d=new ArrayList();
                    for (int l = 0; l < 4; l++) {
                        
                        //tempList1d.add(//random byte)
                    }
                }
            }
        }
        //4 is standard
        return curArray;
    }
}
