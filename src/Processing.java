import java.io.IOException;


public class Processing {
    private static long[][] Endergebnis; // Zeile sind Wünsche -> aus Wunsch resultiert Geschenk xy
    private static long[][] Wunscharray; // [Zeile][Spalte]

    public static void main(String[] args) throws IOException {
        Preprocessing.main();//call sort main function
        Endergebnis = new long[Input.NumberGifts][10];//TODO: muss dann noch für n Stellen gebaut werden.
        Wunscharray = new long[Input.NumberGifts][10];//TODO: muss dann noch für n Stellen gebaut werden.


        Preprocessing.countNumbers(); //returnt Geschenkezähler
        moveSingleNumbers();
        Preprocessing.getIndexofMultipleNumbers(4,0);

        Debug.printArrayofArray(Wunscharray);
        //System.out.println(Preprocessing.getHighestNumberofGifts(0));
    }

    public static void moveSingleNumbers() {
        //Geschenkezaehler[n] = Anzahl der Wünsche für ein Geschenk n
        for (int i = 0; i < Preprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Preprocessing.Geschenkezaehler[i][0] == 1) {
                int index = Preprocessing.getIndexofSingleNumber(i, 0); // Index = Index of Wunsch in Tabellenarray = Schüler
                int erfüllterWunsch = 0;

                //TODO:
                // Switch ist unnötig weil der index vorher schon mit der Spalte bestimmt wird. Siehe Input von getIndexofSingleNumber function.
                // Der Switch kann in anderen Situationen hilfreich sein, nicht aber in dieser function.
                /*switch((int) Input.Tabellenarray[index][0]) {//Switch welcher der drei Wünsche eines Schülers erfüllt wurde
                    case 0:
                        erfüllterWunsch = 1;
                        break;
                    case 1:
                        erfüllterWunsch = 2;
                        break;
                    case 2:
                        erfüllterWunsch = 3;
                        break;
                }*/
                //Feste Verteilung für Wünsche über alle Versuche
                for (int f = 0; f < 10; f++) {//TODO: Die 10 muss noch ausgetauscht werden.
                    Endergebnis[index][f] = i; //Welcher Schüler welches Geschenk erhielt
                    Wunscharray[index][f] = 1; //Welcher Schüler welchen Wunsch erfüllt bekommen hat
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
