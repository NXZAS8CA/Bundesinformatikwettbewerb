import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output extends Processing{
    public static void main() throws IOException {

        File file = new File("Output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Schüleranzahl: " + Input.NumberGifts);
        bw.newLine();
        bw.write("Erfüllte erste Wünsche: ");
        bw.newLine();
        bw.write("Erfüllte zweite Wünsche:");
        bw.newLine();
        bw.write("Erfüllte dritte Wünsche:");
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