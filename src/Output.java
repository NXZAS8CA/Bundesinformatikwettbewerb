import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output extends Processing{
    public static void main() throws IOException {
        int countFirst = anzahlErstervergebenerWünsche;
        int countSecond = anzahlZweitervergebenerWünsche;
        int countThird = anzahlDrittervergebenerWünsche;
        int countRest = Input.AnzahlGeschenke -(countFirst + countSecond + countThird);

        File file = new File("Output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Schüleranzahl: " + Input.AnzahlGeschenke);
        bw.newLine();
        bw.write("Erfüllte erste Wünsche: "  + countFirst);
        bw.newLine();
        bw.write("Erfüllte zweite Wünsche: " + countSecond);
        bw.newLine();
        bw.write("Erfüllte dritte Wünsche: " + countThird);
        bw.newLine();
        bw.write("Nicht erfüllte Wünsche: " + countRest);
        bw.newLine();
        bw.write("");
        bw.newLine();

        for(int i = 0; i < Input.AnzahlGeschenke; i++){
            bw.write("Schüler "  + (i+1) + ": " + Integer.toString(Processing.endergebnis[i]));
            bw.newLine();

        }
        bw.close();
    }


}
