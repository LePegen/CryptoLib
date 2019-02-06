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
public class MDAddRoundKey extends CryptoProcess {

    /**
     * TODO: unit testing
     */
    //refer to super class
    private MDCryptoKey key;
    private MDCryptoData data;

    public MDAddRoundKey() {
        //anti pattern i think
    }

    @Override
    protected void action() {
        ArrayList keyAL = key.getData();
        ArrayList dataAL = data.getData();
        this.data.setData(crypt(keyAL, dataAL));
    }

    public static void main(String[] args) {
        MDDataFactory dataFactory = new MDDataFactory();
        MDKeyFactory keyFactory = new MDKeyFactory();
        MDAddRoundKey addRoundKey = new MDAddRoundKey();
        MDShiftByte shiftByte=new MDShiftByte();
        MDAddPadding padd=new MDAddPadding();
        ArrayList data = new ArrayList();

        for (int i = 0; i < 256; i++) {
            Random rand = new Random();
            data.add((byte) rand.nextInt(200));
        }        
            
        ArrayList dataList = dataFactory.data(data);
        ArrayList keyList=keyFactory.createData();
        
        
        System.out.println(dataList);
        data=shiftByte.shift(dataList);
        System.out.println(data);
        data=padd.upDimension(data);
        System.out.println(data);
        ArrayList list = addRoundKey.crypt(keyList, dataList);
        System.out.println("");
    }

    /**
     * XOR
     */
    private ArrayList crypt(ArrayList key, ArrayList data) {
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
                newData.add(crypt((ArrayList) key.get(i), (ArrayList) data.get(i)));
            }
        }
        return newData;
    }

}
