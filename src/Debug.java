

public class Debug extends Processing {
    public static void main(long[][] input) {
        for(int i = 0; i< input.length; i++){
            for(int j = 0; j <=2; j++){
                System.out.print(input[i][j]);
                System.out.print(" , ");
            }
                System.out.println("\n");

        }
    }

    public static void printLongArray(long[] input){
        for(int i = 0; i< input.length; i++){
            System.out.print(input[i]);
        }

    }
}