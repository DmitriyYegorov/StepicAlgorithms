import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        new BinarySearch().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numberList = str.split("\\s+");
        int a = Integer.parseInt(numberList[0]);
        int[] forSearch = new int[a];

        for (int i = 0; i < a; i++) {
            forSearch[i] = Integer.parseInt(numberList[i]);
        }

        str = br.readLine();
        numberList = str.split("\\s+");
        int b = Integer.parseInt(numberList[0]);
        int[] required = new int[b];

        for (int i = 0; i < b; i++) {
            required[i] = Integer.parseInt(numberList[i + 1]);
        }
        search(forSearch, required, b);
        br.close();
    }

    public void search(int[] forSearch, int[] required, int b) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < b; i++) {
            int start = 0;
            int end = forSearch.length - 1;

            while (end >= start) {
                int position = (start + end) / 2;

                if (required[i] == forSearch[position]) {
                    builder.append(position + 1 + " ");
                    break;
                } else if (required[i] < forSearch[position]) {
                    end = position - 1;
                } else if (required[i] > forSearch[position]) {
                    start = position + 1;
                }
            }
            if (end < start) {
                builder.append(-1 + " ");
            }
        }
        System.out.println(builder.toString().substring(0, builder.toString().length() - 1));
    }
}
