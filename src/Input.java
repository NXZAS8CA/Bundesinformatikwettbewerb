import java.io.*;

public class Input {
    public Input(String s) {

    }

    public static void main(String[] args) {
       try{File file = new File("C:\\Users\\NXZAS8CA\\Documents\\Coding\\Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
           String AnzahlSchueler = br.readLine();
           int AnzahlGeschenke = Integer.parseInt(AnzahlSchueler);
           System.out.println(AnzahlGeschenke);
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
       }
        catch (IOException e) {
           e.printStackTrace();
       }
    }
}