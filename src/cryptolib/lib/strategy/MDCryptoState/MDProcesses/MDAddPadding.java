/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoState;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Gene Garcia
 */
public class MDAddPadding extends CryptoProcess {

    public ArrayList addPadding(ArrayList tempList) {
        ArrayList newList = MDShiftByte.cloneList(tempList);
        System.out.println("Input Dimensions"+MDCryptoState.getDimensions(tempList));
        for (int i = 0; i < 4-MDCryptoState.getDimensions(tempList); i++) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(newList);
            arrayList.add(mapZeroList(newList));
            arrayList.add(mapZeroList(newList));
            arrayList.add(mapZeroList(newList));
            newList=arrayList;
        }
        System.out.println("New list Dimensions"+MDCryptoState.getDimensions(newList));

        return newList;
    }

    @Override
    protected void action() {
        MDCryptoData newData=new MDCryptoData();
        MDCryptoData stateData=(MDCryptoData) state.getData();
        newData.setData(addPadding(stateData.getData()));
    }

    private ArrayList mapZeroList(ArrayList list) {
        ArrayList tempList=new ArrayList();
        if (list.get(0) instanceof Byte) {
            for (int i = 0; i < list.size(); i++) {
                tempList.add((byte)0);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                tempList.add(mapZeroList((ArrayList) list.get(i)));
            }
        }
        return tempList;

    }

}
