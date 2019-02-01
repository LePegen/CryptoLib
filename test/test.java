/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gene Garcia
 */
public class test {

    public static void main(String[] args) {
        byte[] stringbyte = ("Hello world").getBytes();
        byte[] key = ("World Hello").getBytes();
        byte[] cipherT = XOR(stringbyte, key);
        System.out.println("CipherText: " + new String(cipherT));
        System.out.println("decript: " + new String(XOR(cipherT, key)));
    }

    public static byte[] XOR(byte[] b1, byte[] b2) {
        int[] int1 = new int[b1.length];
        int[] int2 = new int[b2.length];
        for (int i = 0; i < b1.length; i++) {
            int1[i] = b1[i];
            int2[i] = b2[i];
        }
        byte[] xored = new byte[b1.length];
        for (int i = 0; i < int1.length; i++) {
            xored[i] = (byte) (int1[i] ^ int2[i]);
        }

        return xored;

    }
}
