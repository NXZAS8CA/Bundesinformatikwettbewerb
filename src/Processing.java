import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.Random;


public class Processing {
    public static List<int[]> Wunscharray;
    public static List<Integer> Vergeben;
    public static boolean Freigabe = true;

    public static int[] Zwischenspeicher;
    public static int[] endergebnis;
    public static int[] wunsch;
    public static int[] finaleWunschverteilung;

    public static int counter = 0;
    public static int anzahlErstervergebenerWünsche = 0;
    public static int anzahlZweitervergebenerWünsche = 0;
    public static int anzahlDrittervergebenerWünsche = 0;

    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function
        Extendprocessing.countNumbers(); //Geschenkezähler return
        int wunscharraylänge = 0;
        Wunscharray = new ArrayList<int[]>();
        endergebnis = new int[Input.AnzahlGeschenke];
        for (int i = 0; i < Input.AnzahlGeschenke; i++) {
            endergebnis[i] = 0;
        }
        Wunscharray.add(endergebnis);
        wunsch = new int[Input.AnzahlGeschenke];
        Vergeben = new ArrayList<>();
        Zwischenspeicher = new int[Input.AnzahlGeschenke];
        wunscharraylänge = Wunscharray.size();
        moveSingleNumbers(0, wunscharraylänge);
        wunscharraylänge = Wunscharray.size();
        for (int i = 0; i < wunscharraylänge; i++) {
            moveMultipleNumbers(0, Wunscharray.get(i), 0);
        }
        Extendprocessing.getBestDistribution(Wunscharray, 1);
        Extendprocessing.Geschenkvergabe(Wunscharray);

