/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import cryptolib.lib.CryptoKey;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author prg08p-a67-08
 */
public class MDKeyFactory extends CryptoKey {

    public ArrayList createData() {
        ArrayList curArray = new ArrayList();
        Random rand=new   Random();
        for (int i = 0; i < 4; i++) {
            ArrayList tempList3d=new ArrayList();
            for (int j = 0; j < 4; j++) {
                            ArrayList tempList2d=new ArrayList();
                for (int k = 0; k < 4; k++) {
                                ArrayList tempList1d=new ArrayList();
                    for (int l = 0; l < 4; l++) {
                        tempList1d.add((byte)rand.nextInt(256));
                        //tempList1d.add(//random byte)
                    }
                   tempList2d.add(tempList1d);
                }
                tempList3d.add(tempList2d);
            }
           curArray.add(tempList3d);
        }
        //4 is standard
        return curArray;
    }
}
