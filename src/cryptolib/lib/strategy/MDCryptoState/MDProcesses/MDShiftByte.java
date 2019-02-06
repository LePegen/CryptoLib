package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.MDCryptoData;
import java.util.ArrayList;

/**
 *
 * @author Gene Garcia
 */
public class MDShiftByte extends CryptoProcess {

//    public MDShiftByte() {
//        this.data = (MDCryptoData) state.getData();
//    }
//
//    public MDShiftByte(MDCryptoData data) {
//        this.data = data;
//    }
    public ArrayList shift(ArrayList data) {
        ArrayList gList = data;
        ArrayList<Integer> coords = createCoord(data);
        ArrayList duplicateGList = new ArrayList(gList);

        while (!isCoordLast(4, coords)) {
            byte byteVal = getVal(coords, duplicateGList);
            ArrayList<Integer> tempCoords = new ArrayList<>(coords);
            //add 1 and handle overflow to each coordinate to shift
            for (int i = 0; i < coords.size(); i++) {
                int value = (coords.get(i) + 1) % 4;
                tempCoords.set(i, value);
            }
            gList=setVal(tempCoords, duplicateGList, byteVal);
            coords = increment(4, coords);
        }
        System.out.println("Count: "+count);
        return gList;
    }
int count=0;
    public ArrayList<Integer> createCoord(ArrayList data) {
        ArrayList tempList = data;
        ArrayList<Integer> initCoords = new ArrayList<>();
        initCoords.add(0);

        
        while (!(tempList.get(0) instanceof Byte)) {
            initCoords.add(0);
            tempList = (ArrayList) tempList.get(0);
        }
        return initCoords;
    }

    public ArrayList increment(int size, ArrayList<Integer> coords) {
        //initalindex
        ArrayList<Integer> list = new ArrayList(coords);
        int index = 0;
        //get index in the coordinates arraylist of the value that is less than 4 
        while (list.get(index)+1 >= size) {
            index++;
        }
       
        list.set(index, list.get(index) + 1);

        if (list.get(index)+1>=3) {
            for (int i = 0; i < index; i++) {
                list.set(i,0);
            }
        }
        
        
        System.out.println("XD: "+list.get(index));

        System.out.println("LIST");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");
        count++;

        return list;

    }

    public boolean isCoordLast(int size, ArrayList<Integer> coords) {
        if (coords.get(coords.size()-1) + 1 >= size) {
            return true;
        }
        return false;
    }

    private ArrayList setVal(ArrayList<Integer> coords, ArrayList gList, byte value) {
        ArrayList tempList = new ArrayList(gList);

        for (int i = 0; i < coords.size() - 1; i++) {
            tempList = (ArrayList) tempList.get(coords.get(i));
        }
        tempList.set(coords.get(coords.size()-1), value);

        return gList;
    }

    public byte getVal(ArrayList<Integer> coords, ArrayList gList) {
        ArrayList tempList = new ArrayList(gList);
        for (int i = 0; i < coords.size()-1; i++) {
            tempList = (ArrayList) tempList.get(coords.get(i));
        }
        byte val=(byte) tempList.get(coords.get(coords.size()-1));
        return val;
    }

    @Override
    protected void action() {
    }

}
