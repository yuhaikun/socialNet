package com.example.socialnet.web3;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/11/9 16:06
 */
public class Web3ApplicationNew {
    public static BigInteger nonceTemp;

    public static String readFile(String jsonFile) throws Exception {

        StringBuffer stringBuffer;

        FileInputStream fileInputStream = new FileInputStream(jsonFile);

        int len;
        byte[] bytes = new byte[1024];
        stringBuffer = new StringBuffer();
        while ((len = fileInputStream.read(bytes)) != -1) {
            //            添加字符串到缓冲区
            stringBuffer.append(new String(bytes, 0, len));
        }
//            关闭资源
        fileInputStream.close();


        return stringBuffer.toString();
    }

    public static String readAccountsFromFiles(int fileNumber) throws Exception {


        String fileName = "./wallet/account_" + Integer.toString(fileNumber) + ".json";
        String jsonData = readFile(fileName);
//        转json对象
        JSONObject parse = (JSONObject) JSONObject.parse(jsonData);
        String address = parse.getString("address");
        address = "0x" + address;


        return address;

    }


    public static ArrayList<BigInteger> getIdenifiedResult(int indexOfMessage) throws Exception {
        ArrayList<BigInteger> res = new ArrayList<>();
        String s = readFile("E:\\projects\\dataHandle\\falseData1.json", indexOfMessage);
        System.out.println("s = " + s);
        JSONObject parse = (JSONObject) JSONObject.parse(s);


        BigInteger truthValue = parse.getBigInteger("truthValue");
        BigInteger emotionValue = parse.getBigInteger("emotionValue");
        res.add(truthValue);
        res.add(emotionValue);

        return res;

    }

    public static String encodeOfaddMessage(String tempAddress, String ipfsHash, BigInteger rumorValue, BigInteger emotionValue) {

        List<Type> inputParams = new ArrayList<>();
        Type address = new Address(tempAddress);
        inputParams.add(address);
        Utf8String ipfs = new Utf8String(ipfsHash);
        inputParams.add(ipfs);
        Type rV = new Uint(rumorValue);
        inputParams.add(rV);
        Type eV = new Uint(emotionValue);
        inputParams.add(eV);

        Function function = new Function(
                "addMessage",  // function we're calling
                inputParams,
                Collections.<TypeReference<?>>emptyList());
        return FunctionEncoder.encode(function);
    }

    public static String encodeOfaddMember() {
        String tempAddress = "dC4D12080D0278F3809c299E6249B430581C4D8A";
        List<Type> inputParams = new ArrayList<>();
        Type address = new Address(tempAddress);
        inputParams.add(address);
        Function function = new Function(
                "addMember",  // function we're calling
                inputParams,
                Collections.<TypeReference<?>>emptyList());
        return FunctionEncoder.encode(function);
    }

    public static String encodeOfForwardMessage(String tempAddress, BigInteger tempIndex) {
        // String tempAddress = "2f131e1529990f2fd029ee449cfdab01685a8e5d";
        List<Type> inputParams = new ArrayList<>();
        Type address = new Address(tempAddress);
        inputParams.add(address);
        // BigInteger tempIndex = BigInteger.valueOf(1);
        Type indexOfMessage = new Uint(tempIndex);
        inputParams.add(indexOfMessage);

        Function function = new Function(
                "forwardMessage",  // function we're calling
                inputParams,
                Collections.<TypeReference<?>>emptyList());
        return FunctionEncoder.encode(function);
    }

    public static String readFile(String jsonFile, int index) throws Exception {

//        rwl.readLock().lock();
        JSONObject x;

        FileInputStream fileInputStream = new FileInputStream(jsonFile);

        int len;
        byte[] bytes = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while ((len = fileInputStream.read(bytes)) != -1) {
            //            添加字符串到缓冲区
            stringBuffer.append(new String(bytes, 0, len));
        }
//            关闭资源
        fileInputStream.close();


//            使用fastjson将字符串转换成json
        JSONArray jsonArray = JSONObject.parseArray(stringBuffer.toString());

//        System.out.println("大小为：" + jsonArray.size());
//            便于对象去除我们需要的数据
//        for (Object schema :
//                jsonArray) {
//            JSONObject x = (JSONObject) schema;
//            System.out.println("发送的信息是：" + x);
//        }
        x = (JSONObject) jsonArray.get(index);
//            对发送的信息进行签名，将签名后的信息一并发送，在服务器端进行验证
//         String text = x.getString("text");

        // x.put("account", this.socialNode.getAccountAddress());

        return x.toString();
    }

//     public static void main(String[] args) throws Exception {
//
//
//         String passwd = "123456";
//         Admin web3j = Admin.build(new HttpService("http://1.12.254.160:8546/"));
//
//         // String encodedFunction = encodeOfaddMessage("d94475783C7B69569351528d069eAF443e499a65","QmTedsLYLUvaYp94psXLaVgynPBhUga93xNk1PBQmQpN9G",BigInteger.valueOf(4444),BigInteger.valueOf(5555));
//         // System.out.println("encodedFunction = " + encodedFunction);
//
//         // String address = "0x4912c23245d9fe35ab93560861427741483aeedf";
//         // EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
//         //         address, DefaultBlockParameterName.LATEST).sendAsync().get();
//         //
//         // BigInteger nonce = ethGetTransactionCount.getTransactionCount();
//         //
//         //
//         //
//         // Transaction transaction = Transaction.createFunctionCallTransaction(
//         //         address,
//         //         nonce,
//         //         BigInteger.valueOf(21000000000L),
//         //         BigInteger.valueOf(1000000),
//         //         "0x6DD1310474Eb562779e497b9ac606E77221ddB66",
//         //         encodedFunction
//         //
//         // );
//         //
//         // PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(address, "8871527").send();
//         // if (personalUnlockAccount.accountUnlocked()) {
//         //     // send a transaction
//         //     EthSendTransaction transactionResponse =
//         //             web3j.ethSendTransaction(transaction).sendAsync().get();
//         //
//         //     String transactionHash = transactionResponse.getTransactionHash();
//         // }
//
//         String ipfsHash = "QmQGr7PnsYqJxSB8K1BfzG5WE2KbmQjXsiBMGeNfEHJotE";
//         for (int i = 0; i < 10; i++) {
//             String account = readAccountsFromFiles(i + 1);
//
//             EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
//                     account, DefaultBlockParameterName.LATEST).sendAsync().get();
//
//             BigInteger nonce = ethGetTransactionCount.getTransactionCount();
//
//
//             ArrayList<BigInteger> idenifiedResult = getIdenifiedResult(i);
//             System.out.println("idenifiedResult = " + idenifiedResult);
//             String encodedFunction = encodeOfaddMessage(account, ipfsHash, idenifiedResult.get(0), idenifiedResult.get(1));
//
//             Transaction transaction = Transaction.createFunctionCallTransaction(
//                     account,
//                     nonce,
//                     BigInteger.valueOf(21000000000L),
//                     BigInteger.valueOf(1000000),
//                     "0x00370CFed41fb24b42Cc0ba846e676B667D4AC4F",
//                     encodedFunction
//
//             );
//
//             PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(account, "123456").send();
//             if (personalUnlockAccount.accountUnlocked()) {
//                 // send a transaction
//                 EthSendTransaction transactionResponse =
//                         web3j.ethSendTransaction(transaction).sendAsync().get();
//
//                 // String transactionHash = transactionResponse.getTransactionHash();
//             }
//
//         }
//         System.out.println("complete");
//
// // wait for response using EthGetTransactionReceipt...
//     }


