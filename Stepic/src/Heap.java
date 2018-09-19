import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap {

    public static void main(String[] args) throws FileNotFoundException {
        new Heap().run();
    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Heap.txt"));
        int operationsAmount = input.nextInt();

        int x = 0;
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        for (int i = 0; i < operationsAmount; i++) {
            String str = input.next();
            if (str.equals("Insert")) {
                int a = input.nextInt();
                priority.add(a);
                x++;
            } else if (str.equals("ExtractMax")) {
                Integer[] b = new Integer[x];
                Integer[] c = priority.toArray(b);
                Arrays.sort(c);
                System.out.println(c[c.length - 1]);
            }
        }
        input.close();
    }
}
