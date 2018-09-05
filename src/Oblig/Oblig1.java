package Oblig;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Oblig1 {

    public static void main(String[] args) {
        //Lager en random array
        int antall_element = 10;
        //int[] a = printRandomArray(antall_element);
        //System.out.println(Arrays.toString(a));

        //int[] b = {3,3,4,5,5,6,7,7,7,8};
        //char[] c = {'a','b','c','d','e','f','g','h','i','j'};
        //int[] a = new int[0];
        //kaller maks metoden
        //maks(a);
        //antallBytter(a);
        //int antallUlike = antallUlikeSortert(b);
        //System.out.println(antallUlike);

        //rotasjon(c,3);
        //rotasjon(c, -3);

        System.out.println();

        /*
        //Oppgave 3
        int[] a = {5,3,7,4,3,5,7,8,6,7};
        System.out.println("Oppgave3:  " +antallUlikeUsortert(a));
        */

        /*
        //Oppgave 4
        int[] a = {6,10,9,4,1,3,8,5,2,7};
        delsortering(a);
        System.out.println("Oppgave4:  " +Arrays.toString(a));
        */

        //Oppgave 10
        String a = "ABBA";
        String b = "ABBABBA";
        String c = "BARBERER";

        System.out.println(inneholdt(a, b));  // Utskrift: true
        System.out.println(inneholdt(a, c));  // Utskrift: false
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

    //Oppgave 3
    public static int antallUlikeUsortert(int[] a) {

        //Slutter å sjekke hvis det er bare ett element i tabellen.
        if (a.length < 2) {
            return a.length;
        }

        int antallUlike = 1;

        for (int i = 1; i < a.length; i++) {

            int j = 0;

            for (; j < i; j++) {
                if (a[j] == a[i]) {
                    break;
                }
            }

            if (j == i) {
                antallUlike++;
            }
        }
        return antallUlike;
    }

    //oppgave 4
    static void delsortering(int[] a) {
        int v = 0;
        int h = a.length - 1;

        for(int i = 0; i < a.length; i++) {
            if(a[v] % 2 == 1) {
                v++;
            }

            if(a[h] % 2 == 0) {
                h--;
            }

            if (v < h) {
                int temp = a[v];
                a[v] = a[h];
                a[h] = temp;
            }
        }
        Arrays.sort(a, 0, v);
        Arrays.sort(a, v, a.length);
    }




    //oppgave 5 og 6
    public static void rotasjon(char[] c, int k){

        System.out.println("Tabell før sortering: " + Arrays.toString(c));

        if(k >= 0){
            for(int y = 0; y < k; y++){
                char last = c[c.length-1];


                for(int i = c.length-1; i > 0; i--){
                    c[i] = c[i-1];
                }
                c[0] = last;

            }
        }
        else{
            k = Math.abs(k);
            for(int y = 0; y < k; y++){
                char first = c[0];


                for(int i = 0; i < c.length-1; i++){
                    c[i] = c[i+1];
                }
                c[c.length-1] = first;

            }
        }

        System.out.println("Tabell etter sortering: " + Arrays.toString(c));
    }

    //Oppgave 10
    public static boolean inneholdt(String a, String b) {

        // Sjekker om Tegnstrengene har store bokstav.
        boolean aHarStoreBokstav = a.matches("[A-Z]*");
        boolean bHarStoreBokstav = b.matches("[A-Z]*");

        if(!(aHarStoreBokstav && bHarStoreBokstav)){
            throw new IllegalArgumentException("Tegnstrengene a og b ma ha kun store bokstaver!");
        }

        // Itererer gjennom String "a", fjernes først "occurence" fra b
        // og sjekker hvis størrelsen til b endret med 1, hvis ja
        // fortsetter, hvis nei returnerer false.
        String temp = b;

        for (int i = 0; i < a.length(); i++) {
            temp = temp.replaceFirst(Pattern.quote(a.substring(i, i + 1)), "");
            if (b.length() - temp.length() != i + 1) return false;
        }
        return true;
    }




     /*
        METODER FRA UNDERVISNINGEN OG HJELPEMETODER
     */

     /*
     public static void sorter(int[] a, int min, int max) {
         for (int i = min; i < (max - 1); i++) {
             for (int j = i + 1; j < max; j++) {
                 if (a[i] > a[j]) {
                     bytt(a, i, j);
                 }
             }
         }
     }

     public static void bytt(int[] a, int i, int j) {
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
     }
     */




}
