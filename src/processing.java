import java.io.IOException;


public class processing {
    private static long[] Endergebnis; // zeile sind Wünsche -> aus Wunsch resultiert Geschenk xy
    private static long[] Doppelte;
    private static long[][] Wunscharray;

    public static void main(String[] args) throws IOException {
        sort.main();//call sort main function
        Endergebnis = new long[Input.AnzahlGeschenke];
        moveSingleNumbers();

    }

    public static void moveSingleNumbers() {
        sort.countNumbers();
        // i = Geschenk
        //Geschäknezaehler[n] = Anzahl der Wünsche für ein Geschenk n
        for (int i = 0; i < sort.Geschenkezaehler.length; i++) {
            if (sort.Geschenkezaehler[i] == 1) {
                int index = sort.getIndexofsingleNumber(i);
                Endergebnis[index] = i;

            }
        }
    }

    public static void moveDoubleNumbers(int spalte) {
        sort.countNumbers(spalte);
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
        for (int i = 0; i < sort.Geschenkezaehler.length; i++) {
            if (sort.Geschenkezaehler[i] > 1) {
                Input.Tabellenarray[][];
                for (int r = 0; r < Input.Tabellenarray.length; r++) {
                    if (Integer.parseInt(Input.Tabellenarray[r][0]) == i) {
                        deleteNumbers(r);
                    }

                }
            }


        }


    }

    public static void deleteNumbers(int input) {
        for (int i = 0; i < 3; i++) {
            Input.Tabellenarray[input][i] = String.valueOf(0);
        }
    }
}
