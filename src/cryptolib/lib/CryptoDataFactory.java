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
public abstract class CryptoDataFactory {
    public abstract CryptoData createData(byte[] data);
}
