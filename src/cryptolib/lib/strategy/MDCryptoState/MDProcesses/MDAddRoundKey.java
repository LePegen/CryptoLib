/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.strategy.MDCryptoState.MDProcesses;

import java.util.ArrayList;

import lib.CryptoProcess;
import lib.strategy.MDCryptoState.MDCryptoData;
import lib.strategy.MDCryptoState.MDCryptoKey;


/**
 *
 * @author prg08p-a67-08
 */
public class MDAddRoundKey extends CryptoProcess{

    /**
     * TODO: unit testing
     */

     //refer to super class
    private MDCryptoKey key;
    private MDCryptoData data;

    public MDAddRoundKey() {
        //anti pattern i think
        this.data= (MDCryptoData) state.getData();
        this.key = (MDCryptoKey) state.getKey();
    }

    @Override
    protected void action() {
        ArrayList keyAL=key.getData();
        ArrayList dataAL=data.getData();
        this.data.setData(crypt(keyAL, dataAL));
    }

    /**
     * XOR
     */
    private ArrayList crypt(ArrayList key, ArrayList data){
        ArrayList newData=new ArrayList<>();
        if(data.get(0) instanceof Integer){
            for (int i = 0; i < key.size(); i++) {
                newData.set(i, (int) key.get(i) ^ (int) data.get(i));
            }
        }else{
            for (int i = 0; i < key.size(); i++) {
                newData= crypt((ArrayList)key.get(i),(ArrayList)data.get(i));
            }
        }
        return newData;
    }



}
