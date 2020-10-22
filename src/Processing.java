import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

import java.util.List;

public class Processing {
    public static List<int[]> Wunscharray;
    public static List<int[]> Endergebnisarray;
    public static boolean Freigabe = true;
    public static int[] Zwischenspeicher;
    public static int[] endergebnis;
    public static int[] wunsch;

    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function
        Extendprocessing.countNumbers(); //returnt Geschenkezähler

        Wunscharray = new ArrayList<int[]>();
        Endergebnisarray = new ArrayList<int[]>();
        endergebnis = new int[Input.NumberGifts];
        wunsch = new int[Input.NumberGifts];
        Zwischenspeicher = new int[Input.NumberGifts];

        moveSingleNumbers(0);

        Zwischenspeicher = Wunscharray.get(0);
        System.out.println(Zwischenspeicher[0]);
        Debug.printArray(Zwischenspeicher);
        System.out.println();
        moveMultipleNumbers(0, Zwischenspeicher);
        Extendprocessing.getIndexofMultipleNumbers(4, 0);
        //System.out.println(Input.NumberGifts);
        Debug.printArraylits(Wunscharray);
        Zwischenspeicher = Wunscharray.get(0);
        System.out.println(Zwischenspeicher[0]);




    }

    public static void moveSingleNumbers(int spalte) {
        for (int i = 0; i < 10; i++) {
            endergebnis[i] = 0;
        }
        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] == 1) {
                int schüler = Extendprocessing.getIndexofSingleNumber(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                //Feste Verteilung für Wünsche über alle Versuche
                for (int f = 0; f < endergebnis.length; f++) {
                    if (endergebnis[f] == i) {
                        Freigabe = false;
                    }
                }
                if (Freigabe == true) {
                    endergebnis[schüler] = i;
                    wunsch[schüler] = (spalte + 1);

                }
            }
        }
        Wunscharray.add(wunsch);
        Endergebnisarray.add(endergebnis);

    }

    public static void moveMultipleNumbers(int spalte, int[] arr) {
        int[] arr2 = new int[arr.length];
        for(int f = 0; f < arr.length; f++){
            arr2[f] = arr[f];
        }
        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] > 1) {
                Extendprocessing.getIndexofMultipleNumbers(i, spalte);
                for(int f = 0; f < 2; f++){
                    for(int d = 0; d < arr.length; d++){
                        arr2[d] = arr[d];
                    }
                    int zw = Extendprocessing.IndexOfMultipleNumbers[f];
                    System.out.println(zw);
                    arr2[zw] = 1;
                    Wunscharray.add(arr2);

                }
            }
        }


    }
}
