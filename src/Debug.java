import java.util.List;
import java.lang.*;

public class Debug extends Processing {
    public static void main(String[] args) {

    }

    public static void printArray(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void printArrayofArray(long[][] input, int länge) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < länge; j++) {
                System.out.print(input[i][j]);
                System.out.print(" , ");
            }
            System.out.println("\n");
        }
    }

    public static void printArraylists_Array(List<int[]> input) {
        for (int i = 0; i < input.size(); i++) {
            int[] input2 = input.get(i);
            for (int f = 0; f < input2.length; f++) {
                System.out.print(input2[f]);
                System.out.print(",");

            }
            System.out.println();
        }
    }

    public static void printArrayList(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i));
            System.out.print(",");
        }
        System.out.println();

    }
}