    public static boolean bulkForwarding(Admin web3j, String account) throws Exception {
        // String account = "0x2f131e1529990f2fd029ee449cfdab01685a8e5d";
        // Admin web3j = Admin.build(new HttpService("http://1.12.254.160:8546/"));
        // EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
        //         account, DefaultBlockParameterName.LATEST).sendAsync().get();
        //
        // BigInteger nonce = ethGetTransactionCount.getTransactionCount();


        // ArrayList<BigInteger> idenifiedResult = getIdenifiedResult(i);
        // System.out.println("idenifiedResult = " + idenifiedResult);
        for (int i = 0; i < 10; i++) {
            String sender = readAccountsFromFiles(i + 1);
            String encodedFunction = encodeOfForwardMessage(sender, BigInteger.valueOf(1));

            Transaction transaction = Transaction.createFunctionCallTransaction(
                    account,
                    nonceTemp,
                    BigInteger.valueOf(21000000000L),
                    BigInteger.valueOf(1000000),
                    "0x00370CFed41fb24b42Cc0ba846e676B667D4AC4F",
                    encodedFunction
            );

            PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(account, "8871527").send();
            if (personalUnlockAccount.accountUnlocked()) {
                // send a transaction
                EthSendTransaction transactionResponse =
                        web3j.ethSendTransaction(transaction).sendAsync().get();

                // String transactionHash = transactionResponse.getTransactionHash();
            }
            nonceTemp = nonceTemp.add(BigInteger.valueOf(1));
        }

        return true;
    }

    public static void bulkSending(Admin web3j, String account) throws Exception {

        String ipfsHash = "QmRtSNCZqiGuNpTP5Mo2GyCptp5XnTpqFicp7ofdgDX4Wk";
        String sender = readAccountsFromFiles(1);
        for (int i = 0; i < 20; i++) {

            ArrayList<BigInteger> idenifiedResult = getIdenifiedResult(i);
            System.out.println("idenifiedResult = " + idenifiedResult);

            String encodedFunction = encodeOfaddMessage(account, ipfsHash, idenifiedResult.get(0), idenifiedResult.get(1));

            Transaction transaction = Transaction.createFunctionCallTransaction(
                    account,
                    nonceTemp,
                    BigInteger.valueOf(21000000000L),
                    BigInteger.valueOf(1000000),
                    "0xFDdCE2c7B1A49d2F49c0cBe0414EeB909B07ECDF",
                    encodedFunction
            );

            PersonalUnlockAccount personalUnlockAccount = web3j.personalUnlockAccount(account, "8871527").send();
            if (personalUnlockAccount.accountUnlocked()) {
                // send a transaction
                EthSendTransaction transactionResponse =
                        web3j.ethSendTransaction(transaction).sendAsync().get();

                // String transactionHash = transactionResponse.getTransactionHash();
            }
            nonceTemp = nonceTemp.add(BigInteger.valueOf(1));
        }
    }

    public static void main(String[] args) throws Exception {

        String account = "0x2F131e1529990F2fD029EE449CFDab01685a8e5d";
        Admin web3j = Admin.build(new HttpService("http://1.12.254.160:8546/"));
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                account, DefaultBlockParameterName.LATEST).sendAsync().get();

        nonceTemp = ethGetTransactionCount.getTransactionCount();
        BigInteger initNonce = nonceTemp;
        // bulkForwarding(web3j, account);
        bulkSending(web3j,account);
        BigInteger res = nonceTemp.subtract(initNonce);
        System.out.println("消息转发的次数为 = " + res);
    }
}
