package com.example.socialnet.entities;

import java.math.BigInteger;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/14 16:22
 */
public class MessageGet {

    String ipfsHash;
    String senderAddress;
    BigInteger rumorValue;
    BigInteger emotionValue;
    BigInteger changeValue;

    public String getIpfsHash() {
        return ipfsHash;
    }

    public void setIpfsHash(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public BigInteger getRumorValue() {
        return rumorValue;
    }

    public void setRumorValue(BigInteger rumorValue) {
        this.rumorValue = rumorValue;
    }

    public BigInteger getEmotionValue() {
        return emotionValue;
    }

    public void setEmotionValue(BigInteger emotionValue) {
        this.emotionValue = emotionValue;
    }

    public BigInteger getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(BigInteger changeValue) {
        this.changeValue = changeValue;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ipfsHash='" + ipfsHash + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", rumorValue=" + rumorValue +
                ", emotionValue=" + emotionValue +
                ", changeValue=" + changeValue +
                '}';
    }
}
