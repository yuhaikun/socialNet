package com.example.socialnet.utils;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/17 21:14
 */
public class WebApplicationUtils {


    /**
     * 返回签名后的字符串
     * @param message
     * @return
     * @throws Exception
     */
    public String sign_Message(String message, Credentials credentials) throws Exception {

//        原文摘要字节数组
        byte[] contentHashBytes = Hash.sha3(message.getBytes());
//        原文摘要16进制字符串
        String contentHashHex = Hex.toHexString(contentHashBytes);

        Sign.SignatureData signMessage = Sign.signPrefixedMessage(contentHashBytes, credentials.getEcKeyPair());

        System.out.println(Hex.toHexString(signMessage.getR()));
        System.out.println(Hex.toHexString(signMessage.getS()));
        System.out.println(Hex.toHexString(signMessage.getV()));

        String signStr = "0x" + Hex.toHexString(signMessage.getR()) + Hex.toHexString(signMessage.getS()) + Hex.toHexString(signMessage.getV());

//        try {
////        签名后的字符串
//            String signStr = "0x" + Hex.toHexString(signMessage.getR()) + Hex.toHexString(signMessage.getS()) + Hex.toHexString(signMessage.getV());
//            System.out.println("signStr = " + signStr);
////        原文摘要添加ETH签名头信息后再生成摘要
//            byte[] messageHash = Sign.getEthereumMessageHash(Hex.decode(contentHashHex));
////        通过摘要和签名后的数据，还原公钥
//            Sign.SignatureData signatureData = new Sign.SignatureData(signMessage.getV(), signMessage.getR(), signMessage.getS());
//            BigInteger publicKey = Sign.signedMessageHashToKey(messageHash, signatureData);
//
////        还原地址
//            String parseAddress = "0x" + Keys.getAddress(publicKey);
//            System.out.println("parseAddress = " + parseAddress);
//        } catch (SignatureException e) {
//            e.printStackTrace();
//        }
        return signStr;


    }
}
