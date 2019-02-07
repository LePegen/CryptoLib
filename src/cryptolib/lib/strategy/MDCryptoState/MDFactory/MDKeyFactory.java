/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import cryptolib.lib.CryptoData;
import cryptolib.lib.CryptoKey;
import cryptolib.lib.CryptoKeyFactory;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoKey;
import static cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory.getDim;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author prg08p-a67-08
 */
public class MDKeyFactory extends CryptoKeyFactory {

    @Override
    public CryptoKey createKey(byte[] data) {
        MDCryptoKey cryptoKey = new MDCryptoKey();
        ArrayList tempList = new ArrayList();
        for (int i = 0; i < 256; i++) {
            if (i < data.length) {
                byte b = data[i];
                tempList.add((byte) b);
            } else {
                tempList.add((byte)0);
            }

        }
        cryptoKey.setKey(data(tempList));
        return cryptoKey;

    }

    public ArrayList data(ArrayList byteData) {
        ArrayList newData = new ArrayList();
        if (byteData.size() > 4) {
            int size = (int) Math.pow(4, getDim(byteData.size()));
            for (int i = 1; i < 5; i++) {
                ArrayList tempData = new ArrayList();
                ArrayList rawData = new ArrayList();
                for (int j = size / 4 * (i - 1); j < i * size / 4; j++) {
                    if (j < byteData.size()) {
                        rawData.add(byteData.get(j));
                    } else {
                        rawData.add((byte) 0);
                    }
                }
                tempData = data(rawData);
                newData.add(tempData);
            }
        } else {
            newData = byteData;
        }
        return newData;
    }

    @Override
    public CryptoKey generateKey() {
//        ArrayList curArray = new ArrayList();
//        Random rand = new Random();
//        for (int i = 0; i < 4; i++) {
//            ArrayList tempList3d = new ArrayList();
//            for (int j = 0; j < 4; j++) {
//                ArrayList tempList2d = new ArrayList();
//                for (int k = 0; k < 4; k++) {
//                    ArrayList tempList1d = new ArrayList();
//                    for (int l = 0; l < 4; l++) {
//                        SecureRandom random = new SecureRandom();
//                        tempList1d.add((byte) random.ne);
//                        //tempList1d.add(//random byte)
//                    }
//                    tempList2d.add(tempList1d);
//                }
//                tempList3d.add(tempList2d);
//            }
//            curArray.add(tempList3d);
//        }
        //4 is standard
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[256];
        random.nextBytes(bytes);
        System.out.println(bytes.length);
        return createKey(bytes);
    }
}
