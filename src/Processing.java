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
        //Zwischenspeicher = new int[Input.NumberGifts];

        //-----------------------------------------------------
        moveSingleNumbers(0, Wunscharray.size());
        moveMultipleNumbers(0, Wunscharray.get(0), 0);
        //Extendprocessing.getIndexofMultipleNumbers(4, 0);//TODO: Hat meiner Meinung nach keinen Zweck.
        Extendprocessing.getBestDistribution(Wunscharray);
        Extendprocessing.vergebeGeschenke(Wunscharray);
        //------------------------------------------------------
        moveSingleNumbers(1, Wunscharray.size());
        moveMultipleNumbers(1, Wunscharray.get(0),0 );
        Extendprocessing.getBestDistribution(Wunscharray);
        Extendprocessing.vergebeGeschenke(Wunscharray);
        //------------------------------------------------------
        moveSingleNumbers(2, Wunscharray.size());
        moveMultipleNumbers(2, Wunscharray.get(0),0 );
        Extendprocessing.getBestDistribution(Wunscharray);
        Extendprocessing.vergebeGeschenke(Wunscharray);





        Debug.printArraylists_Array(Wunscharray);
        System.out.println();
        Debug.printArrayList(Vergeben);


    }

    public static void moveSingleNumbers(int spalte, int länge) {
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
                        if(wunsch[schüler] == 0){
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

        for (int k = 0; k < first.length; k++) {
            if (first[k] == 1) {
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
                    arr2[zw] = spalte + 1;


                    int counterNeu = 0;
                    for (int h = 0; h < arr2.length; h++) {
                        if (arr2[h] == spalte + 1) {
                            counterNeu++;
                        }

                    }
                    if (counterNeu >= counter) {
                        Wunscharray.add(arr2);
                        counter = counterNeu;
                    }
                    moveMultipleNumbers(0, arr2, i + 1);
                }
            }
        }
    }


}
