import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack {

    public static void main(String[] args) throws IOException {
        new Knapsack().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numbers = str.split(" ");
        int W = Integer.parseInt(numbers[0]) + 1;
        int n = Integer.parseInt(numbers[1]) + 1;

        str = br.readLine();
        numbers = str.split(" ");

        int[] x = new int[numbers.length + 1];

        for (int i = 1; i < numbers.length + 1; i++) {
            x[i] = Integer.parseInt(numbers[i - 1]);
        }

        int[][] d = new int[W][n];

        for (int i = 1; i < n; i++) {
            for (int w = 1; w < W; w++) {
                d[w][i] = d[w][i - 1];
                if (x[i] <= w) {
                    d[w][i] = Math.max(d[w][i], d[w - x[i]][i - 1] + x[i]);
                }
            }
        }
        System.out.println(d[W - 1][n - 1]);
        br.close();
    }
}