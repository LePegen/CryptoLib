/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import java.util.ArrayList;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.*;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDKeyFactory;
import java.util.Random;

/**
 *
 * @author prg08p-a67-08
 */
public class MDXORBytes extends CryptoProcess {

    /**
     * TODO: unit testing
     */
    //refer to super class
    private MDCryptoKey key;
    private MDCryptoData data;

    public MDXORBytes() {
        //anti pattern i think
    }

    @Override
    protected void action() {
        ArrayList keyAL = ((MDCryptoKey)state.getKey()).getKey();
        ArrayList dataAL = ((MDCryptoData)state.getData()).getData();
        ((MDCryptoData) state.getData()).setData(addRoundKey(keyAL, dataAL));
    }



    /**
     * XOR
     */
    public ArrayList addRoundKey(ArrayList key, ArrayList data) {
        ArrayList newData = new ArrayList();
        if (data.get(0) instanceof Byte) {
            for (int i = 0; i < key.size(); i++) {
                int keyVal= (byte) key.get(i);
                int dataVal=(byte) data.get(i);
                int value = (keyVal^dataVal);
                newData.add((byte) value);
            }
        } else {
            for (int i = 0; i < key.size(); i++) {
                newData.add(addRoundKey((ArrayList) key.get(i), (ArrayList) data.get(i)));
            }
        }
        return newData;
    }

}
