package com.example.socialnet.contract.generated.java.org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Test0906 extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506122c7806100206000396000f3fe6080604052600436106100ab5760003560e01c8063570c537e11610064578063570c537e1461018557806375304f48146101b25780637cbc46b8146101c7578063c0a78feb146101dc578063c726dea8146101fc578063ca6d56dc1461022b576100b2565b80630948489d146100b4578063254f5c25146100ea57806327dc297e1461011057806329b73d381461013057806338bbfa501461014357806342948e1814610163576100b2565b366100b257005b005b3480156100c057600080fd5b506100d46100cf366004611d90565b61024b565b6040516100e1919061200b565b60405180910390f35b3480156100f657600080fd5b506100ff61028c565b6040516100e195949392919061205c565b34801561011c57600080fd5b506100b261012b366004611e70565b610341565b6100b261013e366004611f1f565b61051c565b34801561014f57600080fd5b506100b261015e366004611eb5565b610733565b34801561016f57600080fd5b50610178610764565b6040516100e19190611fd6565b34801561019157600080fd5b506101a56101a0366004611e2d565b61079a565b6040516100e191906121cf565b3480156101be57600080fd5b506100d46108bb565b3480156101d357600080fd5b506100d46108c1565b3480156101e857600080fd5b506100b26101f7366004611dcf565b6108c7565b34801561020857600080fd5b5061021c610217366004611f76565b610a27565b6040516100e193929190611fea565b34801561023757600080fd5b506100b2610246366004611d90565b610a61565b6001600160a01b0381166000908152600e6020526040812054600f80548290811061027257fe5b906000526020600020906004020160020154915050919050565b60078054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281529183918301828280156103145780601f106102e957610100808354040283529160200191610314565b820191906000526020600020905b8154815290600101906020018083116102f757829003601f168201915b5050505060018301546002840154600385015460049095015493946001600160a01b039092169390925085565b60008281526006602052604090205460ff1661035c57600080fd5b610364610b8c565b6001600160a01b0316336001600160a01b03161461038157600080fd5b60055460ff16600114156103bd5761039881610d9b565b600880546001600160a01b0319166001600160a01b0392909216919091179055610503565b60055460ff166002141561050357604080518082018252600280825261030360f41b602080840182905284518086019095528285528401528351919291849190811061040557fe5b602001015160f81c60f81b8260008151811061041d57fe5b60200101906001600160f81b031916908160001a9053508260038151811061044157fe5b602001015160f81c60f81b8260018151811061045957fe5b60200101906001600160f81b031916908160001a9053508260088151811061047d57fe5b602001015160f81c60f81b8160008151811061049557fe5b60200101906001600160f81b031916908160001a905350826009815181106104b957fe5b602001015160f81c60f81b816001815181106104d157fe5b60200101906001600160f81b031916908160001a9053506104f182610f36565b6009556104fd81610f36565b600a5550505b506000908152600660205260409020805460ff19169055565b600d8260405161052c9190611fba565b9081526040519081900360200190205460ff16156105655760405162461bcd60e51b815260040161055c90612143565b60405180910390fd5b8151610578906007906020850190611c1d565b506105a081604051806040016040528060058152602001641b5bd9195b60da1b815250610f43565b6105b6576005805460ff191660021790556105f7565b6105e5816040518060400160405280600d81526020016c73656e6465724164647265737360981b815250610f43565b6105f7576005805460ff191660011790555b606060405180606001604052806022815260200161227060229139905061061e8184611046565b90506106448160405180604001604052806002815260200161149760f11b815250611046565b90506106508183611046565b9050476106776040518060400160405280600381526020016215549360ea1b815250611150565b11156106b7577fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c473896040516106aa9061209c565b60405180910390a161072e565b7fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c473896040516106e49061217a565b60405180910390a160006107136040518060400160405280600381526020016215549360ea1b81525083611356565b6000908152600660205260409020805460ff19166001179055505b505050565b5050600080805260036020527f3617319a054d772f909f7c479a2cebe5066e836a939412e32403c99029b92eff5550565b60006008546001600160a01b03161561078957506008546001600160a01b0316610797565b506008546001600160a01b03165b90565b6107a2611c9b565b6001600160a01b0383166000908152600e6020526040902054600f8054829081106107c957fe5b6000918252602080832086845260049290920290910160030181526040918290208251815460026001821615610100026000190190911604601f8101849004909302810160c090810190945260a081018381529093919284928491908401828280156108765780601f1061084b57610100808354040283529160200191610876565b820191906000526020600020905b81548152906001019060200180831161085957829003601f168201915b505050918352505060018201546001600160a01b0316602082015260028201546040820152600382015460608201526004909101546080909101529150505b92915050565b600a5490565b60095490565b6001600160a01b0384166000908152600c602052604090205460ff166108f0576108f084610a61565b6108f8611c9b565b506040805160a0810182528481526001600160a01b038616602080830182905282840186905260608301859052600060808401819052918252600e905291822054600f8054929391928390811061094b57fe5b906000526020600020906004020160010154905082600f838154811061096d57fe5b60009182526020808320858452600360049093020191909101815260409091208251805191926109a292849290910190611c1d565b5060208201516001820180546001600160a01b0319166001600160a01b039092169190911790556040820151600282015560608201516003820155608090910151600490910155600f8054839081106109f757fe5b600091825260209091206001600490920201810180549091019055610a1e8282878761160f565b50505050505050565b600f8181548110610a3457fe5b60009182526020909120600490910201805460018201546002909201546001600160a01b03909116925083565b6001600160a01b0381166000908152600c602052604090205460ff1615610a9a5760405162461bcd60e51b815260040161055c9061210c565b610aa2611cd3565b50604080516060810182526001600160a01b03928316808252600060208084018281526064858701908152600f8054868652600e85528886208190556001808201835591865296517f8d1108e10bcb7c27dddfc02ed9d693a074039d026cf4ea4240b40f7d581ac802600490980297880180546001600160a01b03191691909a161790985590517f8d1108e10bcb7c27dddfc02ed9d693a074039d026cf4ea4240b40f7d581ac803860155517f8d1108e10bcb7c27dddfc02ed9d693a074039d026cf4ea4240b40f7d581ac80490940193909355908152600c90915220805460ff19169091179055565b6001546000906001600160a01b03161580610bb95750600154610bb7906001600160a01b03166116eb565b155b15610bca57610bc860006116ef565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610c1a57600080fd5b505af1158015610c2e573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610c529190611db3565b6000546001600160a01b03908116911614610d1057600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610cb757600080fd5b505af1158015610ccb573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610cef9190611db3565b600080546001600160a01b0319166001600160a01b03929092169190911790555b60008054906101000a90046001600160a01b03166001600160a01b031663c281d19e6040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610d5e57600080fd5b505af1158015610d72573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610d969190611db3565b905090565b60008181808060025b602a811015610f2b5761010084029350848181518110610dc057fe5b0160200151855160f89190911c9350859060018301908110610dde57fe5b016020015160f81c915060616001600160a01b03841610801590610e0c57506066836001600160a01b031611155b15610e1c57605783039250610e80565b6041836001600160a01b031610158015610e4057506046836001600160a01b031611155b15610e5057603783039250610e80565b6030836001600160a01b031610158015610e7457506039836001600160a01b031611155b15610e80576030830392505b6061826001600160a01b031610158015610ea457506066826001600160a01b031611155b15610eb457605782039150610f18565b6041826001600160a01b031610158015610ed857506046826001600160a01b031611155b15610ee857603782039150610f18565b6030826001600160a01b031610158015610f0c57506039826001600160a01b031611155b15610f18576030820391505b6010830282019390930192600201610da4565b509195945050505050565b60006108b58260006116f9565b815181516000918491849190811115610f5a575080515b60005b8181101561100c57828181518110610f7157fe5b602001015160f81c60f81b6001600160f81b031916848281518110610f9257fe5b01602001516001600160f81b0319161015610fb5576000199450505050506108b5565b828181518110610fc157fe5b602001015160f81c60f81b6001600160f81b031916848281518110610fe257fe5b01602001516001600160f81b03191611156110045760019450505050506108b5565b600101610f5d565b508151835110156110245760001993505050506108b5565b81518351111561103a57600193505050506108b5565b600093505050506108b5565b805182516060918491849184910167ffffffffffffffff8111801561106a57600080fd5b506040519080825280601f01601f191660200182016040528015611095576020820181803683370190505b509050806000805b85518110156110ee578581815181106110b257fe5b602001015160f81c60f81b8383806001019450815181106110cf57fe5b60200101906001600160f81b031916908160001a90535060010161109d565b5060005b84518110156111435784818151811061110757fe5b602001015160f81c60f81b83838060010194508151811061112457fe5b60200101906001600160f81b031916908160001a9053506001016110f2565b5091979650505050505050565b6001546000906001600160a01b0316158061117d575060015461117b906001600160a01b03166116eb565b155b1561118e5761118c60006116ef565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b1580156111de57600080fd5b505af11580156111f2573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906112169190611db3565b6000546001600160a01b039081169116146112d457600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b15801561127b57600080fd5b505af115801561128f573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906112b39190611db3565b600080546001600160a01b0319166001600160a01b03929092169190911790555b60005460405163524f388960e01b81526001600160a01b039091169063524f388990611304908590600401612049565b602060405180830381600087803b15801561131e57600080fd5b505af1158015611332573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906108b59190611e58565b6001546000906001600160a01b031615806113835750600154611381906001600160a01b03166116eb565b155b156113945761139260006116ef565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b1580156113e457600080fd5b505af11580156113f8573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061141c9190611db3565b6000546001600160a01b039081169116146114da57600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b15801561148157600080fd5b505af1158015611495573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906114b99190611db3565b600080546001600160a01b0319166001600160a01b03929092169190911790555b6000805460405163524f388960e01b81526001600160a01b039091169063524f38899061150b908790600401612049565b602060405180830381600087803b15801561152557600080fd5b505af1158015611539573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061155d9190611e58565b90503a62030d4002670de0b6b3a7640000018111156115805750600090506108b5565b6000805460405163adf59f9960e01b81526001600160a01b039091169163adf59f999184916115b59189908990600401612014565b6020604051808303818588803b1580156115ce57600080fd5b505af11580156115e2573d6000803e3d6000fd5b50505050506040513d601f19601f820116820180604052508101906116079190611e58565b949350505050565b6113888210611659576103e881600019028161162757fe5b05600f858154811061163557fe5b6000918252602080832087845260049283020160030190526040909120015561168b565b6103e88105600f858154811061166b57fe5b600091825260208083208784526004928302016003019052604090912001555b600f848154811061169857fe5b9060005260206000209060040201600301600084815260200190815260200160002060040154600f85815481106116cb57fe5b600091825260209091206002600490920201018054909101905550505050565b3b90565b60006108b56117c8565b6000828180805b83518110156117af57603084828151811061171757fe5b016020015160f81c108015906117415750603984828151811061173657fe5b016020015160f81c11155b1561178557811561175e5785611756576117af565b600019909501945b600a83029250603084828151811061177257fe5b016020015160f81c0392909201916117a7565b83818151811061179157fe5b60209101015160f81c602e14156117a757600191505b600101611700565b5084156117bf5784600a0a820291505b50949350505050565b6000806117e8731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed6116eb565b111561184757600180546001600160a01b031916731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed17905560408051808201909152600b81526a195d1a17db585a5b9b995d60aa1b602082015261183f90611c06565b506001610797565b600061186673c03a2615d5efaf5f49f60b7bb6583eaec212fdf16116eb565b11156118be57600180546001600160a01b03191673c03a2615d5efaf5f49f60b7bb6583eaec212fdf117905560408051808201909152600c81526b6574685f726f707374656e3360a01b602082015261183f90611c06565b60006118dd73b7a07bcf2ba2f2703b24c0691b5278999c59ac7e6116eb565b111561193257600180546001600160a01b03191673b7a07bcf2ba2f2703b24c0691b5278999c59ac7e17905560408051808201909152600981526832ba342fb5b7bb30b760b91b602082015261183f90611c06565b600061195173146500cfd35b22e4a392fe0adc06de1a1368ed486116eb565b11156119a857600180546001600160a01b03191673146500cfd35b22e4a392fe0adc06de1a1368ed4817905560408051808201909152600b81526a6574685f72696e6b65627960a81b602082015261183f90611c06565b60006119c773a2998efd205fb9d4b4963afb70778d6354ad3a416116eb565b1115611a1d57600180546001600160a01b03191673a2998efd205fb9d4b4963afb70778d6354ad3a4117905560408051808201909152600a8152696574685f676f65726c6960b01b602082015261183f90611c06565b6000611a3c7390a0f94702c9630036fb9846b52bf31a1c991a846116eb565b1115611a9357600180546001600160a01b0319167390a0f94702c9630036fb9846b52bf31a1c991a8417905560408051808201909152600b81526a189cd8d7db585a5b9b995d60aa1b602082015261183f90611c06565b6000611ab273816ec2af1b56183f82f8c05759e99fec3c3de6096116eb565b1115611b0d57600180546001600160a01b03191673816ec2af1b56183f82f8c05759e99fec3c3de60917905560408051808201909152600f81526e1c1bdb1e59dbdb97db585a5b9b995d608a1b602082015261183f90611c06565b6000611b2c736f485c8bf6fc43ea212e93bbf8ce046c7f1cb4756116eb565b1115611b5e5750600180546001600160a01b031916736f485c8bf6fc43ea212e93bbf8ce046c7f1cb475178155610797565b6000611b7d7320e12a1f859b3feae5fb2a0a32c18f5a65555bbf6116eb565b1115611baf5750600180546001600160a01b0319167320e12a1f859b3feae5fb2a0a32c18f5a65555bbf178155610797565b6000611bce7351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa6116eb565b1115611c005750600180546001600160a01b0319167351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa178155610797565b50600090565b8051611c19906002906020840190611c1d565b5050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611c5e57805160ff1916838001178555611c8b565b82800160010185558215611c8b579182015b82811115611c8b578251825591602001919060010190611c70565b50611c97929150611cfd565b5090565b6040518060a001604052806060815260200160006001600160a01b031681526020016000815260200160008152602001600081525090565b604051806060016040528060006001600160a01b0316815260200160008152602001600081525090565b5b80821115611c975760008155600101611cfe565b600082601f830112611d22578081fd5b813567ffffffffffffffff80821115611d39578283fd5b604051601f8301601f191681016020018281118282101715611d59578485fd5b604052828152925082848301602001861015611d7457600080fd5b8260208601602083013760006020848301015250505092915050565b600060208284031215611da1578081fd5b8135611dac81612257565b9392505050565b600060208284031215611dc4578081fd5b8151611dac81612257565b60008060008060808587031215611de4578283fd5b8435611def81612257565b9350602085013567ffffffffffffffff811115611e0a578384fd5b611e1687828801611d12565b949794965050505060408301359260600135919050565b60008060408385031215611e3f578182fd5b8235611e4a81612257565b946020939093013593505050565b600060208284031215611e69578081fd5b5051919050565b60008060408385031215611e82578182fd5b82359150602083013567ffffffffffffffff811115611e9f578182fd5b611eab85828601611d12565b9150509250929050565b600080600060608486031215611ec9578283fd5b83359250602084013567ffffffffffffffff80821115611ee7578384fd5b611ef387838801611d12565b93506040860135915080821115611f08578283fd5b50611f1586828701611d12565b9150509250925092565b60008060408385031215611f31578182fd5b823567ffffffffffffffff80821115611f48578384fd5b611f5486838701611d12565b93506020850135915080821115611f69578283fd5b50611eab85828601611d12565b600060208284031215611f87578081fd5b5035919050565b60008151808452611fa6816020860160208601612227565b601f01601f19169290920160200192915050565b60008251611fcc818460208701612227565b9190910192915050565b6001600160a01b0391909116815260200190565b6001600160a01b039390931683526020830191909152604082015260600190565b90815260200190565b60008482526060602083015261202d6060830185611f8e565b828103604084015261203f8185611f8e565b9695505050505050565b600060208252611dac6020830184611f8e565b600060a0825261206f60a0830188611f8e565b6001600160a01b039690961660208301525060408101939093526060830191909152608090910152919050565b6020808252604a908201527f50726f7661626c6520717565727920776173204e4f542073656e742c706c656160408201527f73652061646420736f6d652045544820746f20636f76657220666f72207468656060820152692071756572792066656560b01b608082015260a00190565b6020808252601a908201527f7468652061646472657373207761732072656769737465726564000000000000604082015260600190565b6020808252601c908201527f74686973206d65737361676520686173206265656e2073746f72656400000000604082015260600190565b60208082526035908201527f50726f7661626c65207175657279207761732073656e742c7374616e64696e6760408201527410313c903337b9103a34329030b739bbb2b917171760591b606082015260800190565b600060208252825160a060208401526121eb60c0840182611f8e565b905060018060a01b0360208501511660408401526040840151606084015260608401516080840152608084015160a08401528091505092915050565b60005b8381101561224257818101518382015260200161222a565b83811115612251576000848401525b50505050565b6001600160a01b038116811461226c57600080fd5b5056fe6a736f6e2868747470733a2f2f676174657761792e697066732e696f2f697066732fa2646970667358221220e8e9f02780ca2af116ca9f206a4b72a9ca477c37f003dca4f578c0fb0a06775f64736f6c634300060c0033";

    public static final String FUNC___callback = "__callback";

    public static final String FUNC_ADDMEMBER = "addMember";

    public static final String FUNC_ADDMESSAGE = "addMessage";

    public static final String FUNC_FETCHMESSAGEVIAPROVABLE = "fetchMessageViaProvable";

    public static final String FUNC_GETEMOTIONVALUE = "getEmotionValue";

    public static final String FUNC_GETMEMBERREPUTATIONVALUE = "getMemberReputationValue";

    public static final String FUNC_GETMESSAGE = "getMessage";

    public static final String FUNC_GETRUMORVALUE = "getRumorValue";

    public static final String FUNC_GETSENDERADDRESS = "getSenderAddress";

    public static final String FUNC_MEMBERARRAY = "memberArray";

    public static final String FUNC_NEWMESSAGE = "newMessage";

    public static final Event LOGGETMESSAGE_EVENT = new Event("LogGetMessage", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Message>() {}));
    ;

    public static final Event LOGIPFSUPDATE_EVENT = new Event("LogIpfsUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event LOGNEWPROVABLEQUERY_EVENT = new Event("LogNewProvableQuery", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event LOGSENDADDRESSUPDATE_EVENT = new Event("LogSendAddressUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected Test0906(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test0906(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test0906(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test0906(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<LogGetMessageEventResponse> getLogGetMessageEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGGETMESSAGE_EVENT, transactionReceipt);
        ArrayList<LogGetMessageEventResponse> responses = new ArrayList<LogGetMessageEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogGetMessageEventResponse typedResponse = new LogGetMessageEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._message = (Message) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogGetMessageEventResponse> logGetMessageEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogGetMessageEventResponse>() {
            @Override
            public LogGetMessageEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGGETMESSAGE_EVENT, log);
                LogGetMessageEventResponse typedResponse = new LogGetMessageEventResponse();
                typedResponse.log = log;
                typedResponse._message = (Message) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<LogGetMessageEventResponse> logGetMessageEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGGETMESSAGE_EVENT));
        return logGetMessageEventFlowable(filter);
    }

    public List<LogIpfsUpdateEventResponse> getLogIpfsUpdateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGIPFSUPDATE_EVENT, transactionReceipt);
        ArrayList<LogIpfsUpdateEventResponse> responses = new ArrayList<LogIpfsUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogIpfsUpdateEventResponse typedResponse = new LogIpfsUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogIpfsUpdateEventResponse> logIpfsUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogIpfsUpdateEventResponse>() {
            @Override
            public LogIpfsUpdateEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGIPFSUPDATE_EVENT, log);
                LogIpfsUpdateEventResponse typedResponse = new LogIpfsUpdateEventResponse();
                typedResponse.log = log;
                typedResponse.ipfsHash = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogIpfsUpdateEventResponse> logIpfsUpdateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGIPFSUPDATE_EVENT));
        return logIpfsUpdateEventFlowable(filter);
    }

    public List<LogNewProvableQueryEventResponse> getLogNewProvableQueryEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGNEWPROVABLEQUERY_EVENT, transactionReceipt);
        ArrayList<LogNewProvableQueryEventResponse> responses = new ArrayList<LogNewProvableQueryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogNewProvableQueryEventResponse typedResponse = new LogNewProvableQueryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._description = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogNewProvableQueryEventResponse> logNewProvableQueryEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogNewProvableQueryEventResponse>() {
            @Override
            public LogNewProvableQueryEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGNEWPROVABLEQUERY_EVENT, log);
                LogNewProvableQueryEventResponse typedResponse = new LogNewProvableQueryEventResponse();
                typedResponse.log = log;
                typedResponse._description = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogNewProvableQueryEventResponse> logNewProvableQueryEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGNEWPROVABLEQUERY_EVENT));
        return logNewProvableQueryEventFlowable(filter);
    }

    public List<LogSendAddressUpdateEventResponse> getLogSendAddressUpdateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGSENDADDRESSUPDATE_EVENT, transactionReceipt);
        ArrayList<LogSendAddressUpdateEventResponse> responses = new ArrayList<LogSendAddressUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogSendAddressUpdateEventResponse typedResponse = new LogSendAddressUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.senderAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogSendAddressUpdateEventResponse> logSendAddressUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LogSendAddressUpdateEventResponse>() {
            @Override
            public LogSendAddressUpdateEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGSENDADDRESSUPDATE_EVENT, log);
                LogSendAddressUpdateEventResponse typedResponse = new LogSendAddressUpdateEventResponse();
                typedResponse.log = log;
                typedResponse.senderAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogSendAddressUpdateEventResponse> logSendAddressUpdateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGSENDADDRESSUPDATE_EVENT));
        return logSendAddressUpdateEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> __callback(byte[] _myid, String _result) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC___callback, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_myid), 
                new org.web3j.abi.datatypes.Utf8String(_result)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> __callback(byte[] _myid, String _result, byte[] _proof) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC___callback, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_myid), 
                new org.web3j.abi.datatypes.Utf8String(_result), 
                new org.web3j.abi.datatypes.DynamicBytes(_proof)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addMember(String tempAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDMEMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tempAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addMessage(String memberAddress, String ipfs, BigInteger tempRumorValue, BigInteger tempEmotionValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, memberAddress), 
                new org.web3j.abi.datatypes.Utf8String(ipfs), 
                new org.web3j.abi.datatypes.generated.Uint256(tempRumorValue), 
                new org.web3j.abi.datatypes.generated.Uint256(tempEmotionValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> fetchMessageViaProvable(String ipfs, String dataType) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FETCHMESSAGEVIAPROVABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(ipfs), 
                new org.web3j.abi.datatypes.Utf8String(dataType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getEmotionValue() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETEMOTIONVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getMemberReputationValue(String memberAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMEMBERREPUTATIONVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, memberAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Message> getMessage(String memberAddress, BigInteger indexMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, memberAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(indexMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Message>() {}));
        return executeRemoteCallSingleValueReturn(function, Message.class);
    }

    public RemoteFunctionCall<BigInteger> getRumorValue() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRUMORVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getSenderAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSENDERADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>> memberArray(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MEMBERARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}));
        return new RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>> newMessage() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NEWMESSAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    @Deprecated
    public static Test0906 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test0906(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test0906 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test0906(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test0906 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test0906(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test0906 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test0906(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test0906> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test0906.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Test0906> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test0906.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test0906> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test0906.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test0906> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test0906.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Message extends DynamicStruct {
        public String ipfsHash;

        public String senderAddress;

        public BigInteger rumorValue;

        public BigInteger emotionValue;

        public BigInteger changeValue;

        public Message(String ipfsHash, String senderAddress, BigInteger rumorValue, BigInteger emotionValue, BigInteger changeValue) {
            super(new org.web3j.abi.datatypes.Utf8String(ipfsHash),new org.web3j.abi.datatypes.Address(senderAddress),new org.web3j.abi.datatypes.generated.Uint256(rumorValue),new org.web3j.abi.datatypes.generated.Uint256(emotionValue),new org.web3j.abi.datatypes.generated.Int256(changeValue));
            this.ipfsHash = ipfsHash;
            this.senderAddress = senderAddress;
            this.rumorValue = rumorValue;
            this.emotionValue = emotionValue;
            this.changeValue = changeValue;
        }

        public Message(Utf8String ipfsHash, Address senderAddress, Uint256 rumorValue, Uint256 emotionValue, Int256 changeValue) {
            super(ipfsHash,senderAddress,rumorValue,emotionValue,changeValue);
            this.ipfsHash = ipfsHash.getValue();
            this.senderAddress = senderAddress.getValue();
            this.rumorValue = rumorValue.getValue();
            this.emotionValue = emotionValue.getValue();
            this.changeValue = changeValue.getValue();
        }
    }

    public static class LogGetMessageEventResponse extends BaseEventResponse {
        public Message _message;
    }

    public static class LogIpfsUpdateEventResponse extends BaseEventResponse {
        public String ipfsHash;
    }

    public static class LogNewProvableQueryEventResponse extends BaseEventResponse {
        public String _description;
    }

    public static class LogSendAddressUpdateEventResponse extends BaseEventResponse {
        public String senderAddress;
    }
}
