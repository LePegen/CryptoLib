
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory;
import java.util.ArrayList;

/**
 *
 * @author Gene Garcia
 */
public class MDDepadBlock extends CryptoProcess {

    @Override
    protected void action() {
            MDCryptoData newData = new MDCryptoData();
        MDCryptoData stateData = (MDCryptoData) state.getData();
        newData.setData(depad(stateData.getData()));
    }

    public ArrayList depad(ArrayList list) {
        MDDataFactory dataFactory = new MDDataFactory();
        ArrayList values = getValues(list);
        return dataFactory.data(values);
    }

    public ArrayList getValues(ArrayList data) {
        return getValues(data, new ArrayList());
    }

    public ArrayList getValues(ArrayList data, ArrayList values) {
        ArrayList newData = new ArrayList();
        if (data.get(0) instanceof Byte) {
            if(!isAllZero(data)){
                for (int i = 0; i < data.size(); i++) {
                    values.add(data.get(i));
                }
            }
         
        } else {
            for (int i = 0; i < data.size(); i++) {
                getValues((ArrayList) data.get(i), values);
            }
        }
        return values;
    }

    public boolean isAllZero(ArrayList data) {
        for (int i = 0; i < data.size(); i++) {
           if((byte)data.get(i)!=0){
               return false;
           }
        }
        return true;
    }
}
