package com.example.socialnet.web3;

import com.example.socialnet.contract.generated.java.org.web3j.model.Storage;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/29 9:09
 */
public class Application {

    // GAS价格
    public static BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    // GAS上限
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000L);

    private static String contractAddress = "0x0B00E62eDc27BA04e133C499AadACe9CB6590277";

    public static void main(String[] args) throws Exception {
        new Application().run();
    }

    private void run() throws Exception {
//        创建一个web3实例来连接网络中的远端节点
        Web3j web3 = Web3j.build(new HttpService("http://localhost:9545/"));

//        File file = new File("./wallet");
//        WalletUtils.generateNewWalletFile("123456", file, true);

        Credentials credentials = WalletUtils.loadCredentials("123456", "./wallet/UTC--2022-08-29T02-04-28.615000000Z--3e199356cf67fd0a4df5fd5ce74ad3ef0d8bc30b.json");

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
        Storage contract = Storage.load(contractAddress, web3, credentials,provider);
//        say hello
//        TransactionReceipt store = contract.store(BigInteger.valueOf(11)).send();

        BigInteger retrieve = contract.retrieve().send();

        System.out.println("常量值为：" + retrieve);

    }

}
