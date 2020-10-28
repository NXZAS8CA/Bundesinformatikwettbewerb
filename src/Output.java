import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class Output extends Processing{
    public static void main() throws IOException {
        int countFirst = 0;
        int countSecond = 0;
        int countThird = 0;
        int countRest = Input.NumberGifts-(countFirst + countSecond + countThird);
        //TODO: Es soll am Ende eine File ausgegeben werden, in der steht wie viele Wünsche erfüllt wurden und welchen Wunsch jeder Schüler erhalten hat.


        File file = new File("Output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Schüleranzahl: " + Input.NumberGifts);
        bw.newLine();
        bw.write("Erfüllte erste Wünsche: " );
        bw.newLine();
        bw.write("Erfüllte zweite Wünsche:");
        bw.newLine();
        bw.write("Erfüllte dritte Wünsche:");
        bw.newLine();
        bw.write("Nicht erfüllt Wünsche:" + countRest);
        bw.newLine();
        bw.write("");
        bw.newLine();
        for(int i = 0; i < Input.NumberGifts; i++){
            bw.write("Schüler "  + (i+1) + ":");
            bw.newLine();

        }
        bw.close();
    }


}
