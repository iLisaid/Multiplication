import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Multiplier implements Callable<BigInteger>{
    int threadNum;
    int[] array;

    public Multiplier(int threadNum, int[] array){
        this.threadNum = threadNum;
        this.array = array;
    }
    @Override
    public BigInteger call() throws Exception {
        BigInteger result = BigInteger.ONE;
        for(int i = threadNum*10000; i < (threadNum+1)*10000; i++){
            result = result.multiply(BigInteger.valueOf(array[i]));
        }
        return result;
    }
}
