
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory;
import java.util.ArrayList;

/**
 *
 * @author Gene Garcia
 */
public class MDDepadBlock extends CryptoProcess {

    @Override
    protected void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList newData=new ArrayList();
        if (data.get(0) instanceof Byte) {
            for (int i = 0; i < data.size(); i++) {
                if ((Byte) data.get(i) != (byte) 0) {
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
}
