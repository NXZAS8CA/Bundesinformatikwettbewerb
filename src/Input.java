import java.io.*;

public class Input extends Extendprocessing {


    private static String[] Reihenarray;
    public static long[][] WünscheAusTXT;
    public static int AnzahlGeschenke;
    public static String AnzahlSchüler;
    public static int AnzahlVerschiedenerWünsche = 3;


    public static void main() throws IOException {

        File file = new File("Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String AnzahlSchüler = br.readLine();
        AnzahlGeschenke = Integer.parseInt(AnzahlSchüler);
        WünscheAusTXT = new long[AnzahlGeschenke][AnzahlVerschiedenerWünsche];


        for(int i = 1; i <= AnzahlGeschenke; i ++){
            String Reihe = br.readLine();
            Reihenarray = Reihe.split("\\s+");
            int length = Reihenarray.length;

            for(int x = 0; x <length; x++){
                WünscheAusTXT[i-1][x] =  Long.parseLong(Reihenarray[x]);

            }
        }

    }


}



