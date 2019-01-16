package lib;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author prg08p-a67-08
 */
public abstract class CryptoState {
 protected ArrayList<CryptoProcess> processes;
 protected String key;   
 public CryptoState() {
        processes=new ArrayList<>();
        this.key=setKey();
    }

    public abstract String setKey();

	public void encrypt(CryptoKey key,CryptoData data) {
        for (int i = 0; i < processes.size(); i++) {
            processes.get(i).execute();
        }
	}

	public void decrypt(CryptoKey key,CryptoData data) {
        for (int i = processes.size()-1; i > -1; i--) {
            processes.get(i).execute();
        }
	}
    
}
