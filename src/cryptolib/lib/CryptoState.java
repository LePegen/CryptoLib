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

    protected ArrayList<CryptoProcess> processes;
    protected String name;
    protected CryptoData data;
    protected CryptoKey key;

    public CryptoState() {
        processes = new ArrayList<>();
        this.name = getName();
    }

    public abstract String getName();

    public void encrypt(CryptoKey key, CryptoData data) {
        this.key = key;
        this.data = data;
        for (int i = 0; i < processes.size(); i++) {
            processes.get(i).execute(this);
        }
    }

    public void decrypt(CryptoKey key, CryptoData data) {
        this.key = key;
        this.data = data;
        for (int i = processes.size() - 1; i > -1; i--) {
            processes.get(i).execute(this);
        }
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
