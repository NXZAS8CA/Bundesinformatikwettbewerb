import java.io.IOException;

public class processing {
    private static long[] Endergebnis;

    public static void main(String[] args) throws IOException {
        sort.main();//call sort main function
        Endergebnis = new long[Input.AnzahlGeschenke];
        moveSingleNumbers(0);
    }

    public static void moveSingleNumbers(int spalte){
        sort.countNumbers(spalte);
        for(int i = 0; i < sort.Geschenkezaehler.length; i++ ){
            if(sort.Geschenkezaehler[i] == 1){
                int index = sort.getIndexofNumber(i,spalte);
                Endergebnis[index] = i;
            }
        }
    }
}
