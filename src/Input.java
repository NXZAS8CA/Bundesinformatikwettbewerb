import java.io.*;

public class Input extends sort{


    private static String[] Reihenarray;
    private static int Reihelength;
    public static String[][] Tabellenarray;
    public static int AnzahlGeschenke;


    public Input() {

    }



    public static void main() throws IOException {

        File file = new File("Test3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String AnzahlSchueler = br.readLine();
        AnzahlGeschenke = Integer.parseInt(AnzahlSchueler);
        Tabellenarray = new String[AnzahlGeschenke][3];


        for(int i = 1; i <= AnzahlGeschenke; i ++){
            String Reihe = br.readLine();
            Reihenarray = Reihe.split("\\s+");
            int length = Reihenarray.length;

            for(int x = 0; x <length; x++){
                Tabellenarray[i-1][x] =  Reihenarray[x];
            }
        }


    }
}



