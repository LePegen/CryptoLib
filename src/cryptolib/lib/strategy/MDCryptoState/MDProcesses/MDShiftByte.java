package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import java.util.ArrayList;

/**
 *
 * @author Gene Garcia
 */
public class MDShiftByte extends CryptoProcess {

    MDCryptoData data;

    public MDShiftByte() {
        this.data = (MDCryptoData) state.getData();
    }

    public MDShiftByte(MDCryptoData data) {
        this.data = data;
    }
    
    

    public void shift() {
        ArrayList gList = data.getData();
        ArrayList<Integer> coords = createCoord();
        ArrayList duplicateGList = new ArrayList(gList);

        while (isCoordLast(4, coords)) {
            byte byteVal = getVal(coords, gList);
            //add 1 and handle overflow to each coordinate to shift
            for (int i = 0; i < coords.size(); i++) {
                int value = (coords.get(i) + 1) % 4;
                coords.set(i, value);
            }
            setVal(coords, duplicateGList, byteVal);
            increment(4, coords);
        }

    }

    public ArrayList<Integer> createCoord() {
        ArrayList tempList = data.getData();
        ArrayList<Integer> initCoords = new ArrayList<>();

        while (tempList.get(0) != null) {
            initCoords.add(0);
            tempList = (ArrayList) tempList.get(0);
        }

        return initCoords;
    }

    public void increment(int size, ArrayList<Integer> coords) {
        //initalindex
        int index = 0;
        //get index in the coordinates arraylist of the value that is less than 4 
        while (coords.get(index) + 1 >= size) {
            index++;
        }
        coords.set(index, coords.get(index) + 1);

    }

    public boolean isCoordLast(int size, ArrayList<Integer> coords) {
        if (coords.get(coords.size()) + 1 >= size) {
            return true;
        }

        return false;
    }

    private ArrayList setVal(ArrayList<Integer> coords, ArrayList gList, byte value) {
        ArrayList tempList = null;

        for (int i = 0; i < coords.size() - 1; i++) {
            tempList = (ArrayList) gList.get(coords.get(i));
        }
        tempList.set(coords.get(coords.size()), value);

        return gList;
    }

    public byte getVal(ArrayList<Integer> coords, ArrayList gList) {
        ArrayList tempList = null;
        for (int i = 0; i < coords.size() - 1; i++) {
            tempList = (ArrayList) gList.get(coords.get(i));
        }
        return (byte) tempList.get(coords.get(coords.size()));
    }

    @Override
    protected void action() {
        shift();
    }

}
