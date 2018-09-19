import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs {

    public static void main(String[] args) throws IOException {
        new Stairs().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numbers = str.split("\\s");

        int[] steps = new int[a + 1];

        steps[0] = 0;

        for (int i = 1; i < steps.length; i++) {
            steps[i] = Integer.parseInt(numbers[i - 1]);
        }

        for (int i = 2; i < steps.length; i++) {
            steps[i] = steps[i] + max(steps[i - 1], steps[i - 2]);
        }
        System.out.println(steps[a]);
        br.close();
    }

    static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}
