/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDFactory;

import com.sun.imageio.plugins.jpeg.JPEG;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

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
        //
        return cryptoData;
    }

    public void popluateBlock(byte[] data) {

        Stack items = new Stack();
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            items.add(b);
        }
        while (!items.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                ArrayList tempItems = new ArrayList();
                tempItems.add(items.pop());
            }
        }
        for (int i = 0; i < getDim(data.length); i++) {
            ArrayList cer = new ArrayList();
            while (cer.size() > 4) {

            }
        }

    }

    public void setData(ArrayList data) {
        ArrayList newData = new ArrayList();

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
            System.out.println("Fin");
            newData=byteData;
        }
        return newData;
    }
    
    public static void main(String[] args) {
        MDDataFactory factory=new MDDataFactory(0);
        ArrayList rawData= new ArrayList();
        Random rand=new Random();
        for (int i = 0; i < 20; i++) {
            rawData.add((byte)rand.nextInt());
        }
        rawData=factory.data(rawData);
            System.out.println(rawData);
    }

    public int getDim(int items) {
        return dim = (int) (Math.ceil(1 / (Math.log(4) / Math.log(items))));
    }
}
