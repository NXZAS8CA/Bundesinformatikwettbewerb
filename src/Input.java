import java.io.*;

public class Input {

    private static String[] Reihenarray;
    private static int Reihelength;



    public Input(String s) {

    }

    public static void main(String[] args) throws IOException {

        File file = new File("Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String AnzahlSchueler = br.readLine();
        int AnzahlGeschenke = Integer.parseInt(AnzahlSchueler);
        String[][] Tabellenarray = new String[AnzahlGeschenke][3];


        for(int i = 1; i <= AnzahlGeschenke; i ++){
            String Reihe = br.readLine();
            Reihenarray = Reihe.split("\\s+");
            int length = Reihenarray.length;

            for(int x = 0; x <length; x++){K
                Tabellenarray[i-1][x] =  Reihenarray[x];
            }
        }
        System.out.println(Tabellenarray[0][0]);

    }
}



