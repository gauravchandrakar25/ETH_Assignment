import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main (String[] args) throws Exception{
        final Web3j client = Web3j.build(
                new HttpService(
                        "https://mainnet.infura.io/v3/a27f009cb6244f4e87673538fece0368"
                )
        );
        // enter any eth wallet address here
        final String ethAddress = "0x4C39931E077D93c1d4399928f142FcC770aD8a61";
        final EthGetBalance balanceResponse= client
                .ethGetBalance(ethAddress, DefaultBlockParameter.valueOf("latest")).sendAsync()
                .get(10, TimeUnit.SECONDS);

        final BigInteger unscaledBalance = balanceResponse.getBalance();
        System.out.println(unscaledBalance);

    }
}