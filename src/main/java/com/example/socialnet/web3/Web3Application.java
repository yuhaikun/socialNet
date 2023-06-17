package com.example.socialnet.web3;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socialnet.contract.generated.java.org.web3j.model.TestReputationV7;
import com.example.socialnet.entities.Member;
import com.example.socialnet.entities.MessageGet;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Sign;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.example.socialnet.constants.Constants.QUEUE_NAME;
import static com.example.socialnet.constants.Constants.contractAddress;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/29 9:09
 */

public class Web3Application {

    // GAS价格
    public static BigInteger GAS_PRICE = BigInteger.valueOf(21000000000L);
    // GAS上限
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(1000000);
    private String password;
    private String walletSource;
    public Web3j web3;
    private Credentials credentials;
    //    private static Storage  contract;
    private TestReputationV7 contract;
    /**
     * 构造函数在传递参数的同时将合约初始化
     *
     * @param password
     * @param walletSource
     */

    public Web3Application(String password, String walletSource) throws Exception {
        this.password = password;
        this.walletSource = walletSource;

        //        创建一个web3实例来连接网络中的远端节点
        web3 = Web3j.build(new HttpService("http://1.12.254.160:8546/"));

//        File file = new File("./wallet");
//
//        for (int i = 0; i < 7; i++) {
//            WalletUtils.generateNewWalletFile("123456", file, true);
//        }

        this.credentials = WalletUtils.loadCredentials(password, walletSource);

//        System.out.println("Welcome " + credentials.getAddress());

        ContractGasProvider provider = new ContractGasProvider() {
            @Override
            public BigInteger getGasPrice(String s) {
                return GAS_PRICE;
            }

            @Override
            public BigInteger getGasPrice() {
                return GAS_PRICE;
            }

            @Override
            public BigInteger getGasLimit(String s) {
                return GAS_LIMIT;
            }

            @Override
            public BigInteger getGasLimit() {
                return GAS_LIMIT;
            }
        };
//        instantiate the contract
        this.contract = TestReputationV7.load(contractAddress, web3, credentials, provider);
//        say hello
//        this.contract = Storage.load(contractAddress, web3, credentials,provider);
//
//        TransactionReceipt store = contract.store(BigInteger.valueOf(11)).send();
//
//        BigInteger retrieve = contract.retrieve().send();
//
//        System.out.println("常量值为：" + retrieve);
    }


    //    private static String contractAddress = "0x0B00E62eDc27BA04e133C499AadACe9CB6590277";

//    public static void main(String[] args) throws Exception {
//        String passwd = "123456";
////        String walletSource = "./wallet/account_1.json";
//        String walletSource = "./wallet/account_1.json";
//        new Web3Application(passwd,walletSource);
//    }

    //    public int getMemberReputationValue(String memberAddress) throws Exception {
//        BigInteger reputationValue = contract.getMemberReputationValue(memberAddress).send();
//        return reputationValue.intValue();
//    }
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

    public static String readAccountsFromFiles(int fileNumber) throws Exception {


        String fileName = "./wallet/account_" + Integer.toString(fileNumber) + ".json";
        String jsonData = readFile(fileName);
//        转json对象
        JSONObject parse = (JSONObject) JSONObject.parse(jsonData);
        String address = parse.getString("address");
        address = "0x" + address;


        return address;

    }




