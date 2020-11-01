import java.io.*;

public class Input extends Extendprocessing {


    private static String[] Reihenarray;
    public static long[][] Tabellenarray;
    public static int NumberGifts;
    public static String NumberStudents;
    public static int AnzahlVerschiedenerWünsche = 3;


    public static void main() throws IOException {

        File file = new File("Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String NumberStudents = br.readLine();
        NumberGifts = Integer.parseInt(NumberStudents);
        Tabellenarray = new long[NumberGifts][AnzahlVerschiedenerWünsche];


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



