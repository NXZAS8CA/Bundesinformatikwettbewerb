import java.io.IOException;

public class sort extends processing{

    static long[][] Geschenkezaehler;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.AnzahlGeschenke +1][3];

    }
    public static long[][] countNumbers(){//A function to count number of numbers in each column of Tabellenarray.
        for(int i = 1; i <= Input.AnzahlGeschenke; i++){
            for(int y= 0; y < 3; y++) {
                for (int j = 0; j < Input.Tabellenarray.length; j++) {
                    if (i == Integer.parseInt(Input.Tabellenarray[j][y])) {
                        Geschenkezaehler[i][y]++;
                    }
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofSingleNumber(int input, int spalte){//Only works for numbers which appears once in their column
        int index = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Integer.parseInt(Input.Tabellenarray[i][spalte]) == input){
                 index = i;
            }
        }
        return index;
    }
}
