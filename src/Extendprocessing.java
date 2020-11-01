import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Extendprocessing extends Processing {

    static long[][] Geschenkezaehler;
    public static List<Integer> IndexOfMultipleNumbers;
    public static long[] vergebeneZahlen;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.NumberGifts + 1][3];
    }

    public static long[][] countNumbers() {//Zählt die Anzahl der Geschenke in einer Spalte vom Tabellenarray.
        System.out.println("countNumbers wird ausgeführt...");

        for (int i = 1; i <= Input.NumberGifts; i++) {
            for (int y = 0; y < 3; y++) {
                for (int j = 0; j < Input.Tabellenarray.length; j++) {
                    if (i == Input.Tabellenarray[j][y]) {
                        Geschenkezaehler[i][y]++;
                    }
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofSingleNumber(int input, int spalte) {//Geht nur für Zahlen die einmal in ihrer Spalte vorkommen
        //System.out.println("getIndexofSingleNumber wird ausgeführt...");
        int index = 0;
        for (int i = 0; i < Input.Tabellenarray.length; i++) {
            if (Input.Tabellenarray[i][spalte] == input) {
                index = i;
            }
        }
        return index;
    }

    public static void getIndexofMultipleNumbers(int input, int spalte) {//Returnt die Indize von Zahlen die mehrfach in einer Spalte vorkommen.
        //System.out.println("getIndexofMultipleNumbers wird ausgeführt...");
        IndexOfMultipleNumbers = new ArrayList<>();
        for (int i = 0; i < Input.Tabellenarray.length; i++) {
            if (Input.Tabellenarray[i][spalte] == input) {
                IndexOfMultipleNumbers.add(i);
            }
        }
    }

    public static void getBestDistribution(List<int[]> Input, int wunsch) {
        System.out.println("getBestDistribiution");
        System.out.println("getBestDistribution wird ausgeführt...");
        int[] größter = Input.get((Input.size() - 1));
        int inputsize = Input.size();
        int iAnzahlGrößter = 0;
        int iAnzahl = 0;
        for (int i = 0; i < größter.length; i++) {
            if (größter[i] == wunsch) {
                iAnzahlGrößter++;
            }
        }
        for (int i = 1; i <= inputsize; i++) {
            int[] zwischen = Input.get(inputsize - i);
            iAnzahl = 0;
            for (int f = 0; f < zwischen.length; f++) {
                if (zwischen[f] == wunsch) {
                    iAnzahl++;
                }
            }
            if (iAnzahl < iAnzahlGrößter) {
                Input.remove(inputsize - i);
            }

        }
        Wunscharray = new ArrayList<int[]>();
        for (int i = 0; i < Input.size(); i++) {
            int[] zw = Input.get(i);
            Wunscharray.add(zw);

        }
    }

    public static void vergebeGeschenke(List<int[]> input, int spalte) {//TODO: muss wahrscheinlich nochmal angepasst werden, besonders seine Benutzung.....
        System.out.println("vergebeGeschenke wird ausgeführt...");
        for (int i = 0; i < input.size(); i++) {//TODO: die Funktion sollte eher jedes mal in der Verteilung ausgeführt werden, damit man unterschiedlich Zahlen vergeben kann in der Verteilung und nicht nach der Verteilung
            int[] array = input.get(i);
            int[] output = new int[array.length];

            for (int j = 0; j < array.length; j++) {

                if (array[j] == 1) {
                    output[j] = (int) Input.Tabellenarray[j][spalte];
                }


                if (Vergeben.contains((int) Input.Tabellenarray[j][spalte]) == false) {
                    Vergeben.add((int) Input.Tabellenarray[j][spalte]);

                }

            }
            Endergebnisarray.add(output);


        }
        Endergebnisarray.remove(0);

    }

    public static void Geschenkvergabe(List<int[]> input) {
        //ein array copieren
        for(int i = 0; i < input.size(); i++){
            int[] zw1 = input.get(i);
            int[] zw = new int[zw1.length];
            for (int j = 0; j < zw1.length; j++) {
                zw[j] = zw1[j];
            }
            //für die länge des copierten arrays
            for (int j = 0; j < zw.length; j++) {
                if (zw[j] == 1) {
                    int geschenk = (int) Input.Tabellenarray[j][0];
                    if(Vergeben.contains(geschenk) == false){
                        Vergeben.add(geschenk);
                    }
                }
                else if (zw[j] == 2) {
                    int geschenk = (int) Input.Tabellenarray[j][1];
                    if(Vergeben.contains(geschenk) == false){
                        Vergeben.add(geschenk);
                    }
                }
                else if (zw[j] == 3) {
                    int geschenk = (int) Input.Tabellenarray[j][2];
                    if(Vergeben.contains(geschenk) == false){
                        Vergeben.add(geschenk);
                    }
                }
            }
        }

    }

    public static void aussortieren(List<int[]> input) {
        System.out.println("verteileLetzeWünsche wird ausgeführt...");

    }

    public static void schonVorhanden(int[] input){
        int[] array1 =new int[input.length];
        int[] array2 = new int[input.length];
        Processing.Freigabe = true;
        for(int j = 0; j < input.length; j++){
            array1[j] = input[j];
        }
        for(int i = 0; i< Wunscharray.size(); i++){
            int[] zw = Wunscharray.get(i);
            for(int j = 0; j < zw.length; j++){
                array2[j] = zw[j];
            }
            if(Arrays.equals(array1, array2) == true){
                Processing.Freigabe = false;
            }
        }
    }


}
