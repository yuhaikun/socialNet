package com.example.socialnet;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.example.socialnet.constants.Constants.PUBLICKEYPATH;

/**
 * Java RSA 加密工具类
 * 参考： https://blog.csdn.net/qy20115549/article/details/83105736
 */
public class RSAUtil {
    public static final String NEW_LINE_CHARACTER = "\n";
    public static final String PUBLIC_KEY_START_KEY_STRING = "-----BEGIN PUBLIC KEY-----";
    public static final String PUBLIC_KEY_END_KEY_STRING = "-----END PUBLIC KEY-----";
    public static final String EMPTY_STRING = "";
    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;
    /**
     * 用于封装随机产生的公钥与私钥
     */
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();

    /**
     * 随机生成密钥对
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        // 将公钥和私钥保存到Map
        //0表示公钥
        keyMap.put(0, publicKeyString);
        //1表示私钥
        keyMap.put(1, privateKeyString);
    }

    public static void importPublicKey(String publicKeyPath) throws IOException {


        File keyFile = new File(publicKeyPath);
        byte[] publicKey = Files.readAllBytes(keyFile.toPath());

        String keyString = new String(publicKey);
        keyString = keyString.replaceAll(NEW_LINE_CHARACTER, EMPTY_STRING)
                .replaceAll(PUBLIC_KEY_START_KEY_STRING, EMPTY_STRING)
                .replaceAll(PUBLIC_KEY_END_KEY_STRING, EMPTY_STRING);

//        publicKey = keyString.getBytes();
        keyMap.put(0, keyString);
        System.out.println("keyString = " + keyString);
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str) throws Exception {
        //  导入加密需要的公钥
        importPublicKey(PUBLICKEYPATH);
        //  base64编码的公钥
        byte[] decoded = Base64.getDecoder().decode(keyMap.get(0));
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.getDecoder().decode(str);
        //base64编码的私钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) throws Exception {
//        long temp = System.currentTimeMillis();
//        //生成公钥和私钥
//        genKeyPair();
//        //加密字符串
//        System.out.println("公钥:" + keyMap.get(0));
//        System.out.println("私钥:" + keyMap.get(1));
//        System.out.println("生成密钥消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");
//        String message = "RSA测试ABCD~!@#$";
//        System.out.println("原文:" + message);
//        temp = System.currentTimeMillis();
//        String messageEn = encrypt(message, keyMap.get(0));
//        System.out.println("密文:" + messageEn);
//        System.out.println("加密消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");
//        temp = System.currentTimeMillis();
//        String messageDe = decrypt(messageEn, keyMap.get(1));
//        System.out.println("解密:" + messageDe);
//        System.out.println("解密消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");

        // importPublicKey("E:\\projects\\socialNet\\src\\main\\resources\\rsa_public_key_pkcs8.pem");
        // String encrypt = encrypt("7k7k", keyMap.get(0));
        // System.out.println("encrypt = " + encrypt);
    }
}
