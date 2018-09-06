package Oblig;

import java.sql.SQLOutput;
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
        String streng1 = "abcdef";
        String streng2 = "123456789";
        //int[] a = new int[0];
        //kaller maks metoden
        //maks(a);
        //antallBytter(a);
        //gjennomsnittOmbytter();

        //int antallUlike = antallUlikeSortert(b);
        //System.out.println(antallUlike);

        //rotasjon(c,3);
        //rotasjon(c, -5);

        //flett(streng1, streng2);
        //flett2("hei på deg", "asdfasd", "123456789");

        int[] abc = {8,3,1,4,5,6,2,0};
        //indexsortering(abc, 0, a.length);
        //tredjeMin(abc);

        /* OPPGAVE 4 */
        int[] d = {6,10,9,4,1,3,8,5,2,7};
        delsortering(d);
        System.out.println(Arrays.toString(d));


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
        return antall;
    }

    public static float gjennomsnittOmbytter(){
        //Vi kjører gjennom antall bytter med forskjellige arrays med lengde 10 hundre ganger og sjekker gjennomsnittet
        int antallKjøringer = 100;
        int antall_element = 10;
        int sum = 0;
        float gjennomsnitt;

        for(int i = 0; i < antallKjøringer; i++){
            sum += antallBytter(printRandomArray(antall_element));
        }

        gjennomsnitt = (float)sum / (float)antallKjøringer;
        System.out.println("Sum: " + sum + " Gjennomsnitt bytter: " + gjennomsnitt);
        return gjennomsnitt;

    }

    /*
        Etter flere gjennomkjøringer ligger gjennomsnittet på 7
        Når man øker antall elementer, så nærmer antall bytter antall elementer.
        F.eks når antall elementer er 10 000 så nærmer gjennomsnittlige antall bytter også 10 000
        Testet 1 000 000 elementer, 999 985 antall bytter
        TODO: Sjekk om hvordan det sammenligner med foreleseren sin algoritme
     */

    //Slutt gjennomsnitt

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

    //------------- oppgave 4 --------------

    //Metode for å sortere oddetall og partall
        public static void delsortering(int[]a) {
            //Venstre side av tabellen. Setter indeks 0 slik at verdien ligger først i tabellen.
            int v = 0;
            //Høyre side av tabellen. Tar tabell-lengde minus 1 slik at det starter helt bakerst
            int h = a.length - 1;

            for (int i = 0; i < a.length; i++) {
                /* Tar tallene fra venstre side der den setter oddetallene til siden.
                Om tallet er 3 og man tar modulo med 2 (3%2) vil man ligge igjen med 1 i rest.
                Hvis resultatet blir 1 og er lik 1 vil verdien flyttes til venstre side av tabellen. */
                if (a[v] % 2 == 1) {
                    v++;
                }

                /*Tar tallene som ligger nest bakerst i tabellen altså fra høyre side, og finner tall som er partall.
                Om tallet er 6 og man tar modulo med 2 (6%2), vil man ligge igjen med 0 i rest.
                Dersom resultatet blir 0 og er lik 0 vil verdien flyttes til høyre side av tabellen. */
                if (a[h] % 2 == 0) {
                    h--;
                }

                //Bytter tallene høyre og venstre.
                if (v < h) {
                    int temp = a[v];
                    a[v] = a[h];
                    a[h] = temp;
                }

                //Oddetall blir sortert som ligger på venstre side.
                Arrays.sort(a, 0, v);
                //Partall blir sortert som ligger på høyre side.
                Arrays.sort(a, v, a.length);

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
        }

    //oppgave 5 og 6
    public static void rotasjon ( char[] c, int k){

        System.out.println("Tabell før sortering: " + Arrays.toString(c));

        if (k >= 0) {
            for (int y = 0; y < k; y++) {
                char last = c[c.length - 1];


                for (int i = c.length - 1; i > 0; i--) {
                    c[i] = c[i - 1];
                }
                c[0] = last;

            }
        } else {
            k = Math.abs(k);
            for (int y = 0; y < k; y++) {
                char first = c[0];


                for (int i = 0; i < c.length - 1; i++) {
                    c[i] = c[i + 1];
                }
                c[c.length - 1] = first;

            }
        }

        System.out.println("Tabell etter sortering: " + Arrays.toString(c));
    }

    //oppgave 7a

    public static String flett (String s, String t){
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] flett = new char[a.length + b.length];
        int min = Math.min(a.length, b.length);

        for (int i = 0, j = 0; i < min; i++) {
            flett[j++] = a[i];
            flett[j++] = b[i];
        }

        if (a.length > b.length)
            System.arraycopy(a, min, flett, min * 2, a.length - min);
        else
            System.arraycopy(b, min, flett, min * 2, b.length - min);

        String flettetStreng = String.valueOf(flett);
        System.out.println(flettetStreng);
        return flettetStreng;
    }

    //oppgave 7b
    public static String flett2 (String...s){
        //Først må vi finne lengden av den lengste stringen
        //Deretter må vi lage en StringBuilder
        //Så legger vi til elementene i StringBuilder

        int length = s[0].length();
        for (int i = 1; i < s.length; i++) {
            if (s[i].length() > length) length = s[i].length();
        }
        //Nå har vi lengden til den lengste stringen

        StringBuilder sb = new StringBuilder();

        //Looper gjennom for hver bokstav
        for (int i = 0; i < length; i++) {
            //Sjekker for hver string i s
            for (String t : s) {
                if (t.length() > i) sb.append(t.charAt(i));
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    //oppgave 8

    public static int[] sorterArray ( int[] a){
        int[] copiedArray = new int[a.length];
        System.arraycopy(a, 0, copiedArray, 0, a.length);
        Arrays.sort(copiedArray);
        return copiedArray;
    }

    public static int[] indexsortering ( int[] a, int fra, int til){

        //Lage tabellen som skal returneres
        int lengde = til - fra;
        if (lengde < 1) throw new Error("til er mindre enn fra");
        int[] indexSortert = new int[lengde];

        //TODO: Sjekk om jeg virkelig trenger å kopiere arrayen for å sortere

        int[] copyA = new int[lengde];
        System.arraycopy(a, fra, copyA, 0, lengde);
        System.out.println("Kopiert array: " + Arrays.toString(copyA));
        //Lage en hjelpetabell som er en sortert versjon av a
        int[] sortertA = sorterArray(copyA);
        boolean[] sortertBoolean = new boolean[a.length];
        int j = 0;

        for (int x : sortertA) {
            for (int i = 0; i < a.length; i++) {
                if (x == a[i] && !sortertBoolean[i]) {
                    indexSortert[j++] = i;
                    sortertBoolean[i] = true;
                    break;
                }
            }
        }


        System.out.println("Tabell før sortering: \n" + Arrays.toString(a));
        System.out.println("Tabell sortert i stigende rekkefølge: \n" + Arrays.toString(sortertA));
        System.out.println("Tabell sortert etter index: \n" + Arrays.toString(indexSortert));
        return indexSortert;
    }

    public static int[] tredjeMin ( int[] a){
        int length = a.length;
        if (length < 3) throw new NoSuchElementException("tabellen har mindre enn 3 tall");
        int[] treMin = indexsortering(a, 0, 3);

        //Tre hjelpevariabler for index til de minste tallene
        int indexM = treMin[0];
        int indexNm = treMin[1];
        int indexNnm = treMin[2];

        //Tre hjelpevariabler for verdien av de minste tallene
        int m = a[indexM]; //Minst
        int nm = a[indexNm]; //Nest minst
        int nnm = a[indexNnm]; //Nest nest minst


        if (a.length > 3) {
            for (int i = 3; i < a.length; i++) {
                if (a[i] < nnm) { //Hvis a[i] er mindre enn nnm
                    if (a[i] < nm) {//Hvis a[i] er mindre enn nnm og nm
                        if (a[i] < m) { //Hvis a[i] er mindre enn nmm, nm og m
                            nnm = nm;
                            nm = m;
                            m = a[i];
                        } else {
                            nnm = nm;
                            nm = a[i];
                        }
                    } else {
                        nnm = a[i];
                    }
                }
            }
        }

        treMin = new int[]{m, nm, nnm};
        System.out.println("De tre minste tallene i tabellen: \n" + Arrays.toString(treMin));
        return treMin;
    }

    //Oppgave 10
    public static boolean inneholdt (String a, String b){

        // Sjekker om Tegnstrengene har store bokstav.
        boolean aHarStoreBokstav = a.matches("[A-Z]*");
        boolean bHarStoreBokstav = b.matches("[A-Z]*");

        if (!(aHarStoreBokstav && bHarStoreBokstav)) {
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
    }