    public static void main(String[] args) throws Exception {

        // web3Application.sign_Message("dasodhaos");
//        web3Application.sign_Message();
//        web3Application.getMember("0xe4db9F1e7b7FBd3223c946b4148eF1ade61c6cC1");

//        web3Application.getMessage("0xe4db9F1e7b7FBd3223c946b4148eF1ade61c6cC1", BigInteger.valueOf(2));

//        web3Application.addMember("0x66B7366546D70b84c7727c7f45d32F73A472A508")
//        ;


        String passwd = "8871527";
//        String walletSource = "./wallet/account_1.json";
        String walletSource = "./wallet/UTC--2022-10-14T15-45-49.132119416Z--2f131e1529990f2fd029ee449cfdab01685a8e5d";
        Web3Application web3Application = new Web3Application(passwd, walletSource);
        for (int i = 0; i < 10; i++) {
                String fileName = "./wallet/account_" + Integer.toString(i+1) + ".json";
                String accountFromFile = readAccountsFromFiles(i+1);
                web3Application.transferEthWith(accountFromFile);

        }





//         Admin web3j = Admin.build(new HttpService("http://1.12.254.160:8546/"));
//         String passwd = "8871527";
//         String ipfsHash = "QmYtiiUYf7bNopgusyyXRkZZsbVbwzjpb4uCeLaRtLRKZJ";
//         // for (int i = 0; i < 10; i++) {
//            String fileName = "./wallet/UTC--2022-10-14T15-45-49.132119416Z--2f131e1529990f2fd029ee449cfdab01685a8e5d";
//         //     String fileName = "./wallet/account_" + Integer.toString(2 )+ ".json";
//         //     String accountFromFile = readAccountsFromFiles(2);
//             String accountFromFile = "0xA3F006E7D6fB54e4BB9A81F111c66c711D617059";
//
//             String s = readFile("E:\\projects\\dataHandle\\test_data.json", 1);
//             System.out.println("s = " + s);
//             JSONObject parse = (JSONObject) JSONObject.parse(s);
//
//
//             BigInteger truthValue = parse.getBigInteger("truthValue");
//             BigInteger emotionValue = parse.getBigInteger("emotionValue");
//             Web3Application web3Application = new Web3Application(passwd, fileName);
//
//
//             // RawTransactionManager rawTransactionManager = new RawTransactionManager(web3Application.web3,web3Application.credentials);
//
//             // for (int j = 0; j < 10; j++) {
//             //     web3Application.contract.addMessage(accountFromFile, ipfsHash, truthValue, emotionValue).sendAsync();
//             // }
//             web3Application.contract.addMessage(accountFromFile, ipfsHash, truthValue, emotionValue).send();
//         // }
//
//         System.out.println("complate！");
    }

    public  void transferEthWith(String to) throws  Exception
    {

        TransactionReceipt trasnsactionReceipt = Transfer.sendFunds(web3, credentials, to, BigDecimal.valueOf(5.0), Convert.Unit.ETHER).send();

    }



    public void getMember(String memberAddress) throws Exception {

//        System.out.println(contract.getMember(memberAddress).send());
        Member member = new Member();


        //       使用三元组接收查询的值
        Tuple3 tuple3 = contract.getMember(memberAddress).send();


        member.setMemberAddress(tuple3.component1().toString());
        member.setNumberOfMessage((BigInteger) tuple3.component2());
        member.setReputationValue((BigInteger) tuple3.component3());


        System.out.println(member.toString());

    }

    public void getMessage(String memberAddress, BigInteger indexMessage) throws Exception {
        MessageGet message = new MessageGet();

        //       使用三元组接收查询的值
        Tuple6<String, String, BigInteger, BigInteger, BigInteger, BigInteger> tuple5 = contract.getMessage(memberAddress, indexMessage).send();

        message.setIpfsHash(tuple5.component1().toString());
        message.setSenderAddress(tuple5.component2().toString());
        message.setRumorValue((BigInteger) tuple5.component3());
        message.setEmotionValue((BigInteger) tuple5.component4());
        message.setChangeValue((BigInteger) tuple5.component5());

        System.out.println(message);

    }

    public void addMember(String tempAddress) throws Exception {

        contract.addMember(tempAddress).send();

    }

    public void addMessage(String memberAddress, String ipfsHash, BigInteger tempRumorValue, BigInteger tempEmotionValue) throws Exception {

        contract.addMessage(memberAddress, ipfsHash, tempRumorValue, tempEmotionValue).send();

    }

    public void forwardMessage(String memberAddress, BigInteger indexMessage) throws Exception {

        contract.forwardMessage(memberAddress, indexMessage).send();
    }


    /**
     * 返回签名后的字符串
     *
     * @param message
     * @return
     * @throws Exception
     */
    public String sign_Message(String message) throws Exception {


//        String privateAccountKey = "503f38a9c967ed597e47fe25643985f032b072db8075426a92110f82df48dfcb";
//        Credentials credentials = Credentials.create(privateAccountKey);
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
//        System.out.println("messageBytes = " + Numeric.toHexString(messageBytes));
        Sign.SignatureData signature = Sign.signPrefixedMessage(messageBytes, credentials.getEcKeyPair());
        byte[] value = new byte[65];
        System.arraycopy(signature.getR(), 0, value, 0, 32);
        System.arraycopy(signature.getS(), 0, value, 32, 32);
        System.arraycopy(signature.getV(), 0, value, 64, 1);
//        System.out.println("hash: " + Numeric.toHexString(Sign.getEthereumMessageHash(messageBytes)));
//        System.out.println("signature: " + Numeric.toHexString(value));


        return Numeric.toHexString(value);


    }

}
