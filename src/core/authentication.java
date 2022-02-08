package core;

import util.Util;

import java.security.Security;

public class authentication {
    public static Wallet walletA;
    public static Wallet walletB;


    public static void main(String[] arg) {
        //Setup Bouncey castle as a Security Provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        //Create the new wallets
        walletA = new Wallet();
        walletB = new Wallet();

        walletA.generateKeyPair();
        walletB.generateKeyPair();

        //Test public and private keys
        System.out.println("Private and Public keys");
        System.out.println("Private: " + Util.getStringFromKey(walletA.privateKey));
        System.out.println("Public: " + Util.getStringFromKey(walletA.publicKey));


    }
}
