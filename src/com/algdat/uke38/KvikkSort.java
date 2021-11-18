package com.algdat.uke38;

import java.util.Arrays;

/**
 * 老师上课讲的，但是有BUG！！！
 */
public class KvikkSort {
    public static void main(String[] args) {
        int[] a = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        int[] b = {8, 5, 3, 6, 5, 2, 9, 1};
        int[] c = {2,1};
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a)); //[2, 1, 3, 4, 5, 6, 7, 8, 9]
        quicksort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b)); //[2, 1, 5, 3, 6, 8, 9, 5]
        quicksort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c)); //[2, 1]
    }

    public static
    void quicksort(int[] values, int left, int right) {
        System.out.println("Begynner quicksort  i intervallet [" +left + ", " + right + "]");
        // Hvis vi ikke har noe intervall igjen (l == r)
        // så slutter vi rekursjonen.
        if (left >= right) {
            System.out.println("Slutter rekursjon!");
            return;
        }

        //1. Bytt midterste verdi i arrayet til slutten.
        //   - se på verdien. Dette er skilleverdien (Pivot)
        int m = (left+right) / 2;  // Indeks til midterste verdi: eks (2 + 4) / 2 = 6/2 = 3
        int pivot = values[m];       //Ta vare på midt-verdien i en temp-variabel
        values[m] = values[right]; //Overskriv midt-variabelen med siste verdi i arrayet
        values[right] = pivot;       //Overskriv siste verdi i arrayet med temp-varabelen (midten)
        System.out.println("Pivot er indeks " + m + " verdi " + pivot);
        System.out.println("Flytter pivot " + m + "-" + right);

        //2. Partisjoner arrayet fra start til "nest siste kort" (siste kort er midt-kortet)
        //   - Flytt alt som er større enn eller lik skilleverdi til høyre
        //   - Flytt alt som er mindre enn skilleverdi til venstre
        //   - Ta vare indexen til den siste verdien som er mindre enn skilleverdi
        int index = partition(values, pivot, left, right);

        //3. Flytt skilleverdien (sist i arrayet) tilbake til riktig sortert plass
        //   (rett til høyre for siste verdi som er mindre enn skilleverdi i punkt 2)
        int sorted_index = index+1;
        int tmp = values[sorted_index];
        values[sorted_index] = values[right];
        values[right] = tmp;
        System.out.println("Flytter pivot tilbake til indeks " + sorted_index);


        //4. Gjenta for høyre sub-array og venstre sub-array
        System.out.println("Rekursjon venstre subarray");
        quicksort(values, left, sorted_index-1);
        System.out.println("Rekursjon høyre subarray");
        quicksort(values, sorted_index+1, right);

        System.out.println("Ferdig quicksort  i intervallet [" +left + ", " + right + "]");
    }


    /**
     * Partisjonerer arrayet basert på en skilleverdi, pivot.
     * Vi plasserer all verdier som er mindre enn pivot til venstre,
     * og alle verdier som er større eller lik til høyre. Vi returnerer
     * til slutt indeksen til siste tall som er mindre enn pivot.
     * @param values
     * @param left
     * @param right
     * @return
     */
    public static
    int partition(int[] values, int pivot, int left, int right) {
        int l = left;
        int r = right;

        //Kjør løkke helt til høyre og venstre-peker møtes på midten.
        //Da har vi funnet riktig plassering av pivot.
        while (l < r) {
            //Flytt venstre-peker mot høyre så lenge vi har tall
            //som er riktig sortert i forhold til pivot.
            while (l < r && values[r] >= pivot) {
                r = r-1;
            }
            while (l < r && values[l] < pivot) {
                l = l+1; //++l, l++
            }
            //Gjør tilsvarende for høyre-peker: Flytt mot venstre
            //så lenge vi har tall som er større eller lik pivot.

            //Nå har vi at values[l] >= pivot og values[r] < pivot
            //Disse kan byttes!
            if (l < r) {
                System.out.println("Bytter om " + l + "-" + r);
                int tmp = values[r];
                values[r] = values[l];
                values[l] = tmp;
                l = l+1;
                r = r-1;
            }
        }

        System.out.println("Siste tall mindre enn pivot er på indeks " + (l-1));
        return l-1;
    }
}
