import java.io.IOException;


public class processing {
    private static long[] Endergebnis;
    private static long[] Doppelte;

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
                deleteNumbers(index);

            }
        }
    }

    public static void moveDoubleNumbers(int spalte){
        sort.countNumbers(spalte);
        for(int i = 0; i <sort.Geschenkezaehler.length;i++){
            if(sort.Geschenkezaehler[i] > 1){
                Input.Tabellenarray[][];
                for (int r = 0; r < Input.Tabellenarray.length; r++){
                    if( Integer.parseInt(Input.Tabellenarray[r][0]) == i){
                        deleteNumbers(r);
                    }

                }
            }


        }


    }
    public static void deleteNumbers(int input){
        for(int i = 0; i <3; i++){
            Input.Tabellenarray[input][i] = String.valueOf(0);
        }
    }
}
