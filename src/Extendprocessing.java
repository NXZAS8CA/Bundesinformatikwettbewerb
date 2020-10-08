import java.io.IOException;

public class Extendprocessing extends Processing {

    static long[][] Geschenkezaehler;
    public static long[] IndexOfMultipleNumbers;


    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.NumberGifts +1][3];
        IndexOfMultipleNumbers = new long[10];
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
        int f = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                IndexOfMultipleNumbers[f] = i;
                f++;

            }
        }
    }

    public static int getHighestNumberofGifts(int input){//TODO: Weiß nicht mehr was diese Funktion kann...
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



}
