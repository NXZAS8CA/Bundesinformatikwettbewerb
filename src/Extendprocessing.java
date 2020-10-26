import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Extendprocessing extends Processing {

    static long[][] Geschenkezaehler;
    public static List<Integer> IndexOfMultipleNumbers;
    public static long[] vergebeneZahlen;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.NumberGifts +1][3];
        IndexOfMultipleNumbers = new ArrayList<>();
    }
    public static long[][] countNumbers(){//Zählt die Anzahl der Geschenke in einer Spalte vom Tabellenarray.
        for(int i = 1; i <= Input.NumberGifts; i++){
            for(int y= 0; y < 3; y++) {
                for (int j = 0; j < Input.Tabellenarray.length; j++) {
                    if (i == Input.Tabellenarray[j][y]) {
                        Geschenkezaehler[i][y]++;
                    }
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofSingleNumber(int input, int spalte){//Geht nur für Zahlen die einmal in ihrer Spalte vorkommen
        int index = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                index = i;
            }
        }
        return index;
    }

    public static void getIndexofMultipleNumbers(int input, int spalte){//Returnt die Indize von Zahlen die mehrfach in einer Spalte vorkommen.
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                IndexOfMultipleNumbers.add(i);
            }
        }
    }

    public static int getHighestNumberofGifts(int input){//TODO: Weiß nicht mehr was diese Funktion kann...Wird wahrscheinlich nicht mehr benötigt.
        int Number = 0;
        for (int i = 0; i < Geschenkezaehler.length; i++){
            if(Geschenkezaehler[i][input] > Number){
                Number = (int) Geschenkezaehler[i][input];
            }
        }
        return Number;
    }

    public static int getHighestCountofFirstWishes(){//Zählt die Maximale Anzahl an ersten Wünschen die erfüllt werden können
        int counter = 0;
        for(int i= 0; i < Geschenkezaehler.length; i++){
            if(Geschenkezaehler[i][0] >= 1){
                counter ++;
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



    public static int[] getBestDistribution(){
        int zwischenzaehler = 0;
        int counter = 0;
        int[] best = new int[Input.NumberGifts];
        for(int i = 0; i < Processing.Wunscharray.size(); i++) {
            zwischenzaehler = 0;
            for (int j = 0; j < Processing.Wunscharray.get(i).length; j++) {
                if (Processing.Wunscharray.get(i)[j] == 1) {
                    zwischenzaehler++;
                }
            }
            if (zwischenzaehler > counter) {
                counter = zwischenzaehler;
                best = Processing.Wunscharray.get(i);

            }
        }
        return best;

    }





}
