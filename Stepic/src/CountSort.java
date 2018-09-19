import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) throws IOException {
        new CountSort().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numberList = str.split("\\s+");

        int[] numbers = new int[a];
        for (int i = 0; i < a; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }

        str = Arrays.toString(search(numbers, a));
        str = str.substring(1, str.length() - 1).replaceAll(",", "");
        System.out.println(str);
        br.close();
    }

    public int[] search(int[] numbers, int a) {
        int[] b = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            b[numbers[i]] = b[numbers[i]] + 1;
        }

        for (int i = 1; i < 10; i++) {
            b[i] = b[i] + b[i - 1];
        }

        int[] c = new int[a];
        for (int j = a - 1; j >= 0; j--) {
            c[b[numbers[j]] - 1] = numbers[j];
            b[numbers[j]]--;
        }
        return c;
    }
}