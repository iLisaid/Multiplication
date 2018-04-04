import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int[] mas = MassivGenerator.newMas(".\\fileOut", 5);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Multiplier> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Multiplier mul = new Multiplier(i,mas);
            list.add(mul);
        }
        try {
            List<Future<BigInteger>> result = executorService.invokeAll(list);
            BigInteger total = BigInteger.ONE;
            for (Future<BigInteger> res : result) total = total.multiply(res.get());
            System.out.println(total);
            executorService.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}