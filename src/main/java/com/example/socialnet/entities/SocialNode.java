package com.example.socialnet.entities;

import com.example.socialnet.web3.Web3Application;

import static com.example.socialnet.constants.Constants.PASSWD;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/27 9:22
 */
public class SocialNode {


//    public  String contractAddress;
//    private int reputationValue;
//    public int messageNumber;

    private final String accountAddress;

    public final Web3Application web3Application;

    public String getAccountAddress() {
        return accountAddress;
    }

    //    public SocialNode() {
//
//    }
    public SocialNode(String wallet,String accountAddress) throws Exception {
        this.web3Application = new Web3Application(PASSWD,wallet);
        this.accountAddress = accountAddress;
    }


//    public String getContractAddress() throws Exception {
////        通过反射调用方法
////        Class<?> aClass = Class.forName("com.example.socialnet.web3.Application");
////        Method method = aClass.getDeclaredMethod("run",null);
//////        设置字段可访问，即暴力反射
////        method.setAccessible(true);
//////        可以给私有方法传参数
////        Object obj = method.invoke(aClass.newInstance());
////        System.out.println(obj);
//
//        return contractAddress;
//    }
//
//    public void setContractAddress(String contractAddress) {
//        this.contractAddress = contractAddress;
//    }
//
//    public int getReputationValue() {
//        return reputationValue;
//    }
//
//    public void setReputationValue(int reputationValue) {
//        this.reputationValue = reputationValue;
//    }
//
//    public int getMessageNumber() {
//        return messageNumber;
//    }
//
//    public void setMessageNumber(int messageNumber) {
//        this.messageNumber = messageNumber;
//    }

    /**
     * 接下里还需要实现加密、消息获取等功能
     */

//    public static void main(String[] args) throws Exception {
////        SocialNode socialNode = new SocialNode();
////        socialNode.getContractAddress();
//    }
}
