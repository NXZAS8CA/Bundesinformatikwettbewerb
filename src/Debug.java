import java.util.ArrayList;
import java.util.List;

public class Debug extends Processing {
    public static void main(String[] args) {

    }
    public static void printArray(int[] input){
        for(int i = 0; i< input.length; i++){
            System.out.print(input[i]);
        }
    }
    public static void printArraystring(String[] input){
        for(int i = 0; i< input.length; i++){
            System.out.print(input[i]);
        }
    }
    public static void printArrayofArray(long[][] input, int länge){
        for(int i = 0; i< input.length; i++){
            for(int j = 0; j <länge; j++){
                System.out.print(input[i][j]);
                System.out.print(" , ");
            }
            System.out.println("\n");
        }
    }
    public static void printArraylits(List<int[]> input){
        int[] input2 = new int[Input.NumberGifts];

        for(int i = 0; i < input.size(); i++){
            input2 = input.get(i);
            for (int f = 0; f < input2.length; f++) {
                System.out.print(input2[f]);
                System.out.print(",");

            }
            System.out.println();
        }
    }

}
