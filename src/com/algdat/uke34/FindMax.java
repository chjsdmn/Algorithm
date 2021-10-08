package com.algdat.uke34;

public class FindMax {
    public static void main(String[] args){
        int a[]={5,2,9,1,10};
        System.out.println(maks(a,11));
    }
    //java里, in one class, 可以取相同名字的function，只要是参数不相同就行！
    public static int maks(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static int maks(int[] a,int b){  //java里可以取相同名字的function，只要是参数不相同就行！
        int maxVerdi=a[maks(a)];
        if(b>maxVerdi)
            return b;
        else return maxVerdi;
    }
}
