package PRCO304HK.ANDYLAM;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Collection;

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
public class Voting_sol_Voting extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916331790556103dc806100326000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638259d5531161005b5780638259d553146101165780639ef1204c14610129578063a1adbb251461013c578063e8685ba11461014f57600080fd5b806319e6e1581461008d57806335b8e820146100b35780633ce31e76146100f957806365fc783c1461010e575b600080fd5b6100a061009b36600461033c565b610157565b6040519081526020015b60405180910390f35b6100de6100c136600461033c565b600081815260036020526040902080546001909101549192909190565b604080519384526020840192909252908201526060016100aa565b61010c610107366004610354565b6101a6565b005b6002546100a0565b61010c61012436600461033c565b6101d5565b61010c61013736600461031b565b610207565b61010c61014a36600461031b565b61026e565b6001546100a0565b600080805b60025481101561019f5760008181526004602052604090206001015484141561018d57816101898161037f565b9250505b806101978161037f565b91505061015c565b5092915050565b6000546001600160a01b031633146101bd57600080fd5b60009283526003602052604090922090815560010155565b6000546001600160a01b031633146101ec57600080fd5b6000908152600360205260409020600201805460ff19169055565b60008181526003602052604090206002015460ff1615156001141561026a5760028054600091826102378361037f565b90915550604080518082018252858152602080820186815260009485526004909152919092209151825551600190910155505b5050565b6000546001600160a01b0316331461028557600080fd5b60018054600091826102968361037f565b90915550604080516060810182528581526020808201868152600183850181815260008781526003855286902094518555915190840155516002909201805460ff19169215159290921790915590518281529192507fec542c373a064661ffef02d633752debf28f3e6c9f253680822d9ccf8b47aec6910160405180910390a1505050565b6000806040838503121561032d578182fd5b50508035926020909101359150565b60006020828403121561034d578081fd5b5035919050565b600080600060608486031215610368578081fd5b505081359360208301359350604090920135919050565b600060001982141561039f57634e487b7160e01b81526011600452602481fd5b506001019056fea264697066735822122018da58326470290f35aff47d1805f58910bbbb23398b592ecd1f9fce15ef645164736f6c63430008040033";

    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_DELETEPROPOSAL = "deleteProposal";

    public static final String FUNC_EDITPROPOSAL = "editProposal";

    public static final String FUNC_GETCANDIDATE = "getCandidate";

    public static final String FUNC_GETNUMOFCANDIDATES = "getNumOfCandidates";

    public static final String FUNC_GETNUMOFVOTERS = "getNumOfVoters";

    public static final String FUNC_TOTALVOTES = "totalVotes";

    public static final String FUNC_VOTE = "vote";

    public static final Event ADDEDCANDIDATE_EVENT = new Event("AddedCandidate", 
            Arrays.<TypeReference<?>>asList());
    ;

    @Deprecated
    protected Voting_sol_Voting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Voting_sol_Voting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Voting_sol_Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Voting_sol_Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddedCandidateEventResponse> getAddedCandidateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDEDCANDIDATE_EVENT, transactionReceipt);
        ArrayList<AddedCandidateEventResponse> responses = new ArrayList<AddedCandidateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedCandidateEventResponse typedResponse = new AddedCandidateEventResponse();
            Log log = eventValues.getLog();
            typedResponse.candidateID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddedCandidateEventResponse> addedCandidateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Collection.Function<Log, AddedCandidateEventResponse>() {
            @Override
            public AddedCandidateEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDEDCANDIDATE_EVENT, log);
                AddedCandidateEventResponse typedResponse = new AddedCandidateEventResponse();
                //typedResponse.log = log;
                typedResponse.candidateID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddedCandidateEventResponse> addedCandidateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDEDCANDIDATE_EVENT));
        return addedCandidateEventFlowable(filter);
    }

    public RemoteCall <TransactionReceipt> addCandidate(byte[] name, byte[] party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name), 
                new org.web3j.abi.datatypes.generated.Bytes32(party)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deleteProposal(BigInteger candidateID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETEPROPOSAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> editProposal(BigInteger candidateID, byte[] name, byte[] party) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EDITPROPOSAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateID), 
                new org.web3j.abi.datatypes.generated.Bytes32(name), 
                new org.web3j.abi.datatypes.generated.Bytes32(party)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, byte[], byte[]>> getCandidate(BigInteger candidateID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));

        return new RemoteCall<Tuple3<BigInteger, byte[], byte[]>>(
                new Callable<Tuple3<BigInteger, byte[], byte[]>>() {
                    @Override
                    public Tuple3<BigInteger, byte[], byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, byte[], byte[]>(
                                (BigInteger) results.get(0).getValue(),
                                (byte[]) results.get(1).getValue(),
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getNumOfCandidates() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMOFCANDIDATES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getNumOfVoters() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMOFVOTERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalVotes(BigInteger candidateID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> vote(byte[] uid, BigInteger candidateID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(uid), 
                new org.web3j.abi.datatypes.generated.Uint256(candidateID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting_sol_Voting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting_sol_Voting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Voting_sol_Voting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Voting_sol_Voting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Voting_sol_Voting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Voting_sol_Voting.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Voting_sol_Voting.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Voting_sol_Voting.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Voting_sol_Voting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Voting_sol_Voting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddedCandidateEventResponse extends Response {
        public BigInteger candidateID;
    }
}
