import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleCalc {

    public static void main(String[] args) throws IOException {
        new SimpleCalc().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        decompose(a);
        br.close();
    }

    static int decompose(int n) {
        int[] steps = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int min = n;
            if (i % 2 == 0) {
                min = Math.min(min, steps[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, steps[i / 3]);
            }
            min = Math.min(min, steps[i - 1]);
            steps[i] = min + 1;
        }

        int k = n;
        List<Integer> results = new ArrayList<>();
        results.add(k);

        while (k > 1) {
            if (k % 3 == 0 && steps[k / 3] + 1 == steps[k]) {
                k = k / 3;
                results.add(k);
            } else if (k % 2 == 0 && steps[k / 2] + 1 == steps[k]) {
                k = k / 2;
                results.add(k);
            } else {
                k = k - 1;
                results.add(k);
            }
        }

        System.out.println(results.size() - 1);
        Collections.reverse(results);
        String str = results.toString();
        str = str.replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
        System.out.println(str);
        return (steps[n]);
    }

}