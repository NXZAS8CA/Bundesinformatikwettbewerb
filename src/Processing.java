import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

import java.util.List;

public class Processing {
    public static List<int[]> Wunscharray;
    public static List<int[]> Endergebnisarray;


    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function

        Wunscharray = new ArrayList<int[]>();
        Endergebnisarray = new ArrayList<int[]>();

        Extendprocessing.countNumbers(); //returnt Geschenkezähler
        moveSingleNumbers(0);
        //moveMultipleNumbers(0);
        Extendprocessing.getIndexofMultipleNumbers(4,0);
        //System.out.println(Wunscharray1);
        int[] test = Wunscharray.get(0);

        for(int i = 0; i < test.length; i++){
            System.out.print(test[i]);
            System.out.print(",");

        }
        System.out.println();
        int[] test2 = Endergebnisarray.get(0);

        for(int i = 0; i < test2.length; i++){
            System.out.print(test2[i]);
            System.out.print(",");

        }
        System.out.println();



    }
    public  static void moveSingleNumbers(int spalte){
        int[] endergebnis = new int[Input.NumberGifts];
        int[] wunsch = new int[Input.NumberGifts];
        boolean Freigabe = true;
        for(int i = 0; i < Input.NumberGifts; i++){
            endergebnis[i] = 0;
            wunsch[i] = 0;
        }
        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] == 1) {
                int schüler = Extendprocessing.getIndexofSingleNumber(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                //Feste Verteilung für Wünsche über alle Versuche
                for(int f = 0; f < endergebnis.length; f++){
                    if(endergebnis[f] == i){
                        Freigabe = false;
                    }
                }
                if(Freigabe == true ){
                    endergebnis[schüler] = i;
                    wunsch[schüler] = (spalte + 1);

                }
            }
        }

        Wunscharray.add(wunsch);
        Endergebnisarray.add(endergebnis);

    }

    public static void moveMultipleNumbers(int spalte) {

    }
}
