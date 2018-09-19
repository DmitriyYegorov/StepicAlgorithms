import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {

    public static void main(String[] args) throws IOException {
        new LIS().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numberList = str.split("\\s+");

        int[] numbers = new int[a];
        int[] d = new int[a];
        for (int i = 0; i < a; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }

        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (numbers[j] >= numbers[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= d.length - 1; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        System.out.println(max + 1);
        br.close();
    }

}
