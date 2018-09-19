import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) throws IOException {
        new QuickSort().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numberList = str.split("\\s+");
        int a = Integer.parseInt(numberList[0]);
        int b = Integer.parseInt(numberList[1]);
        int[] leftPoints = new int[a];
        int[] rightPoints = new int[a];

        for (int i = 0; i < a; i++) {
            str = br.readLine();
            numberList = str.split("\\s+");
            leftPoints[i] = Integer.parseInt(numberList[0]);
            rightPoints[i] = Integer.parseInt(numberList[1]);
        }

        str = br.readLine();
        numberList = str.split("\\s+");
        int[] points = new int[b];

        for (int i = 0; i < b; i++) {
            points[i] = Integer.parseInt(numberList[i]);
        }

        Arrays.sort(leftPoints);
        Arrays.sort(rightPoints);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < points.length; i++) {
            int x = findLeftElements(leftPoints, 0, a - 1, points[i]);
            int y = findRightElements(rightPoints, 0, a - 1, points[1]);
            builder.append(x - y + " ");
        }
        System.out.println(builder.toString().substring(0, builder.toString().length() - 1));
        br.close();
    }

    private int findLeftElements(int[] a, int l, int r, int point) {
        int position = 0;
        while (l <= r) {
            position = (r + l) / 2;
            if (point < a[position]) {
                r = position - 1;
            } else {
                l = position + 1;
            }
        }
        return r + 1;
    }

    private int findRightElements(int[] a, int l, int r, int point) {
        int position = 0;
        while (l <= r) {
            position = (r + l) / 2;
            if (point > a[position]) {
                l = position + 1;
            } else {
                r = position - 1;
            }
        }
        return r + 1;
    }
}
