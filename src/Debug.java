

public class Debug extends Processing {
    public static void main(String[] args) {

    }
    public static void printArray(long[] input){
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

}
