import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Extendprocessing extends Processing {

    static long[][] Geschenkezaehler;
    public static List<Integer> IndexOfMultipleNumbers;
    public static long[] vergebeneZahlen;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.NumberGifts + 1][3];
    }

    public static long[][] countNumbers() {//Zählt die Anzahl der Geschenke in einer Spalte vom Tabellenarray.
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
        int index = 0;
        for (int i = 0; i < Input.Tabellenarray.length; i++) {
            if (Input.Tabellenarray[i][spalte] == input) {
                index = i;
            }
        }
        return index;
    }

    public static void getIndexofMultipleNumbers(int input, int spalte) {//Returnt die Indize von Zahlen die mehrfach in einer Spalte vorkommen.
        IndexOfMultipleNumbers = new ArrayList<>();
        for (int i = 0; i < Input.Tabellenarray.length; i++) {
            if (Input.Tabellenarray[i][spalte] == input) {
                IndexOfMultipleNumbers.add(i);
            }
        }
    }

    public static int getHighestNumberofGifts(int input) {//TODO: Weiß nicht mehr was diese Funktion kann...Wird wahrscheinlich nicht mehr benötigt.
        int Number = 0;
        for (int i = 0; i < Geschenkezaehler.length; i++) {
            if (Geschenkezaehler[i][input] > Number) {
                Number = (int) Geschenkezaehler[i][input];
            }
        }
        return Number;
    }

    public static int getHighestCountofFirstWishes() {//Zählt die Maximale Anzahl an ersten Wünschen die erfüllt werden können
        int counter = 0;
        for (int i = 0; i < Geschenkezaehler.length; i++) {
            if (Geschenkezaehler[i][0] >= 1) {
                counter++;
            }
        }
        return counter;
    }

    /*public static int getScoreofWishes(int Input, int Durchgang){//TODO: Muss noch abgeändert werden...//Zählt die Anzahl an Wünschen(Input) die erfüllt wurde im angegebenen Durchgang.
        int counter = 0;
        for(int i = 0; i < Processing.Wunscharray.length; i++){
            if(Wunscharray[i][Durchgang] == Input){
                counter++;
            }
        }
        return counter;
    }*/


    public static void getBestDistribution(List<int[]> Input) {
        int[] größter = Input.get((Input.size() - 1));
        int iAnzahlGrößter = 0;
        int iAnzahl = 0;
        for (int i = 0; i < größter.length; i++) {
            if (größter[i] == 1) {
                iAnzahlGrößter++;
            }
        }
        System.out.println(iAnzahlGrößter);
        for (int i = 2; i < Input.size(); i++) {
            int[] zwischen = Input.get(Input.size() - i);
            for (int f = 0; f < zwischen.length; f++) {
                if (zwischen[f] == 1) {
                    iAnzahl++;
                }
            }
            if (iAnzahl < iAnzahlGrößter) {
                Input.remove(Input.size() - i);
            }

        }
        Debug.printArraylits_Array(Input);
    }


}
