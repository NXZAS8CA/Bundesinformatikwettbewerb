import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
    public static void main(String[] args) throws IOException {
        //Processing.main();
        File file = new File("Output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Schüleranzahl: " + Input.NumberGifts);
        bw.newLine();
        bw.write("Erfüllte erste Wünsche: ");
        bw.newLine();
        bw.write("Erfüllte zweite Wünsche:");
        bw.newLine();
        bw.write("Erfüllte dritte Wünsche:");
        for(int i = 0; i < Input.NumberGifts; i++){


        }
        bw.close();
    }
}
