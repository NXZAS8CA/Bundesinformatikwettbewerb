import java.io.IOException;

public class sort extends processing{

    static long[][] Geschenkezaehler;
    static int[] indexofgetIndexofDoubleNumbers;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.AnzahlGeschenke +1][3];

    }
    public static long[][] countNumbers(){//A function to count number of numbers in each column of Tabellenarray.
        for(int i = 1; i <= Input.AnzahlGeschenke; i++){
            for(int y= 0; y < 3; y++) {
                for (int j = 0; j < Input.Tabellenarray.length; j++) {
                    if (i == Input.Tabellenarray[j][y]) {
                        Geschenkezaehler[i][y]++;
                    }
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofSingleNumber(int input, int spalte){//Only works for numbers which appears once in their column//TODO: get position of wish and return it
        int index = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                 index = i;
            }
        }
        return index;
    }

    public static void getIndexofDoubleNumbers(int input, int spalte){//TODO: need to work on function, cant return two values.

        int n = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                indexofgetIndexofDoubleNumbers[n] = i;
                n++;
            }
        }

    }
}
