/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.strategy.MDCryptoState;

import lib.CryptoState;
import lib.strategy.MDCryptoState.MDProcesses.MDAddRoundKey;

/**
 *
 * @author prg08p-a67-08
 */
public class MDCryptoState extends CryptoState{
    public MDCryptoState() {
        MDAddRoundKey addRoundKey=new MDAddRoundKey();
        //setter for add round key
        processes.add(addRoundKey);
    }

    @Override
    public String getName() {
        return "Multi Dimension";
    }
}
