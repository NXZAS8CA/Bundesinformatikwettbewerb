import java.io.IOException;

public class processing {
    private static long[][] Endergebnis; // Zeile sind Wünsche -> aus Wunsch resultiert Geschenk xy
    private static long[] Doppelte;
    private static long[][] Wunscharray; // [Zeile][Spalte]

    public static void main(String[] args) throws IOException {
        sort.main();//call sort main function
        Endergebnis = new long[Input.AnzahlGeschenke][10];
        Wunscharray = new long[Input.AnzahlGeschenke][10];
        moveSingleNumbers();
        //System.out.println(Endergebnis[7][7]);
        //System.out.println(Wunscharray[7][7]);
        debug.main(sort.Geschenkezaehler);
    }

    public static void moveSingleNumbers() {
        sort.countNumbers(); // Geschenkezähler
        //Geschenkezaehler[n] = Anzahl der Wünsche für ein Geschenk n
        // i = Geschenk
        for (int i = 0; i < sort.Geschenkezaehler.length; i++) {
            if (sort.Geschenkezaehler[i][0] == 1) {
                int index = sort.getIndexofSingleNumber(i, 0); // Index = Index of Wunsch in Tabellenarray => Schüler
                int erfüllterWunsch = 0;

                //Welcher der drei Wünsche wurde erfüllt
                switch(Integer.parseInt(Input.Tabellenarray[index][0])) {
                    case 0:
                        erfüllterWunsch = 1;
                        break;
                    case 1:
                        erfüllterWunsch = 2;
                        break;
                    case 2:
                        erfüllterWunsch = 3;
                        break;
                }
                //Feste Verteilung für Wünsche über alle Versuche
                for (int f = 0; f < 10; f++) {
                    Endergebnis[index][f] = i; //Welcher Schüler welches Geschenk erhielt
                    Wunscharray[index][f] = erfüllterWunsch; //Welcher Schüler welchen Wunsch erfüllt bekommen hat
                }

            }
        }
    }

    public static void moveDoubleNumbers(int spalte) {
        /* Todo:
            Verleich der ersten Ziffern (Geschenkezähler[0])
            if Geschenkezähler == 1
                Index of Geschenkezähler in Tabellenarray suchen
                Index von tabellenarray Merken und in Endergebnis Eintragen
                Da erster Wunsch erfüllt wurde, EIntrag "1" in Wunscharray[Stelle des vergeben Wusches im Tabllenarray] (muss noch erstellt werden)
            *Endergebnis in zweidimensionales array ändern. Jede "Runde" der vergabe in eigene Spalte eintragen. Später erst auf Score prüfen*
            -
            Im Falle von doppelten ersten Wünschen (Geschänkezähler[0] > 1)
            Ersten und letzten Index of Gescheknezähler in Tabellenarray suchen und diese vermerken (weiß noch net wie)
            if Wunscharray[erster gerade bestimmer Index von geschenkezähler] == 0 && Endergebnis == 0 (Für durchgang mit zweite/dritte Wünsche)
                Eintrag "1" in Wunscharray[Stelle des vergeben Wusches im Tabllenarray]
                Funktion für zweiten Wunsch
            -
            Diese Bedingung muss für die Anzahl der Doppelten Wünschen
        */


    }

    public static void deleteNumbers(int input) {
        for (int i = 0; i < 3; i++) {
            Input.Tabellenarray[input][i] = String.valueOf(0);
        }
    }

}