        System.out.println("Erster Print");
        Debug.printArraylists_Array(Wunscharray);
        System.out.println();
        Debug.printArrayList(Vergeben);
        //------------------------------------------------
        wunscharraylänge = Wunscharray.size();
        moveSingleNumbers(1, wunscharraylänge);
        wunscharraylänge = Wunscharray.size();
        for (int t = 0; t < wunscharraylänge; t++) {
            moveMultipleNumbers(1, Wunscharray.get(t), 0);
        }
        Extendprocessing.getBestDistribution(Wunscharray, 2);
        Extendprocessing.Geschenkvergabe(Wunscharray);
        System.out.println("Zweiter Print");
        Debug.printArraylists_Array(Wunscharray);
        System.out.println();
        Debug.printArrayList(Vergeben);
        //------------------------------------------------
        wunscharraylänge = Wunscharray.size();
        moveSingleNumbers(2, wunscharraylänge);
        wunscharraylänge = Wunscharray.size();
        for (int t = 0; t < wunscharraylänge; t++) {
            moveMultipleNumbers(2, Wunscharray.get(t), 0);
        }
        Extendprocessing.getBestDistribution(Wunscharray, 3);
        Extendprocessing.Geschenkvergabe(Wunscharray);
        System.out.println("Finaler Print");
        Debug.printArraylists_Array(Wunscharray);
        System.out.println();
        Debug.printArrayList(Vergeben);
        endevergeben();
        Output.main();
    }

    public static void moveSingleNumbers(int spalte, int länge) {
        System.out.println("moveSingleNumbers");
        for (int i = 0; i < länge; i++) {
            int[] zw = Wunscharray.get(i);
            for (int j = 0; j < zw.length; j++) {
                wunsch[j] = zw[j];
            }
            for (int k = 0; k < Extendprocessing.Geschenkezaehler.length; k++) {// i = Geschenk
                if (Extendprocessing.Geschenkezaehler[k][spalte] == 1) {
                    int schüler = Extendprocessing.getIndexofSingleNumber(k, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                    //Feste Verteilung für Wünsche über alle Versuche
                    if (wunsch[schüler] == 0 && Vergeben.contains(k) == false) {
                        wunsch[schüler] = (spalte + 1);
                    }
                }
            }
            for (int l = 0; l < wunsch.length; l++) {
                zw[l] = wunsch[l];
            }
            Wunscharray.set(i, zw);
        }
        int[] first = Wunscharray.get(Wunscharray.size() - 1);
        counter = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] == spalte + 1) {
                counter++;
            }
        }
    }

    public static void moveMultipleNumbers(int spalte, int[] arr, int x) {
        for (int i = x; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] > 1) {
                Extendprocessing.getIndexofMultipleNumbers(i, spalte);
                for (int f = 0; f < Extendprocessing.Geschenkezaehler[i][spalte]; f++) {
                    Extendprocessing.getIndexofMultipleNumbers(i, spalte);
                    int[] arr2 = new int[arr.length];
                    for (int d = 0; d < arr.length; d++) {
                        arr2[d] = arr[d];
                    }
                    int zw = Extendprocessing.IndexOfMultipleNumbers.get(f);
                    if (arr[zw] == 0 && Vergeben.contains(i) == false) {
                        arr2[zw] = spalte + 1;
                    }
                    int counterNeu = 0;
                    for (int h = 0; h < arr2.length; h++) {
                        if (arr2[h] == spalte + 1) {
                            counterNeu++;
                        }
                    }
                    int[] arr3 = new int[arr2.length];
                    if (counterNeu >= counter && counterNeu != 0) {
                        for (int p = 0; p < arr2.length; p++) {
                            arr3[p] = arr2[p];
                        }
                        Extendprocessing.schonVorhanden(arr3);
                        if (Freigabe == true) {
                            Wunscharray.add(arr3);
                            counter = counterNeu;
                        }
                    }
                    if (spalte == 0) {
                        moveMultipleNumbers(0, arr2, i + 1);
                    } else {
                        moveMultipleNumbers(0, arr3, i + 1);
                    }
                }
            }
        }
    }

    public static void endevergeben() {
        Random randomine = new Random();
        int randomzahl = randomine.nextInt(Wunscharray.size());
        int[] zw = Wunscharray.get(randomzahl);
        finaleWunschverteilung = new int[zw.length];
        for(int i = 0; i < zw.length; i++){
            finaleWunschverteilung[i] = zw[i];
        }
        System.out.print("finale Geschenkeverteilung");
        Debug.printArray(finaleWunschverteilung);
        Vergeben = new ArrayList<>();
        for (int i = 0; i < finaleWunschverteilung.length; i++) {
            if (finaleWunschverteilung[i] == 1) {
                int geschenk = (int) Input.WünscheAusTXT[i][0];
                anzahlErstervergebenerWünsche++;
                endergebnis[i] = geschenk;
                Vergeben.add(geschenk);
            } else if (finaleWunschverteilung[i] == 2) {
                int geschenk = (int) Input.WünscheAusTXT[i][1];
                anzahlZweitervergebenerWünsche++;
                endergebnis[i] = geschenk;
                Vergeben.add(geschenk);
            } else if (finaleWunschverteilung[i] == 3) {
                int geschenk = (int) Input.WünscheAusTXT[i][2];
                anzahlDrittervergebenerWünsche++;
                endergebnis[i] = geschenk;
                Vergeben.add(geschenk);
            }
        }
        List <Integer> netVergebeneGeschenke = new ArrayList<>();
        List <Integer> netVergebeneGeschenke_sicherung = new ArrayList<>();
        for(int i = 1; i < Input.AnzahlGeschenke + 1; i++){
            if (Vergeben.contains(i) == false) {
                netVergebeneGeschenke.add(i);
                netVergebeneGeschenke_sicherung.add(i);
            }
        }
        for(int i = 0; i < endergebnis.length; i++){
            if(endergebnis[i] == 0){
                if (netVergebeneGeschenke.size() != 0){
                    endergebnis[i] = netVergebeneGeschenke.get(netVergebeneGeschenke.size() - 1);
                    netVergebeneGeschenke.remove(netVergebeneGeschenke.size() - 1);
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Es folgt nun unser Ergebnis: ");
        Debug.printArray(endergebnis);
        System.out.println();
        System.out.print("Es wurden ");
        System.out.print(anzahlErstervergebenerWünsche);
        System.out.print("  erste Wünsche vergeben");
        System.out.println();
        System.out.print("Es wurden ");
        System.out.print(anzahlZweitervergebenerWünsche);
        System.out.print(" zweite Wünsche vergeben");
        System.out.println();
        System.out.print("Es wurden ");
        System.out.print(anzahlDrittervergebenerWünsche);
        System.out.print(" dritte Wünsche vergeben");
        System.out.println();
        System.out.print("Folgende Geschenke wurden zwangsweise vergeben: ");
        Debug.printArrayList(netVergebeneGeschenke_sicherung);
    }


}
