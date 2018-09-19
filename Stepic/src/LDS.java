import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LDS {

    public static void main(String[] args) throws IOException {
        new LDS().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numberList = str.split("\\s+");

        int[] numbers = new int[a];
        for (int i = 0; i < a; i++) {
            numbers[i] = Integer.parseInt(numberList[i]);
        }

        LongestDecreasingSubsequence(numbers, a);
        br.close();
    }

    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] < key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static void LongestDecreasingSubsequence(int numbers[], int size) {
        int[] d = new int[size];
        int[] b = new int[size];
        int len = 1;
        d[0] = numbers[0];

        for (int i = 1; i < size; i++) {
            if (numbers[i] >= d[0]) {
                d[0] = numbers[i];
                b[0] = i;
            } else if (numbers[i] <= d[len - 1]) {
                b[len] = i;
                d[len++] = numbers[i];
            } else {
                int k = CeilIndex(numbers, -1, len - 1, numbers[i]);
                d[k] = numbers[i];
                b[k] = i;
            }
        }

        System.out.println(len);
        System.out.print((b[0] + 1) + " ");

        int i = 1;
        while (i < b.length - 1 && b[i] != 0) {
            System.out.print((b[i] + 1) + " ");
            i++;
        }
    }

}