package cryptolib.lib;



import cryptolib.lib.strategy.MDCryptoState.MDCryptoState;

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
public abstract class CryptoTools {

    private HashMap<String, CryptoState> states;
    private CryptoState currentState = null;

    public CryptoTools() {
        states = new HashMap<>();
        states.put("MD", new MDCryptoState());
    }

    public void setEncryptState(String stateKey) {
        this.currentState = states.get(stateKey);
    }

    public void encrypt(CryptoKey key, CryptoData data) {
        //currentState.encrypt(key, data);
        
    }

    public void decrypt(CryptoKey key, CryptoData data) {
        currentState.decrypt(key, data);
    }

}
