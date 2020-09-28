import java.io.IOException;

public class sort extends processing{

    static long[] Geschenkezaehler;

    public static void main() throws IOException {
        Input.main();//call main input function
        Geschenkezaehler = new long[Input.AnzahlGeschenke +1];
        zaehleZahlen();

    }
    public static long[] zaehleZahlen(){
        for(int i = 1; i <= Input.AnzahlGeschenke; i++){
            for(int j = 0; j <Input.Tabellenarray.length;j++){
                if(i == Integer.parseInt(Input.Tabellenarray[j][0])) {
                    Geschenkezaehler[i]++;
                }
            }
        }
        return Geschenkezaehler;
    }

}
