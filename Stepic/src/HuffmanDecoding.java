import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanDecoding {

    public static void main(String[] args) throws FileNotFoundException {
        new HuffmanDecoding().run();
    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        int totalFrequency = input.nextInt();
        String str = input.next();
        while (input.hasNext()) {
            str += input.nextLine() + " ";
        }

        String seeking = str.substring(str.length() - totalFrequency - 1, str.length() - 1);
        str = str.substring(0, str.length() - totalFrequency - 2);

        Map<Character, Integer> mainStr = new HashMap<>();
        for (int i = 0; i < str.length(); i += 2) {
            char x = str.charAt(i);
            int count = i + 3;
            while (str.substring(count, count + 1).equals("0") || str.substring(count, count + 1).equals("1")) {
                count++;
                if (count == str.length()) {
                    break;
                }
            }
            int y = Integer.parseInt(str.substring(i + 3, count));
            i = count - 1;
            mainStr.put(x, y);
        }

        String code = "";
        String s = "";
        for (int i = 0; i < seeking.length(); i++) {
            code += seeking.substring(i, i + 1);
            for (Map.Entry<Character, Integer> entry : mainStr.entrySet()) {
                if (Integer.parseInt(code) == entry.getValue()) {
                    s += entry.getKey();
                    code = "";
                    break;
                }
            }

        }
        System.out.println(s);
        input.close();
    }
}