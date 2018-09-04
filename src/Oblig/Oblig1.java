package Oblig;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args) {
        //Lager en random array
        int antall_element = 10;
        //int[] a = printRandomArray(antall_element);
        //System.out.println(Arrays.toString(a));

        int[] b = {3,3,4,5,5,6,7,7,7,8};
        char[] c = {'A','B','C','D','E','F','G','H','I','J'};

        //int[] a = new int[0];
        //kaller maks metoden
        //maks(a);
        //antallBytter(a);
        //int antallUlike = antallUlikeSortert(b);
        //System.out.println(antallUlike);

        rotasjon(c, -2);
        System.out.println("Tabell etter sortering: " + Arrays.toString(c));

        System.out.println();
    }

    //Start av maks metoden som finner største tall i en array og returnerer den
    public static int maks(int[] a){
        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        //For-løkke som kjører gjennom tabellen. a.length-1 er gjort for å ikke få en ArrayOutOfBounds-error
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                //lager en temp variabel og bytter a[i] og a[i+1]
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        //Skriver ut største tall i tabellen
        System.out.println("Største verdi av tabellen: " + a[a.length-1]);
        //returnerer største tall i tabellen
        return a[a.length-1];
    }

    /*
    Det er flest ombytter når det første elementet i tabellen er det største tallet.
    Det er minst ombytter når det siste elementet i tabellen er det største tallet
    Vi finner ut gjennomsnittet:
     */

    //Finn gjennomsnitt
    public static int antallBytter(int[] a){
        int antall = 0;

        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        //For-løkke som kjører gjennom tabellen. a.length-1 er gjort for å ikke få en ArrayOutOfBounds-error
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                //lager en temp variabel og bytter a[i] og a[i+1]
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                antall++;
            }
        }
        System.out.println("Antall ombytter: " + antall);
        return antall;
    }

    public static int antallUlikeSortert(int[] b){

        //Sjekker om tabellen har lengde 0
        if(b.length == 0)return 0;

        //lager variabel for det minste tallet i tabellen som ligger på index 0
        int min = b[0];
        //lager variabel for å sammenligne i tabellen for å finne antall unike tall
        int sammenlign = b[0];
        //antall unike må starte på 1, med tanke på at første tallet regnes som et unikt tall
        int unike = 1;

        //for-løkke som kjører gjennom tabellen
        for(int i = 1; i < b.length; i++){
            //sjekker om tabellen er sortert i stigende rekkefølge
            if(min > b[i]){
                throw new IllegalStateException("Tabellen er ikke sortert");
            }

            //finner antall ulike tall i tabellen
            if(sammenlign != b[i]){
                unike++;
                sammenlign = b[i];
            }
        }

        return unike;
    }

    //Metode som genererer ut forskjellige arrayer.
    public static int[] printRandomArray(int antall_element) {
        int verdi[] = new int[antall_element];

        //Fyll arrayet med tallene 1 til 1
        for (int i=0; i<antall_element; ++i) {
            verdi[i] = i+1;
        }

        //Kjører gjennom arrayet, og bytter tallene.
        for (int i=antall_element-1; i > 0; --i) {
            // Velger et tilfeldig tall, med verdi k
            int k = (int) (Math.random()*i);

            //bytt tallene k og i
            int temp = verdi[i];
            verdi[i] = verdi[k];
            verdi[k] = temp;
        }
        return verdi;
    }

    //oppgave 4
    public static int evenOddPartition(int[] data) {
        int i = 0, j = data.length - 1;
        do {
            while (i <= j && (data[i] & 1) == 0) { i++; }
            while (i <= j && (data[j] & 1) != 0) { j--; }

            if (i >= j) {
                return i;
            }
            int swap = data[i];
            data[i] = data[j];
            data[j] = swap;
        } while (true);
    }

    //oppgave 5 og 6
    public static void rotasjon(char[] c, int k){

        System.out.println("Tabell før sortering: " + Arrays.toString(c));

        int n = c.length;
        // tomt tabell vil ikke endre noe
        if (n < 1) return;

        // rotasjonen går motsatt vei
        if ((k %= n) < 0) k += n;

        //hjelpetabell
        char[] b = Arrays.copyOfRange(c, n - k, n);

        for (int i = n - 1; i >= k; i--){
            // forskyver
            c[i] = c[i - k];
        }

        // Kopierer inn i den andre enden da elementene skyves ut
        System.arraycopy(b, 0, c, 0, k);

    }



}
