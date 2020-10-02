import java.io.IOException;

public class Preprocessing extends Processing {

    static long[][] Geschenkezaehler;


    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.NumberGifts +1][3];
        //IndexofgetIndexofDoubleNumbers = new int[10];

    }
    public static long[][] countNumbers(){//A function to count number of numbers in each column of Tabellenarray.
        for(int i = 1; i <= Input.NumberGifts; i++){
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

    public static int getIndexofSingleNumber(int input, int spalte){//Only works for numbers which appears once in their column// TODO: get position of wish and return it
        int index = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                index = i;
            }
        }
        return index;
    }

    public static int[] getIndexofDoubleNumbers(int input, int spalte){//Returns the two indices of the double Number
        int[] IndexOfDoubleNumbers = new int[2];
        int j = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Input.Tabellenarray[i][spalte] == input){
                IndexOfDoubleNumbers[j] = i;
                j++;
            }
        }
    return IndexOfDoubleNumbers;
    }

    public static int getHighestNumber(int input){
        int output = 0;
        for (int i = 0; i < Geschenkezaehler.length; i++){
            if(Geschenkezaehler[i][input] >= output){
                output = (int) Geschenkezaehler[i][input];
            }
        }
        return output;
    }
}
