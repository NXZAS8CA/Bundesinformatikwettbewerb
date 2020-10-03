import java.io.IOException;


public class Processing {
    private static long[][] Endergebnis; // Zeile sind Wünsche -> aus Wunsch resultiert Geschenk xy
    private static long[][] Wunscharray; // [Zeile][Spalte]
    public static int maxmöglicheVerteilungen = 10;

    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function
        Endergebnis = new long[Input.NumberGifts][maxmöglicheVerteilungen];//TODO: muss dann noch für n Stellen gebaut werden.
        Wunscharray = new long[Input.NumberGifts][maxmöglicheVerteilungen];//TODO: muss dann noch für n Stellen gebaut werden.

        Extendprocessing.countNumbers(); //returnt Geschenkezähler
        moveSingleNumbers(0);
        Extendprocessing.getIndexofMultipleNumbers(4,0);

        Debug.printArrayofArray(Wunscharray, maxmöglicheVerteilungen);
        //System.out.println(Preprocessing.getHighestNumberofGifts(0));
    }

    public static void moveSingleNumbers(int spalte) {
        //Geschenkezaehler[n] = Anzahl der Wünsche für ein Geschenk n
        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] == 1) {
                int index = Extendprocessing.getIndexofSingleNumber(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler


                //Feste Verteilung für Wünsche über alle Versuche
                for (int f = 0; f < maxmöglicheVerteilungen; f++) {//TODO: Die 10 muss noch ausgetauscht werden.
                    Endergebnis[index][f] = i; //Welcher Schüler welches Geschenk erhielt
                    Wunscharray[index][f] = (spalte + 1); //Welcher Schüler welchen Wunsch erfüllt bekommen hat
                }

            }
        }
    }

    public static void moveMultipleNumbers() {


        /* Todo:
            Vergleich der ersten Ziffern (Geschenkezähler[n][0])
            if Geschenkezähler[n][0] == 1
                Index of Geschenkezähler in Tabellenarray suchen
                Index von tabellenarray Merken und in Endergebnis Eintragen
                Da erster Wunsch erfüllt wurde, Eintrag "1" in Wunscharray[Stelle des vergeben Wusches im Tabllenarray/ Nummer des Schülers] (muss noch erstellt werden).
                Idee wäre aus dem Wunscharray ein Booleanarray zu bauen um besser prüfen zu können.
            *Endergebnis in zweidimensionales array ändern. Jede "Runde" der Vergabe in eigene Spalte eintragen. Später erst auf Score prüfen*
            -oberer Teil ist soweit in moveSingleNumbers erfüllt
            -
            -
            -
            Im Falle von doppelten ersten Wünschen (Geschänkezähler[0] > 1)
            Ersten und letzten Index of Geschenkezähler in Tabellenarray suchen und diese vermerken (weiß noch net wie)- getIndexofMultipleNumbers returnt ein Array, indem die Indize von klein nach groß vermerkt sind.
                First = IndexofMultipleNumbers[0] , Last = IndexofMultipleNumbers[IndexofMultipleNumbers.length-1]
            if Wunscharray[erster gerade bestimmer Index von geschenkezähler] == 0 && Endergebnis == 0 (Für durchgang mit zweite/dritte Wünsche)
                Eintrag "1" in Wunscharray[Stelle des vergeben Wusches im Tabllenarray]
                Funktion für zweiten Wunsch
            -
            Diese Bedingung muss für die Anzahl der Doppelten Wünschen
        */


    }

    public static void deleteNumbers(int input) {
        for (int i = 0; i < 3; i++) {
            Input.Tabellenarray[input][i] = 0;
        }
    }
}
