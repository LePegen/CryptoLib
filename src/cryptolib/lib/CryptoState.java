package cryptolib.lib;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author prg08p-a67-08
 */
public abstract class CryptoState {

    protected ArrayList<CryptoProcess> encryptProcessses;
    protected ArrayList<CryptoProcess> decryptProcessses;
    protected String name;
    protected CryptoData data;
    protected CryptoKey key;

    public CryptoState() {
        encryptProcessses = new ArrayList<>();
        decryptProcessses = new ArrayList<>();
        this.name = getName();
        this.dataFactory=setDataFactory();
        this.keyFactory=setKeyFactory();
    }
    
    public abstract CryptoDataFactory setDataFactory();
    public abstract CryptoKeyFactory setKeyFactory();
    public abstract byte[] convertData(CryptoData data);
    
    public abstract String getName();
    CryptoDataFactory dataFactory;
    CryptoKeyFactory keyFactory;

    public byte[] encrypt(byte[] data, CryptoKey key) {
        this.key = key;
        this.data = dataFactory.createData(data);
        for (int i = 0; i < encryptProcessses.size(); i++) {
            encryptProcessses.get(i).execute(this);
        }
        return convertData(this.data);
    }

    public byte[] decrypt(byte[] data, CryptoKey key) {
        this.key = key;
        this.data = dataFactory.createData(data);
        for (int i = 0; i < decryptProcessses.size(); i++) {
            decryptProcessses.get(i).execute(this);
        }
        return convertData(this.data);
    }

    public CryptoData getData() {
        return data;
    }

    public void setData(CryptoData data) {
        this.data = data;
    }

    public CryptoKey getKey() {
        return key;
    }

    public void setKey(CryptoKey key) {
        this.key = key;
    }
}
