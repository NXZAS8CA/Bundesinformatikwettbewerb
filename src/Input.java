import java.io.*;
import java.util.Arrays;

public class Input {


    private static String[] Reihenarray;
    private static int Reihelength;



    public Input(String s) {

    }

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\NXZAS8CA\\Documents\\Coding\\Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String AnzahlSchueler = br.readLine();
        int AnzahlGeschenke = Integer.parseInt(AnzahlSchueler);
        String[][] Tabellenarray = new String[AnzahlGeschenke][3];


        for(int i = 1; i <= AnzahlGeschenke; i ++){
            String Reihe = br.readLine();
            Reihenarray = Reihe.split("\\s+");
            int length = Reihenarray.length;

            for(int x = 1; x <length; x++){
                Tabellenarray[i-1][x-1] =  Reihenarray[x];
            }
        }
        System.out.println(Tabellenarray[1][0]);





    }
}