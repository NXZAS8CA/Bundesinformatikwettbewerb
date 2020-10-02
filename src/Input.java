import java.io.*;

public class Input extends Preprocessing {


    private static String[] Reihenarray;
    public static long[][] Tabellenarray;
    public static int NumberGifts;



    public static void main() throws IOException {

        File file = new File("Test2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String NumberStudents = br.readLine();
        NumberGifts = Integer.parseInt(NumberStudents);
        Tabellenarray = new long[NumberGifts][3];


        for(int i = 1; i <= NumberGifts; i ++){
            String Reihe = br.readLine();
            Reihenarray = Reihe.split("\\s+");
            int length = Reihenarray.length;

            for(int x = 0; x <length; x++){
                Tabellenarray[i-1][x] =  Long.parseLong(Reihenarray[x]);

            }
        }

    }


}



