import java.io.IOException;

public class sort extends processing{

    static long[] Geschenkezaehler;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.AnzahlGeschenke +1];

    }
    public static long[] zaehleZahlen(int input){
        for(int i = 1; i <= Input.AnzahlGeschenke; i++){
            for(int j = 0; j <Input.Tabellenarray.length;j++){
                if(i == Integer.parseInt(Input.Tabellenarray[j][input])) {
                    Geschenkezaehler[i]++;
                }
            }
        }
        return Geschenkezaehler;
    }

    public static int getIndexofNumber(int input, int spalte){
        int index = 0;
        for(int i = 0; i < Input.Tabellenarray.length; i++){
            if(Integer.parseInt(Input.Tabellenarray[i][spalte]) == input){
                 index = i;
            }
        }
        return index;
    }
}
