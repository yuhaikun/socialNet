pragma experimental ABIEncoderV2;
// SPDX-License-Identifier: SimPL-2.0
pragma solidity ^0.6.12;

import "./provableAPI_0.6.sol";

// import "github.com/Arachnid/solidity-stringutils/blob/master/src/strings.sol";
// import "./provableAPI.sol";
// import "./strings.sol";

contract GetMessage is usingProvable {
    // using strings for *;
    // 设置获取信息的事件
    event LogGetMessage(Message _message);
    // 设置provable_query的事件
    event LogNewProvableQuery(string _description);

    // 设置更新IPFSHash的事件
    event LogIpfsUpdate(string ipfsHash);
    // 设置更新sendTime的事件
    event LogSendAddressUpdate(address senderAddress);

    // 存储message的结构体
    struct Message {
        string ipfsHash;
        address senderAddress;
        uint256 rumorValue;
        uint256 emotionValue;
        // uint256 sendTime;
        int changeValue;
    }

    uint8 dataTypeValue;
    // 验证查询ID是否被使用过了，确保每个查询相应只处理一次，并有助于避免滥用智能合约逻辑
    mapping(bytes32 => bool) validIds;
    
    Message public newMessage;

    // 社交网络中一个实体
    struct Member {
        // 实体的地址
        address memberAddress;
        // 发送信息的数量
        uint256 numberOfMessage;
        // 信誉值
        int256 reputationValue;
        // 实体对应的信息
        mapping(uint256 => Message) messageOfMember;
    }

    // 检查该地址是否已经注册为实体
    mapping(address => bool) members;
    // 检测该消息是否已经被存储
    mapping(string => bool) judgeIpfs;

    // 一个实体地址对应一个下标
    mapping(address => uint256) indexOfMember;
    // mapping(address=>Message[]) messageOfMember;

    // 所有注册的实体
    Member[] public memberArray;

    // 注册实体,返回数组当中的序号
    function addMember(address tempAddress) public {
        // 检查实体是否被注册
        require(members[tempAddress] == false, "the address was registered");

        Member memory newMember = Member({
            memberAddress: tempAddress,
            numberOfMessage: 0,
            reputationValue: 100
        });

        indexOfMember[tempAddress] = memberArray.length;
        memberArray.push(newMember);

        // 标记该地址已经注册
        members[tempAddress] = true;
    }

    // function addMessage(address memberAddress, string memory ipfsNewHash)
    //     public
    // {
    //     if (members[memberAddress] == false) {
    //         addMember(memberAddress);
    //     }

    //     // 取出相应的实体
    //     // 新消息构造方法
    //     Message memory newMessage = Message({
    //         ipfsHash: ipfsNewHash,
    //         senderAddress: memberAddress,
    //         rumorValue: 0,
    //         emotionValue: 0,
    //         changeValue: 0
    //     });

    //     // 取出实体对应的下标
    //     uint256 memberIndex = indexOfMember[memberAddress];

    //     // 取出实体信息对应的下标
    //     uint256 messageIndex = memberArray[memberIndex].numberOfMessage;

    //     memberArray[memberIndex].messageOfMember[messageIndex] = newMessage;

    //     memberArray[memberIndex].numberOfMessage++;
    // }

    function addMessage(
        address memberAddress,string memory ipfs,uint tempRumorValue,uint tempEmotionValue
    ) public {
        if (members[memberAddress] == false) {
            addMember(memberAddress);
        }
        Message memory tempMessage = Message({
            ipfsHash: ipfs,
            senderAddress: memberAddress,
            rumorValue: tempRumorValue,
            emotionValue: tempEmotionValue,
            changeValue: 0
        });

        // 取出实体对应的下标
        uint256 memberIndex = indexOfMember[memberAddress];

        // 取出实体信息对应的下标
        uint256 messageIndex = memberArray[memberIndex].numberOfMessage;

        memberArray[memberIndex].messageOfMember[messageIndex] = tempMessage;

        memberArray[memberIndex].numberOfMessage++;

        changeReputationValue(memberIndex,messageIndex,tempRumorValue,tempEmotionValue);
    }

    constructor() public {
        // fetchMessageViaProvable();
    }

    // function getAllMessage(Message memory temp) public{}

    function fetchMessageViaProvable(string memory ipfs, string memory dataType)
        public
        payable
    {
        // 要求该信息之前没有被存储上链
        require(judgeIpfs[ipfs] == false, "this message has been stored");
        newMessage.ipfsHash = ipfs;
        if (strCompare(dataType, "model") == 0) {
            dataTypeValue = 2;
        } else if (strCompare(dataType, "senderAddress") == 0) {
            dataTypeValue = 1;
        }
        string memory queryURL = "json(https://gateway.ipfs.io/ipfs/";
        queryURL = strNewConcat(queryURL, ipfs);

        // queryURL = strNewConcat(queryURL, "/1.json).");
        queryURL = strNewConcat(queryURL, ").");

        queryURL = strNewConcat(queryURL, dataType);
        // 判断合约余额足够进行查询
        if (provable_getPrice("URL") > address(this).balance) {
            emit LogNewProvableQuery(
                "Provable query was NOT sent,please add some ETH to cover for the query fee"
            );
        } else {
            emit LogNewProvableQuery(
                "Provable query was sent,standing by for the answer..."
            );
            bytes32 queryId = provable_query("URL", queryURL);
            validIds[queryId] = true;
        }
    }

    function __callback(bytes32 _myid, string memory _result) public override {
        if (!validIds[_myid]) revert();
        if (msg.sender != provable_cbAddress()) revert();

        if (dataTypeValue == 1) {
            newMessage.senderAddress = parseAddr(_result);
        } else if (dataTypeValue == 2) {
            // 一次查询获得多个值（谣言值、情感值）
            string memory temp1 = "00";
            string memory temp2 = "00";

            bytes(temp1)[0] = bytes(_result)[2];
            bytes(temp1)[1] = bytes(_result)[3];

            bytes(temp2)[0] = bytes(_result)[8];
            bytes(temp2)[1] = bytes(_result)[9];

            newMessage.rumorValue = parseInt(temp1);
            newMessage.emotionValue = parseInt(temp2);

            // addMessage(newMessage.senderAddress,newMessage.ipfsHash,newMessage.rumorValue,newMessage.emotionValue);

            // delete newMessage;
        }

        delete validIds[_myid];
    }

    receive() external payable {}

    fallback() external payable {}

    function strNewConcat(string memory _a, string memory _b)
        internal
        pure
        returns (string memory)
    {
        bytes memory _ba = bytes(_a);
        bytes memory _bb = bytes(_b);
        string memory ret = new string(_ba.length + _bb.length);
        bytes memory bret = bytes(ret);
        uint256 k = 0;
        for (uint256 i = 0; i < _ba.length; i++) {
            bret[k++] = _ba[i];
        }
        for (uint256 i = 0; i < _bb.length; i++) {
            bret[k++] = _bb[i];
        }
        return string(ret);
    }

    function getSenderAddress() public view returns (address) {
        while (newMessage.senderAddress != address(0)) {
            return newMessage.senderAddress;
        }
        //  require(newMessage.senderAddress != address(0),"senderaddress is null");
        return newMessage.senderAddress;
    }

    function getRumorValue() public view returns (uint256) {
        return newMessage.rumorValue;
    }

    function getEmotionValue() public view returns (uint256) {
        return newMessage.emotionValue;
    }

    // 返回一个实体发送的某一条信息
    function getMessage(address memberAddress, uint256 indexMessage)
        public
        view
        returns (Message memory)
    {
        // 取出实体对应的下标
        uint256 memberIndex = indexOfMember[memberAddress];

        return memberArray[memberIndex].messageOfMember[indexMessage];
    }
    // function getSendTime() public view returns (uint256) {
    //     return newMessage.sendTime;
    // }

    // 信誉值变动规则
    function changeReputationValue(uint memberIndex,uint messageIndex,uint rumorValue,uint emotionValue) internal{

        if (rumorValue >= 5000) {
        
            memberArray[memberIndex].messageOfMember[messageIndex].changeValue = -1 * int(emotionValue) / 1000;
        }else{
            memberArray[memberIndex].messageOfMember[messageIndex].changeValue = int(emotionValue) / 1000;
        }

        // memberArray[memberIndex].messageOfMember[messageIndex].changeValue = 
        memberArray[memberIndex].reputationValue += memberArray[memberIndex].messageOfMember[messageIndex].changeValue;
    }
}