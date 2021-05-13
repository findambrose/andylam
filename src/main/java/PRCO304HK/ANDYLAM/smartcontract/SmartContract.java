package PRCO304HK.ANDYLAM.smartcontract;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

@Service
public class SmartContract {

    Web3j web3;
    ContractGasProvider gasProvider;

    public String getContract(){
        web3 = Web3j.build(new HttpService());
        gasProvider = new DefaultGasProvider();
        return "Contract";
    }
}
