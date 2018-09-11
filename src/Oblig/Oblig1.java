/*
    Huy Minh Le., s315271
    Tam Thu Caroline Vo, s326167
    Tora Sande Tveit, s326145
    Piotr Jan Kusnierz, s326178
    Kevin Nguyen Ngo, s326170
 */



package Oblig;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Oblig1 {

    /*
      METODER FRA UNDERVISNINGEN OG HJELPEMETODER
   */
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public Oblig1(){}

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

        return a[a.length-1];
    }

    /*
    Det er flest ombytter når det første elementet i tabellen er det største tallet.
    Det er minst ombytter når det siste elementet i tabellen er det største tallet
    Vi finner ut gjennomsnittet:
     */

    public static int ombyttinger(int[] a){
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
            sum += ombyttinger(printRandomArray(antall_element));
        }

        gjennomsnitt = (float)sum / (float)antallKjøringer;
        return gjennomsnitt;

    }

    /*
        Etter flere gjennomkjøringer ligger gjennomsnittet på 7
        Når man øker antall elementer, så nærmer antall bytter antall elementer.
        F.eks når antall elementer er 10 000 så nærmer gjennomsnittlige antall bytter også 10 000
        Testet 1 000 000 elementer, 999 985 antall bytter
     */

//
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
            else min = b[i];

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

        int venstre = 0;
        int hoyre = a.length - 1;

        while (venstre < a.length && (a[venstre] & 1) != 0)
            venstre++;
        while (hoyre >= 0 && (a[hoyre] & 1) == 0)
            hoyre--;

        while (true) {
            if (venstre < hoyre) bytt(a, venstre++, hoyre--);
            else break;
            while ((a[venstre] & 1) != 0)
                venstre++;
            while ((a[hoyre] & 1) == 0)
                hoyre--;
        }
        // Sorterer partall
        Arrays.sort(a,0,venstre);
        // Sorterer oddetall
        Arrays.sort(a,venstre,a.length);
    }


    //oppgave 5 og 6

    public static void rotasjon ( char[] c){


        if(c.length == 0) return;

        char last = c[c.length - 1];

        for (int i = c.length - 1; i > 0; i--) {
            c[i] = c[i - 1];
        }
        c[0] = last;

    }

    public static void rotasjon(char[] c, int k){

        int n = c.length;
        if (n < 1) return;

        k %= n; //k er et tall mellom -n og n
        if (k < 0) k += n;

        //Lager en hjelpetabell og kopierer den delen som blir skjøvet ut av
        char[] b = Arrays.copyOfRange(c, n - k, n);

        for (int i = n - 1; i >= k; i--){
            // forskyver
            System.arraycopy(c,i-k , c, i,1);
        }

        // Kopierer inn i den andre enden da elementene skyves ut
        System.arraycopy(b, 0, c, 0, k);

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
        return flettetStreng;
    }

    //oppgave 7b
    public static String flett (String... s){
        //Først må vi finne lengden av den lengste stringen
        //Deretter må vi lage en StringBuilder
        //Så legger vi til elementene i StringBuilder

        if(s.length == 0) return "";
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

        return sb.toString();
    }

    //oppgave 8

    public static int[] sorterArray ( int[] a){
        int[] copiedArray = new int[a.length];
        System.arraycopy(a, 0, copiedArray, 0, a.length);
        Arrays.sort(copiedArray);
        return copiedArray;
    }

    public static int[] indekssortering(int[] a){

        //Lage tabellen som skal returneres
        int[] indexSortert = new int[a.length];
        //Lage en hjelpetabell som er en sortert versjon av a
        int[] sortertA = sorterArray(a);
        boolean[] sortertBoolean = new boolean[a.length];
        int j = 0;

        for(int x : sortertA){
            for(int i = 0; i < a.length; i++){
                if(x == a[i] && !sortertBoolean[i]){
                    indexSortert[j++] = i;
                    sortertBoolean[i] = true;
                    break;
                }
            }
        }

        return indexSortert;
    }

    public static int[] tredjeMin(int[] a){
        if(a.length < 3) throw new NoSuchElementException("Tabellen har mindre enn 3 tall");
        int[] temp = {a[0],a[1],a[2]};
        temp = indekssortering(temp);

        int indeks1 = temp[0];
        int indeks2 = temp[1];
        int indeks3 = temp[2];

        int tall1 = a[indeks1];
        int tall2 = a[indeks2];
        int tall3 = a[indeks3];

        if(a.length > 3){
            for(int i = 3; i < a.length; i++){

                if(a[i] < tall3){
                    if(a[i] < tall2){
                        if(a[i] < tall1){
                            tall3 = tall2;
                            tall2 = tall1;
                            tall1 = a[i];
                            indeks3 = indeks2;
                            indeks2 = indeks1;
                            indeks1 = i;
                        }
                        else{
                            tall3 = tall2;
                            tall2 = a[i];
                            indeks3 = indeks2;
                            indeks2 = i;
                        }
                    }
                    else{
                        tall3 = a[i];
                        indeks3 = i;
                    }
                }
            }
        }

        temp = new int[] {indeks1,indeks2,indeks3};
        return temp;
    }


    //Oppgave 10
    public static boolean inneholdt(String a, String b) {
        if(a == "") {
            return true;
        }

        char[] bokstavtyper = new char[29];
        int[] antallBokstaver = new int[29];
        int index = 65;
        boolean bokstavFunnet;

        //Legger til alle bokstavene i tabellen bokstavtyper
        for(int i = 0; i < 26; i++) {
            bokstavtyper[i] = (char) index;
            index++;
        }

        bokstavtyper[26] = (char) 198;
        bokstavtyper[27] = (char) 216;
        bokstavtyper[28] = (char) 197;

        //Legger til antallet som finnes av hver bokstav i ordet a i tabellen antallBokstaver
        for(int j = 0; j < a.length(); j++) {
            index = 0;
            bokstavFunnet = false;

            while(!bokstavFunnet) {
                if(bokstavtyper[index] == a.charAt(j)) {
                    antallBokstaver[index]++;
                    bokstavFunnet = true;
                } else {
                    index++;
                }
            }
        }

        //Trekker fra antallet som finnes av hver bokstav i ordet b i tabellen antallBokstaver
        for(int k = 0; k < b.length(); k++) {
            index = 0;
            bokstavFunnet = false;

            while(!bokstavFunnet) {
                if(bokstavtyper[index] == b.charAt(k)) {
                    antallBokstaver[index]--;
                    bokstavFunnet = true;
                } else {
                    index++;
                }
            }
        }

        //Sjekker om det finnes bokstaver hvor antallet i ordet a er storre enn antallet i ordet b
        for(int l = 0; l < antallBokstaver.length; l++) {
            if(antallBokstaver[l] > 0) {
                return false;
            }
        }

        return true;
    }
    }
