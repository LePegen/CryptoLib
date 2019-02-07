package cryptolib.lib;



import cryptolib.lib.strategy.MDCryptoState.*;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDKeyFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author prg08p-a67-08
 */
public class CryptoTools {

    private HashMap<String, CryptoState> states;
    private CryptoState currentState = null;

    public CryptoTools() {
        states = new HashMap<>();
        MDCryptoState mdState=new MDCryptoState();
        /**
         * States:
         * MDDecyption
         */
        
        states.put(mdState.getName(), mdState);
    }

    public void setEncryptState(String stateKey) {
        this.currentState = states.get(stateKey);
    }

    public byte[] encrypt(byte[] data, CryptoKey key) {
        return currentState.encrypt(data,key);
        
    }

    public byte[] decrypt(byte[] data, CryptoKey key) {
        return currentState.decrypt(data,key);
    }
    
   
    public static void main(String[] args) {
        CryptoTools tools = new CryptoTools();
        tools.setEncryptState("MDDecyption");
        String plainText = "The red fox jumped over the lazy dog";
        MDKeyFactory keyFactory=new MDKeyFactory();
        CryptoKey key=keyFactory.generateKey();
        byte[] data=tools.encrypt(plainText.getBytes(), key);
        Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        byte[] keyData=MDCryptoState.getData(((MDCryptoKey)key).getKey());
        System.out.println("");

        System.out.println(encoder.encodeToString(keyData));
        System.out.println("\n");
        System.out.println(encoder.encodeToString(data));
        System.out.println(new String(tools.decrypt(data, key)));

    }

}
