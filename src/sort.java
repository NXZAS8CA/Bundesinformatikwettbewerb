import java.io.IOException;

public class sort extends processing{

    public static void main() throws IOException {
        Input.main();//call main input function


        long[] Geschenkezaehler = new long[Input.AnzahlGeschenke +1];


        for(int i = 1; i <= Input.AnzahlGeschenke; i++){
            for(int j = 0; j <Input.Tabellenarray.length;j++){
                if(i == Integer.parseInt(Input.Tabellenarray[j][0])) {
                    Geschenkezaehler[i]++;
                }
            }
        }

        for(int i = 1; i< Geschenkezaehler.length; i++){
            if(Geschenkezaehler[i] == 1)
                System.out.println(i);

        }

    }

}
