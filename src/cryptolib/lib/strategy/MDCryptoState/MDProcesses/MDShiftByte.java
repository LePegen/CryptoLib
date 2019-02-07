package cryptolib.lib.strategy.MDCryptoState.MDProcesses;

import cryptolib.lib.CryptoProcess;
import cryptolib.lib.strategy.MDCryptoState.*;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDDataFactory;
import cryptolib.lib.strategy.MDCryptoState.MDFactory.MDKeyFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    public static void main(String[] args) {
        MDDataFactory dataFactory = new MDDataFactory();
        MDKeyFactory keyFactory = new MDKeyFactory();
        MDXORBytes addRoundKey = new MDXORBytes();
        MDShiftByte shiftByte = new MDShiftByte();
        MDAddPadding padd = new MDAddPadding();
        MDDepadBlock depadBlock = new MDDepadBlock();
        ArrayList data = new ArrayList();

        for (int i = 0; i < 15; i++) {
            Random rand = new Random();
            data.add((byte) rand.nextInt(256));
        }

        ArrayList dataList = dataFactory.data(data);
        ArrayList keyList = keyFactory.createData();

        System.out.println("input:" + dataList);
        //System.out.println("deshift: "+Arrays.toString(MDCryptoState.getData(dataList)));

        dataList = shiftByte.shift(dataList);
        dataList = shiftByte.shift(dataList);

        System.out.println(dataList);
        // System.out.println(Arrays.toString(MDCryptoState.getData(dataList)));

        dataList = padd.addPadding(dataList);
       
        dataList = addRoundKey.addRoundKey(keyList, dataList);

        //decyption
        //dataList = addRoundKey.addRoundKey(keyList, dataList);
        //System.out.println(Arrays.toString(MDCryptoState.getData(dataList)));
        //System.out.println(dataList);
        dataList = depadBlock.depad(dataList);
        //System.out.println(Arrays.toString(MDCryptoState.getData(dataList)));
        //System.out.println(dataList);
        
        dataList = shiftByte.shift(dataList);
        dataList = shiftByte.shift(dataList);

        System.out.println(Arrays.toString(MDCryptoState.getData(dataList)));
        //System.out.println(dataList);

        //depad or pad is wrong
    }

    public ArrayList shift(ArrayList data) {
        //get values
        final ArrayList gList = cloneList(data);
        //set values
        ArrayList duplicateGList = cloneList(data);
        ArrayList<Integer> coords = createCoord(data);

        while (!isCoordLast(coords)) {
            coords = increment(coords);

            ArrayList<Integer> tempCoords = new ArrayList<>(coords);
            byte byteVal = getVal(coords, gList);

            //get target coordinate
            for (int i = 0; i < coords.size(); i++) {
                int value = (coords.get(i) + 1) % 4;
                tempCoords.set(i, value);
            }
            //set byteval to target coordinate
            // System.out.println("before byteVal " + byteVal);
            duplicateGList = setVal(tempCoords, duplicateGList, byteVal);

        }
        System.out.println("Count: " + count);
        return duplicateGList;
    }
    int count = 0;

    public ArrayList<Integer> createCoord(ArrayList data) {
        ArrayList tempList = data;
        ArrayList<Integer> initCoords = new ArrayList<>();
        initCoords.add(-1);

        while (!(tempList.get(0) instanceof Byte)) {
            initCoords.add(0);
            tempList = (ArrayList) tempList.get(0);
        }
        return initCoords;
    }

    public ArrayList increment(ArrayList<Integer> coords) {
        ArrayList<Integer> newCoords = new ArrayList(coords);

        int index = 0;
        if (newCoords.get(index) >= 3) {
            while (newCoords.get(index) >= 3) {
                index++;
            }
            for (int i = 0; i < index; i++) {
                newCoords.set(i, 0);
            }
            newCoords.set(index, coords.get(index) + 1);
        } else {
            newCoords.set(index, coords.get(index) + 1);
        }

//        System.out.println("LIST");
//        for (int i = 0; i < newCoords.size(); i++) {
//            System.out.println(newCoords.get(i));
//        }
//        System.out.println("");
        count++;
        return newCoords;

    }

    public boolean isCoordLast(ArrayList<Integer> coords) {
        for (Integer coord : coords) {
            if (coord != 3) {
                return false;
            }
        }
        return true;
    }

    private ArrayList setVal(ArrayList<Integer> coords, ArrayList gList, byte value) {
        ArrayList retList = cloneList(gList);
        ArrayList tempList = retList;
        for (int i = 0; i < coords.size() - 1; i++) {
            tempList = (ArrayList) tempList.get(coords.get(i));
        }
        tempList.set(coords.get(coords.size() - 1), value);
        //System.out.println("templist.get " + tempList.get(coords.get(coords.size() - 1)) + "\nbyte " + value);

        return retList;
    }

    public byte getVal(ArrayList<Integer> coords, ArrayList gList) {
        ArrayList retList = cloneList(gList);
        ArrayList tempList = retList;
        for (int i = 0; i < coords.size() - 1; i++) {
            tempList = (ArrayList) tempList.get(coords.get(i));
        }
        byte val = (byte) tempList.get(coords.get(coords.size() - 1));
        return val;
    }

    @Override
    protected void action() {
    }

    public static ArrayList cloneList(ArrayList list) {
        ArrayList clonedList = new ArrayList();
        if (list.get(0) instanceof Byte) {
            for (int i = 0; i < list.size(); i++) {
                clonedList.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                clonedList.add(cloneList((ArrayList) list.get(i)));
            }
        }
        return clonedList;
    }

}
