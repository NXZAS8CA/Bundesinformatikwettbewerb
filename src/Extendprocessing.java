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
        System.out.println("getIndexofSingleNumber wird ausgeführt...");
        int index = 0;
        for (int i = 0; i < Input.Tabellenarray.length; i++) {
            if (Input.Tabellenarray[i][spalte] == input) {
                index = i;
            }
        }
        return index;
    }

    public static void getIndexofMultipleNumbers(int input, int spalte) {//Returnt die Indize von Zahlen die mehrfach in einer Spalte vorkommen.
        System.out.println("getIndexofMultipleNumbers wird ausgeführt...");
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

    public static void vergebeGeschenke(List<int[]> input) {//TODO: muss wahrscheinlich nochmal angepasst werden, besonders seine Benutzung.....
        System.out.println("vergebeGeschenke wird ausgeführt...");
        for (int i = 0; i < input.size(); i++) {//TODO: die Funktion sollte eher jedes mal in der Verteilung ausgeführt werden, damit man unterschiedlich Zahlen vergeben kann in der Verteilung und nicht nach der Verteilung
            int[] array = input.get(i);
            int[] output = new int[array.length];

            for (int j = 0; j < array.length; j++) {

                if (array[j] == 1) {
                    output[j] = (int) Input.Tabellenarray[j][0];
                } else if (array[j] == 2) {
                    output[j] = (int) Input.Tabellenarray[j][1];
                } else if (array[j] == 3) {
                    output[j] = (int) Input.Tabellenarray[j][2];
                }


                if (Vergeben.contains((int) Input.Tabellenarray[j][0]) == false) {
                    Vergeben.add((int) Input.Tabellenarray[j][0]);

                }

            }
            Endergebnisarray.add(output);


        }
        Endergebnisarray.remove(0);

    }


    public static void verteileLetzteWünsche(List<int[]> input) {
        System.out.println("verteileLetzeWünsche wird ausgeführt...");
        for (int i = 0; i < Input.NumberGifts; i++) {
            if (Vergeben.contains(i) == false) {
                //TODO: Es soll am Ende durch das Endergebnis gegangen und geschaut werden, welcher Schüler keinen seiner drei Wünsche erfüllt bekommen hat und diesem wird ein übrig gebliebenes Geschenk zugeteilt.

            }


        }


    }


}
