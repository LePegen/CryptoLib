/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState;

import cryptolib.lib.CryptoData;
import cryptolib.lib.CryptoDataFactory;
import cryptolib.lib.CryptoKeyFactory;
import cryptolib.lib.CryptoState;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDKeyFactory;
import cryptolib.lib.strategy.MDCryptoState.MDProcesses.*;
import java.util.ArrayList;

/**
 *
 * @author prg08p-a67-08
 */
public class MDCryptoState extends CryptoState {

    public MDCryptoState() {
        MDXORBytes addRoundKey = new MDXORBytes();
        MDShiftByte shiftBytes = new MDShiftByte();
        MDAddPadding addPadding=new MDAddPadding();
        MDDepadBlock depadBlock=new MDDepadBlock();
        //setter for add round key
        encryptProcessses.add(shiftBytes);
        encryptProcessses.add(shiftBytes);
        encryptProcessses.add(addPadding);
        encryptProcessses.add(addRoundKey);
        
        decryptProcessses.add(addRoundKey);
        decryptProcessses.add(depadBlock);
        encryptProcessses.add(shiftBytes);
        encryptProcessses.add(shiftBytes);
    }

    @Override
    public String getName() {
        return "MDDecyption";
    }
    
    
    //tools
    
    public static boolean isByte(Object item){
        if(item instanceof Byte){
            return true;
        }
        return false;
    }
    
    public static byte[] getData(ArrayList data,ArrayList<Byte> newData){
        
        if(data.get(0) instanceof Byte){
            for (int i = 0; i < data.size(); i++) {
                newData.add((Byte) data.get(i));
            }
        }else{
            for (int i = 0; i < data.size(); i++) {
                getData((ArrayList) data.get(i), newData);
            }
        }
        
        byte[] byteArray=new byte[newData.size()];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i]=newData.get(i);
        }
        return byteArray;
    }
    
    public static byte[] getData(ArrayList data){
    return getData(data,new ArrayList<>());
            
    }
    

    public static int getDimensions(ArrayList array) {
        return getDimensions(array, 0);
    }

    public static int getDimensions(ArrayList array, int dim) {
        System.out.println(dim);
        if (isByte(array.get(0))) {
            return dim + 1;
        } else {
            return getDimensions((ArrayList) array.get(0), dim + 1);
        }
    }

    @Override
    public CryptoDataFactory setDataFactory() {
        return new MDDataFactory();
    }

    @Override
    public CryptoKeyFactory setKeyFactory() {
        return new MDKeyFactory();

    }

    @Override
    public byte[] convertData(CryptoData data) {
        MDCryptoData newData=(MDCryptoData) data;
        return getData(newData.getData());
    }

}
