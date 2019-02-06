/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState;

import cryptolib.lib.CryptoState;
import cryptolib.lib.strategy.MDCryptoState.MDProcesses.*;
import java.util.ArrayList;

/**
 *
 * @author prg08p-a67-08
 */
public class MDCryptoState extends CryptoState {

    public MDCryptoState() {
        MDAddRoundKey addRoundKey = new MDAddRoundKey();
        MDShiftByte shiftBytes = new MDShiftByte();
        //setter for add round key
        processes.add(addRoundKey);
        processes.add(shiftBytes);
    }

    @Override
    public String getName() {
        return "Multi Dimension";
    }
    
    public static boolean isByte(Object item){
        if(item instanceof Byte){
            return true;
        }
        return false;
    }

    public static int getDimensions(ArrayList array) {
        return getDimensions(array, 1);
    }

    public static int getDimensions(ArrayList array, int dim) {
        System.out.println(dim);
        if (isByte(array.get(0))) {
            return dim+1;
        }else{
            return getDimensions((ArrayList) array.get(0), dim + 1);
        }
    }

}
