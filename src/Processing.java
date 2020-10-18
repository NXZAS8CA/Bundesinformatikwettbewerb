import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

public class Processing {
    private static long[][] Endergebnisarray; // Zeile sind Wünsche -> aus Wunsch resultiert Geschenk xy
    public static long[][] Wunscharray; // [Zeile][Spalte]
    public static int maxmöglicheVerteilungen = 10;

    public static ArrayList Wunscharray1;
    public static ArrayList Endergebnisarray1;


    public static void main(String[] args) throws IOException {
        Extendprocessing.main();//call sort main function

        Endergebnisarray = new long[Input.NumberGifts][maxmöglicheVerteilungen];//TODO: muss dann noch für n Stellen gebaut werden.
        Wunscharray = new long[Input.NumberGifts][maxmöglicheVerteilungen];//TODO: muss dann noch für n Stellen gebaut werden.
        Wunscharray1 = new ArrayList();
        Endergebnisarray1 = new ArrayList();

        Extendprocessing.countNumbers(); //returnt Geschenkezähler
        moveSingleNumbers1();
        //moveMultipleNumbers(0);
        Extendprocessing.getIndexofMultipleNumbers(4,0);
        System.out.println(Wunscharray1);
        System.out.println(Endergebnisarray1);

        //Debug.printArrayofArray(Endergebnis, maxmöglicheVerteilungen);
        //System.out.println(Extendprocessing.getScoreofWishes(1,1));//Funktioniert, Werte müssen aber überprüft werden.


    }
    public  static void moveSingleNumbers1(){
        int spalte = 0;
        String Inhalt_default= "";
        for(int i = 0; i < Input.NumberGifts; i++){
            Inhalt_default = Inhalt_default + "0";
        }
        StringBuilder Wunsch = new StringBuilder(Inhalt_default);
        StringBuilder Endergebnis1 = new StringBuilder(Inhalt_default);

        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] == 1) {
                int schüler = Extendprocessing.getIndexofSingleNumber(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                //Feste Verteilung für Wünsche über alle Versuche
                    Wunsch.setCharAt(schüler, '1');
                    char c= (char) i;
                    Endergebnis1.setCharAt(schüler, c);
                    //Endergebnis[schüler][f] = i; //Welcher Schüler welches Geschenk erhielt
                    //Wunscharray[schüler][f] = (spalte + 1); //Welcher Schüler welchen Wunsch erfüllt bekommen hat
            }
        }

        Wunscharray1.add(Wunsch);
        Endergebnisarray1.add(Endergebnis1);

    }

    public static void moveMultipleNumbers(int spalte) {
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
            Ersten und letzten Index of Geschenkezähler in Tabellenarray suchen und diese vermerken (weiß noch net wie)- tgeIndexofMultipleNumbers returnt ein Array, indem die Indize von klein nach groß vermerkt sind.
                First = IndexofMultipleNumbers[0] , Last = IndexofMultipleNumbers[IndexofMultipleNumbers.length-1]
            if Wunscharray[erster gerade bestimmer Index von geschenkezähler] == 0 && Endergebnis == 0 (Für durchgang mit zweite/dritte Wünsche)
                Eintrag "1" in Wunscharray[Stelle des vergeben Wusches im Tabllenarray]
                Funktion für zweiten Wunsch
            -
            Diese Bedingung muss für die Anzahl der Doppelten Wünschen
        */

        int f = 0; // Zähler für Spalte (Runde)
        int g = 0; //Zähler für betrachteter Schüler
        boolean freigabe = true;
        for (int i = 0; i < Extendprocessing.Geschenkezaehler.length; i++) {// i = Geschenk
            if (Extendprocessing.Geschenkezaehler[i][spalte] > 1) {
                Extendprocessing.getIndexofMultipleNumbers(i, spalte); // Index = Index of Wunsch in Tabellenarray = Schüler
                for(int x = 0; x < Extendprocessing.IndexOfMultipleNumbers.length; x++){

                    if(Endergebnisarray[(int)Extendprocessing.IndexOfMultipleNumbers[g]][f] == 0){ //Ist schon ein Ergebnis in Spalte f für den Schüler g vorhanden
                        for(int d = f; d  >= 0; d--){//Ist schon ein Geschenk in den vorherigen Spalten für Schüler g vorhanden
                            if(Endergebnisarray[(int)Extendprocessing.IndexOfMultipleNumbers[g]][d] == i){
                                freigabe = false;//Wenn schon vorhanden, keine Freigabe
                            }
                        }
                        if(freigabe == true){// Wenn freigabe erteilt = Gebe dem Schüler g in Spalte f das geschenk i
                            Endergebnisarray[(int)Extendprocessing.IndexOfMultipleNumbers[g]][f] = i;
                            f++;//betrachte die nächste Spalte (Runde)
                            g++;
                        }
                        else if(freigabe == false){//Wenn der Schüler g schon das Geschenk einaml erhalten hat, betrachte den nächsten Schüler
                            g++;
                            f++;
                        }
                    }
                }
            }
        }
    }
}
