import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MassivGenerator {
    public static int[] newMas(String fileOut, int maxValue){
        int[] mas = new int[100000];
        try {
            FileWriter writer = new FileWriter(fileOut);
            Random random = new Random(System.currentTimeMillis());
            for(int i = 0; i < 100000;i++) {
                mas[i] = random.nextInt(maxValue) + 1;
                writer.write(Integer.toString(mas[i]) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mas;
    }
}
