package com.example.socialnet;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.IOException;
import java.math.BigInteger;


/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/21 15:42
 */
public class TestAll {
    public static Credentials credentials;

    //    测试方法，发送一条信息
    public static void main(String[] args) throws CipherException, IOException {
        String password = "8871527";

        // for (int i = 0; i < 10; i++) {
        //     String walletSource = "./wallet/account_" + Integer.toString(i + 1) + ".json";
            String walletSource = "./wallet/UTC--2022-09-13T14-26-44.323430699Z--02f90f849fecbe08eb25c66e512990220eda868b";
            credentials = WalletUtils.loadCredentials(password, walletSource);

            BigInteger privateKey = credentials.getEcKeyPair().getPrivateKey();

            System.out.println("privateKey = " + Hex.toHexString(privateKey.toByteArray()));
        // }


    }
}
