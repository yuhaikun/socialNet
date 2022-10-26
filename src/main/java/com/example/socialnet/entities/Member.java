package com.example.socialnet.entities;

import jnr.ffi.Struct;

import java.math.BigInteger;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/14 16:01
 */
public class Member {
    String memberAddress;
    BigInteger numberOfMessage;
    BigInteger reputationValue;

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public BigInteger getNumberOfMessage() {
        return numberOfMessage;
    }

    public void setNumberOfMessage(BigInteger numberOfMessage) {
        this.numberOfMessage = numberOfMessage;
    }

    public BigInteger getReputationValue() {
        return reputationValue;
    }

    public void setReputationValue(BigInteger reputationValue) {
        this.reputationValue = reputationValue;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberAddress='" + memberAddress + '\'' +
                ", numberOfMessage=" + numberOfMessage +
                ", reputationValue=" + reputationValue +
                '}';
    }
}
