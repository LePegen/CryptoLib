/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import com.sun.imageio.plugins.jpeg.JPEG;
import cryptolib.lib.CryptoData;
import cryptolib.lib.CryptoDataFactory;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoState;
import cryptolib.lib.strategy.MDCryptoState.MDProcesses.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author prg08p-a67-08
 */
public class MDDataFactory extends CryptoDataFactory{


    @Override
    public CryptoData createData(byte[] data) {
        MDCryptoData cryptoData = new MDCryptoData();
        ArrayList tempList=new ArrayList();
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            tempList.add(b);
        }
        cryptoData.setData(data(tempList));
        return cryptoData;
    }

    public ArrayList data(ArrayList byteData) {
        ArrayList newData = new ArrayList();
        if (byteData.size() > 4) {
            int size = (int) Math.pow(4, getDim(byteData.size()));
            for (int i = 1; i < 5; i++) {
                ArrayList tempData=new ArrayList();
                ArrayList rawData = new ArrayList();
                for (int j = size / 4 * (i - 1); j < i * size / 4; j++) {
                    if(j<byteData.size()){
                        rawData.add(byteData.get(j));
                    }else{
                        rawData.add((byte) 0);
                    }
                }
                tempData=data(rawData);
                newData.add(tempData);
            }
        }else{
            newData=byteData;
        }
        return newData;
    }
    
//    public static void main(String[] args) {
//        MDDataFactory factory=new MDDataFactory();
//        MDDepadBlock depadBlock=new MDDepadBlock();
//        ArrayList rawData= new ArrayList();
//        Random rand=new Random();
//        for (int i = 0; i < 10; i++) {
//            rawData.add((byte)rand.nextInt());
//        }
//        rawData=factory.data(rawData);
//        MDAddPadding addPadding=new MDAddPadding();
//        System.out.println("");
//        rawData=addPadding.upDimension(rawData);
//        rawData=depadBlock.depad(rawData);
//        System.out.println(rawData);
//        System.out.println("");
//
//    }

    public static int getDim(int items) {
        return (int) (Math.ceil(1 / (Math.log(4) / Math.log(items))));
    }
}
