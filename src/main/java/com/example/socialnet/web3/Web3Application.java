package com.example.socialnet.web3;

import com.example.socialnet.contract.generated.java.org.web3j.model.TestReputation;
import com.example.socialnet.entities.Member;
import com.example.socialnet.entities.MessageGet;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static com.example.socialnet.constants.Constants.contractAddress;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/29 9:09
 */

public class Web3Application {

    // GAS价格
    public static BigInteger GAS_PRICE = BigInteger.valueOf(20);
    // GAS上限
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(900000);
    private String password;
    private String walletSource;
    private Web3j web3;
    private Credentials credentials;
    //    private static Storage  contract;
    private TestReputation contract;

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
        this.contract = TestReputation.load(contractAddress, web3, credentials, provider);
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

    public static void main(String[] args) throws Exception {

        String passwd = "8871527";
//        String walletSource = "./wallet/account_1.json";
        String walletSource = "./wallet/UTC--2022-10-14T15-45-49.132119416Z--2f131e1529990f2fd029ee449cfdab01685a8e5d";

        Web3Application web3Application = new Web3Application(passwd, walletSource);

        web3Application.sign_Message("dasodhaos");
//        web3Application.sign_Message();
//        web3Application.getMember("0xe4db9F1e7b7FBd3223c946b4148eF1ade61c6cC1");

//        web3Application.getMessage("0xe4db9F1e7b7FBd3223c946b4148eF1ade61c6cC1", BigInteger.valueOf(2));

//        web3Application.addMember("0x66B7366546D70b84c7727c7f45d32F73A472A508");
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
        Tuple5 tuple5 = contract.getMessage(memberAddress, indexMessage).send();

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
