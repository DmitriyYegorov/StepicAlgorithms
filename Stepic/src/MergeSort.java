import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) throws IOException {
        new MergeSort().run();
    }

    private void run() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numberList = str.split("\\s+");
        int[] forSearch = new int[a];

        for (int i = 0; i < a; i++) {
            forSearch[i] = Integer.parseInt(numberList[i]);
        }

        forSearch = mergeSort(forSearch);

        System.out.println(count);
        br.close();
    }

    private int[] mergeSort(int[] a) {

        int x = a.length / 2;
        int[] left = new int[x];
        int[] right = new int[a.length - x];

        if (a.length == 1) {
            return a;
        } else {
            left = Arrays.copyOfRange(a, 0, x);
            right = Arrays.copyOfRange(a, x, a.length);

            left = mergeSort(left);
            right = mergeSort(right);
        }
        return merge(left, right);
    }

    long count = 0;

    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j == b.length || i < a.length && a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            } else {
                count += a.length - i;
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }
}
