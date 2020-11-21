import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extendprocessing extends Processing {

    static long[][] Geschenkezaehler;
    public static List<Integer> IndexOfMultipleNumbers;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.AnzahlGeschenke + 1][3];
    }

    public static long[][] countNumbers() {//Zählt die Anzahl der Geschenke in einer Spalte vom Tabellenarray.
        System.out.println("countNumbers wird ausgeführt...");

        for (int i = 1; i <= Input.AnzahlGeschenke; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < Input.WünscheAusTXT.length; k++) {
                    if (i == Input.WünscheAusTXT[k][j]) {
                        Geschenkezaehler[i][j]++;
                    }
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofSingleNumber(int input, int spalte) {//Geht nur für Zahlen die einmal in ihrer Spalte vorkommen
        //System.out.println("getIndexofSingleNumber wird ausgeführt...");
        int index = 0;
        for (int i = 0; i < Input.WünscheAusTXT.length; i++) {
            if (Input.WünscheAusTXT[i][spalte] == input) {
                index = i;
            }
        }
        return index;
    }

    public static void getIndexofMultipleNumbers(int input, int spalte) {//Returnt die Indize von Zahlen die mehrfach in einer Spalte vorkommen.
        //System.out.println("getIndexofMultipleNumbers wird ausgeführt...");
        IndexOfMultipleNumbers = new ArrayList<>();
        for (int i = 0; i < Input.WünscheAusTXT.length; i++) {
            if (Input.WünscheAusTXT[i][spalte] == input) {
                IndexOfMultipleNumbers.add(i);
            }
        }
    }

    public static void getBestDistribution(List<int[]> Input, int wunsch) {
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
            for (int j = 0; j < zwischen.length; j++) {
                if (zwischen[j] == wunsch) {
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

    public static void Geschenkvergabe(List<int[]> input) {
        for (int i = 0; i < input.size(); i++) {
            int[] zw1 = input.get(i);
            int[] zw = new int[zw1.length];
            for (int j = 0; j < zw1.length; j++) {
                zw[j] = zw1[j];
            }
            //für die länge des copierten arrays
            for (int j = 0; j < zw.length; j++) {
                if (zw[j] == 1) {
                    int geschenk = (int) Input.WünscheAusTXT[j][0];
                    if (Vergeben.contains(geschenk) == false) {
                        Vergeben.add(geschenk);
                    }
                } else if (zw[j] == 2) {
                    int geschenk = (int) Input.WünscheAusTXT[j][1];
                    if (Vergeben.contains(geschenk) == false) {
                        Vergeben.add(geschenk);
                    }
                } else if (zw[j] == 3) {
                    int geschenk = (int) Input.WünscheAusTXT[j][2];
                    if (Vergeben.contains(geschenk) == false) {
                        Vergeben.add(geschenk);
                    }
                }
            }
        }

    }

    public static void schonVorhanden(int[] input) {
        int[] array1 = new int[input.length];
        int[] array2 = new int[input.length];
        Processing.Freigabe = true;
        for (int i = 0; i < input.length; i++) {
            array1[i] = input[i];
        }
        for (int j = 0; j < Wunscharray.size(); j++) {
            int[] zw = Wunscharray.get(j);
            for (int k = 0; k < zw.length; k++) {
                array2[k] = zw[k];
            }
            if (Arrays.equals(array1, array2) == true) {
                Processing.Freigabe = false;
            }
        }
    }
}
