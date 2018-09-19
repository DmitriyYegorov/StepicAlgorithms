import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditingDistance {

    public static void main(String[] args) throws IOException {
        new EditingDistance().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        search(str1, str2);
        br.close();
    }

    public void search(String str1, String str2) {
        int a = str1.length() + 1;
        int b = str2.length() + 1;

        int[][] d = new int[a][b];

        for (int i = 0; i < a; i++) {
            d[i][0] = i;
        }

        for (int i = 0; i < b; i++) {
            d[0][i] = i;
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 && j == 0) {
                    d[i][j] = 0;
                } else if (i == 0) {
                    d[i][j] = j;
                } else if (j == 0) {
                    d[i][j] = i;
                } else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1),
                            d[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1));
                }
            }
        }
        System.out.println(d[a - 1][b - 1]);
    }
}
