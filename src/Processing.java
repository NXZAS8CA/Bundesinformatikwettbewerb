import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;


public class Processing {
    public static List<int[]> Wunscharray;//Für jeden Schüler der erfüllte Wunsch
    public static List<int[]> Endergebnisarray;//Für jeden Schüler, welches Geschenk er erhalten hat.
    public static boolean Freigabe = true;
    public static int[] Zwischenspeicher;
    public static int[] endergebnis;
    public static int[] wunsch;
    public static List<Integer> Vergeben;
    public static int counter = 0;

    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function
        Extendprocessing.countNumbers(); //returnt Geschenkezähler
        int wunscharraylänge = 0;
        Wunscharray = new ArrayList<int[]>();
        Endergebnisarray = new ArrayList<int[]>();
        endergebnis = new int[Input.NumberGifts];
        for (int i = 0; i < Input.NumberGifts; i++) {
            endergebnis[i] = 0;
        }
        Wunscharray.add(endergebnis);
        Endergebnisarray.add(endergebnis);

        wunsch = new int[Input.NumberGifts];
        Vergeben = new ArrayList<>();
        Zwischenspeicher = new int[Input.NumberGifts];


        moveSingleNumbers(0, Wunscharray.size());
        wunscharraylänge = Wunscharray.size();
        for (int i = 0; i < wunscharraylänge; i++) {
            moveMultipleNumbers(0, Wunscharray.get(i), 0);
        }
        Extendprocessing.getBestDistribution(Wunscharray, 1);
        Extendprocessing.vergebeGeschenke(Wunscharray, 0);
        Debug.printArrayList(Vergeben);
        Debug.printArraylists_Array(Wunscharray);

        moveSingleNumbers(1, Wunscharray.size());
        wunscharraylänge = Wunscharray.size();
        System.out.print("Wunscharraylänge:");
        System.out.println(wunscharraylänge);
        for(int t = 0; t < wunscharraylänge; t++){
            moveMultipleNumbers(1, Wunscharray.get(t), 0);
        }
        Extendprocessing.getBestDistribution(Wunscharray, 2);
        Extendprocessing.vergebeGeschenke(Wunscharray, 1);

        moveSingleNumbers(2, Wunscharray.size());

        /*
        System.out.println("----");
        Debug.printArraylists_Array(Wunscharray);
        Extendprocessing.getBestDistribution(Wunscharray, 2);


*/
        System.out.println("Finaler print");
        Debug.printArraylists_Array(Wunscharray);
        Debug.printArrayList(Vergeben);
    }

    public static void moveSingleNumbers(int spalte, int länge) {
        System.out.println("moveSingleNumbers");
        for (int k = 0; k < länge; k++) {
            int[] zw = Wunscharray.get(k);
            for (int l = 0; l < zw.length; l++) {
                wunsch[l] = zw[l];
            }
            for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
                if (Extendprocessing.Geschenkezaehler[i][spalte] == 1) {
                    int schüler = Extendprocessing.getIndexofSingleNumber(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                    //Feste Verteilung für Wünsche über alle Versuche
                    if (Vergeben.contains(i) == false) {
                        if (wunsch[schüler] == 0) {
                            wunsch[schüler] = (spalte + 1);
                        }
                    }
                }
            }
            for (int l = 0; l < wunsch.length; l++) {
                zw[l] = wunsch[l];
            }

            Wunscharray.set(k, zw);

        }


        int[] first = Wunscharray.get(Wunscharray.size() - 1);
        counter = 0;
        for (int k = 0; k < first.length; k++) {
            if (first[k] == spalte + 1) {
                counter++;
            }
        }
        System.out.print("Counter");
        System.out.println(counter);


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
                        System.out.print(zw);
                        System.out.println("...");
                        Debug.printArray(arr2);
                    }
                    int counterNeu = 0;
                    for (int h = 0; h < arr2.length; h++) {
                        if (arr2[h] == spalte + 1) {
                            counterNeu++;
                        }

                    }
                    int[] arr3 = new int[arr2.length];
                    if (counterNeu >= counter && counterNeu != 0) {
                        for(int p = 0; p < arr2.length; p++){
                            arr3[p] = arr2[p];
                        }
                        Wunscharray.add(arr3);
                        counter = counterNeu;
                    }
                    if(spalte == 0){
                        moveMultipleNumbers(0, arr2, i + 1);
                    }
                    else{
                        moveMultipleNumbers(0, arr3, i + 1);
                    }
                }
            }
        }
    }


}
