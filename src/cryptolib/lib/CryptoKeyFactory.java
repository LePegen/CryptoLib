/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolib.lib;

/**
 *
 * @author lipat
 */
public abstract class CryptoKeyFactory {
    public abstract CryptoKey createKey(byte[] data);
    public abstract CryptoKey generateKey();

}
