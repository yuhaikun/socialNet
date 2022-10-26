package com.example.socialnet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socialnet.entities.SocialNode;
import com.example.socialnet.web3.Web3Application;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/17 10:09
 */
public class Web3j_Sign {
//    private Web3Application web3Application;
//
//    public void constuctor() throws Exception {
//        String passwd = "8871527";
////        String walletSource = "./wallet/account_1.json";
//        String walletSource = "./wallet/UTC--2022-10-14T15-45-49.132119416Z--2f131e1529990f2fd029ee449cfdab01685a8e5d";
//
//        this.web3Application =  new Web3Application(passwd,walletSource);
//    }

        // 钱包私钥
    private static final String priKey = "e62248374af86aa480f9cebd44f04cd02b915130d4fbda885a201488257b0a17";
    // 钱包地址
    private static final String walletAddress = "0x5ebacac108d665819398e5c37e12b0162d781398";


    public static void main(String[] args) throws UnsupportedEncodingException {

////        原文
//        String content = "7k7k";
////        原文摘要字节数组
//        byte[] contentHashBytes = Hash.sha3(content.getBytes());
//
//
//        System.out.println("contentHashBytes = " + contentHashBytes);
////        原文摘要16进制字符串
//        String contentHashHex = Hex.toHexString(contentHashBytes);
//
//
//        Credentials credentials = Credentials.create(priKey);
//
//        Sign.SignatureData signMessage1 = Sign.signPrefixedMessage(contentHashBytes,credentials.getEcKeyPair());
////        System.out.println(Hex.toHexString(signMessage.getR()));
////        System.out.println(Hex.toHexString(signMessage.getS()));
////        System.out.println(Hex.toHexString(signMessage.getV()));
//        byte[] messageHash = Sign.getEthereumMessageHash(Hex.decode(contentHashHex));
////        String encoded = Base64.getEncoder().encodeToString(messageHash);
////        System.out.println("messageHash = " + encoded);
//
//
//        Sign.SignatureData signMessage2 = Sign.signMessage(messageHash,credentials.getEcKeyPair(),false);
//
//        System.out.println(Hex.toHexString(signMessage1.getR()));
//        System.out.println(Hex.toHexString(signMessage1.getS()));
//        System.out.println(Hex.toHexString(signMessage1.getV()));
//        String signStr1 = "0x" + Hex.toHexString(signMessage1.getR()) + Hex.toHexString(signMessage1.getS()) + Hex.toHexString(signMessage1.getV());
//
//        System.out.println("signStr = " + signStr1);
//
//
//        System.out.println(Hex.toHexString(signMessage2.getR()));
//        System.out.println(Hex.toHexString(signMessage2.getS()));
//        System.out.println(Hex.toHexString(signMessage2.getV()));
//        String signStr2 = "0x" + Hex.toHexString(signMessage2.getR()) + Hex.toHexString(signMessage2.getS()) + Hex.toHexString(signMessage2.getV());
//
//        System.out.println("signStr = " + signStr2);

        String privateAccountKey = "503f38a9c967ed597e47fe25643985f032b072db8075426a92110f82df48dfcb";
        Credentials credentials = Credentials.create(privateAccountKey);
        String message="Hello111";
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        System.out.println("messageBytes = " + Numeric.toHexString(messageBytes));
        Sign.SignatureData signature = Sign.signPrefixedMessage(messageBytes, credentials.getEcKeyPair());
        byte[] value = new byte[65];
        System.arraycopy(signature.getR(), 0, value, 0, 32);
        System.arraycopy(signature.getS(), 0, value, 32, 32);
        System.arraycopy(signature.getV(), 0, value, 64, 1);
        System.out.println("hash: " + Numeric.toHexString(Sign.getEthereumMessageHash(messageBytes)));
        System.out.println("signature: " + Numeric.toHexString(value));
    }
//    public String readFile(String jsonFile, int index) throws Exception {
//
//
//        JSONObject x;
//        FileInputStream fileInputStream = new FileInputStream(jsonFile);
//
//        int len;
//        byte[] bytes = new byte[1024];
//        StringBuffer stringBuffer = new StringBuffer();
//        while ((len = fileInputStream.read(bytes)) != -1) {
//            //            添加字符串到缓冲区
//            stringBuffer.append(new String(bytes, 0, len));
//        }
////            关闭资源
//        fileInputStream.close();
//
//
////            使用fastjson将字符串转换成json
//        JSONArray jsonArray = JSONObject.parseArray(stringBuffer.toString());
//
////        System.out.println("大小为：" + jsonArray.size());
////            便于对象去除我们需要的数据
////        for (Object schema :
////                jsonArray) {
////            JSONObject x = (JSONObject) schema;
////            System.out.println("发送的信息是：" + x);
////        }
//        x = (JSONObject) jsonArray.get(index);
//        String text = x.getString("text");
//        String sign_message = this.web3Application.sign_Message(text);
//        x.put("sign_message", sign_message);
//        return x.toString();
//    }
//
//    public static void main(String[] args) throws Exception {
//        Web3j_Sign web3j_sign = new Web3j_Sign();
//        web3j_sign.constuctor();
//        String s = web3j_sign.readFile("E:\\projects\\dataHandle\\littleTest.json", 1);
//        System.out.println("s = " + s);
//    }
}
