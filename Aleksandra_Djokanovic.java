package com.itbootcamp.bgQA;

import java.util.Arrays;
import java.util.Scanner;

public class Aleksandra_Djokanovic {
    public static void main(String[] args) {
//        System.out.println(zbirCifara(1234));
//        System.out.println(stepenBroja(9, 3));
//       System.out.println(Arrays.toString(zbirIndexaNizaMeta(new int[]{2, 3, 10, -2}, 5)));
//        System.out.println(  toBinary( 100));
//        System.out.println("Broj trazene reci je: "+brojPonavljanja("  cao", "cao ,volim te,cao,cao hejvolim caocao"));
//        System.out.println(Arrays.toString(pomeriNule(new int[]{0,1, 0, 0, 2,0,0, 3})));
//        System.out.println(Arrays.toString(izbaciDuplikate(new int[]{6,6,5})));
    }

    //0. Implementirati metode za unos elemenata niza varijabilne dužine. Elementi treba da budu tipa int, String i char.
    public static int[] unosCelihBrojeva() {
        Scanner mojSkener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza celih brojeva: ");
        int duzinaNiza = mojSkener.nextInt();
        int[] nizCelihBrojeva = new int[duzinaNiza];
        for (int i = 0; i < duzinaNiza; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizCelihBrojeva[i] = mojSkener.nextInt();
        }
        return nizCelihBrojeva;
    }

    public static String[] unosStringova() {
        Scanner mojSkener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza reci: ");
        int duzinaNiza = mojSkener.nextInt();
        String[] nizStringova = new String[duzinaNiza];
        for (int i = 0; i < duzinaNiza; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizStringova[i] = mojSkener.next();
        }
        return nizStringova;
    }

    public static char[] unosKaraktera() {
        Scanner mojSkener = new Scanner(System.in);
        System.out.print("Unesite duzinu niza karaktera: ");
        int duzinaNiza = mojSkener.nextInt();
        char[] nizKaraktera = new char[duzinaNiza];
        for (int i = 0; i < duzinaNiza; i++) {
            System.out.println("Unesite" + i + ". clan niza: ");
            nizKaraktera[i] = mojSkener.next().charAt(i);
        }
        return nizKaraktera;
    }

//1. Implementirati metodu int zbirCifara(int n) koja sabira cifre sve dok rezultat ne bude samo jedna cifra.
//Npr. 1234 -> 1, 43 -> 7, 55 -> 1, 556 -> 7

    public static int zbirCifara(int pocetnaCifra) {

        String pocetnaCifraString = String.valueOf(pocetnaCifra);
        int[] pocetnaCifraNiz = new int[pocetnaCifraString.length()];

        //smestam brojeve iz "pocetnaCifra" u "pocetnaCifraNiz"
        for (int i = 0; i < pocetnaCifraNiz.length; i++) {
            pocetnaCifraNiz[i] = pocetnaCifraString.charAt(i) - '0';
        }

//pravim konacanRezultatNiz u koji smestam rezultat sabiranja cifara

        int konacanRezultat = 0;

//sabiram cifre 1+2+3+4 i "konacanRezultat"=10
        for (int i = 0; i < pocetnaCifraNiz.length; i++) {
            konacanRezultat += pocetnaCifraNiz[i];
        }
        int[] konacanRezultatNiz = new int[pocetnaCifraString.length()];
//ulazim u do...while petlju
        do {
            //prebacujem int "konacanRezultat" u String
            String konacanRezultatString = String.valueOf(konacanRezultat);
            konacanRezultatNiz = new int[konacanRezultatString.length()];

            //smestam vrednosti String "konacanRezultat" u niz "konacanRezultatNiz"=[1,0]
            for (int i = 0; i < konacanRezultatNiz.length; i++) {
                konacanRezultatNiz[i] = konacanRezultatString.charAt(i) - '0';
            }

            konacanRezultat = 0;
            //sad sabiram clanove 1+0 unutar niza "konacanRezultatNiz"
            for (int i = 0; i < konacanRezultatNiz.length; i++) {
                konacanRezultat += konacanRezultatNiz[i];
            }
            //prebacujem int "konacanRezultat" u String
            konacanRezultatString = String.valueOf(konacanRezultat);

            //smestam vrednosti String "konacanRezultat" u niz "konacanRezultatNiz"=[1,0]
            for (int i = 0; i < konacanRezultatString.length(); i++) {
                konacanRezultatNiz[i] = konacanRezultatString.charAt(i) - '0';
            }
        } while (konacanRezultatNiz.length >= 2);


        return konacanRezultat;
    }

    //2. Implementirati metodu boolean stepenBroja(int n, int m) koja vraća true ukoliko je n stepen broja m.
    //Npr: (9, 3) -> true, (125, 5) -> true, (13, 4) -> false

    public static boolean stepenBroja(int stepenBroja, int osnovniBroj) {
        boolean pripada = true;
        int rezultat = 1;
        while (rezultat < stepenBroja) {
            rezultat *= osnovniBroj;
        }
        if (rezultat != stepenBroja) {
            pripada = false;
        }
        return pripada;
    }

    //3. Implementirati metodu int[] zbirIndexaNizaMeta(int[] niz, int meta) koja vraća indekse dva elementa koji kada se saberu daju rezultat koji je jednak meti.
    //Npr. ({2, 3, 10, -2}, 5) -> {0, 1}

    public static int[] zbirIndexaNizaMeta(int[] niz, int meta) {
//IZBRISI NULE IZ NIZA
        int[] rezultat = new int[2];
        for (int i = 0; i < niz.length; i++) {
            for (int j = 1 + i, k = 0; j < niz.length; j++) {
                if (niz[i] + niz[j] == meta) {
                    rezultat[k] = i;
                    rezultat[k + 1] = j;
                    break;
                }
            }
        }

        return rezultat;
    }

    //4. Implementirati metodu String toBinary(int n) koja vraća broj n u binarnom formatu. Uzeti apsolutnu vredost n.
    //Npr. 10 -> 1010, 100 -> 1100100

    public static String toBinary(int broj) {
        broj = Math.abs(broj);
        int pocetnaCifra = 1;
        //hocu da se duzina niza poveca za jedan kad se pojavi jedan novi clan
        //tj. pri svakoj iteraciji while petlje
        int duzinaNiza = 0;
        while (pocetnaCifra < broj) {
            pocetnaCifra *= 2;
            duzinaNiza++;
        }
        int[] niz = new int[duzinaNiza];
        pocetnaCifra = 1;
        for (int i = duzinaNiza - 1; i < duzinaNiza; i--) {
            niz[i] = pocetnaCifra;
            pocetnaCifra *= 2;
            if (i <= 0) {
                break;
            }
        }
        broj = broj - niz[0];
        niz[0] = 1;
        for (int i = 1; i < duzinaNiza; i++) {
            if (broj < niz[i]) {
                niz[i] = 0;
                continue;
            } else {
                broj = broj - niz[i];
                niz[i] = 1;
            }

        }


        String binarniBroj = Arrays.toString(niz);
        return binarniBroj;
    }

    //  5. Implementirati metodu int brojPonavljanja(String s, String recenica) koja vraća broj ponavljanja stringa "s" u rečenici. Hint: istražiti s.split("") metodu.
    //  Npr. ("cao", "cao kako si cao") -> 2

    public static int brojPonavljanja(String rec, String recenica) {
        recenica = recenica.toLowerCase();
        rec = rec.trim();
        int brojReci = 0;
        String trazenaRec = "";
        //ako imam napisano "caocao" hocu da ih razdvojim sa for petljom gde ako su mi tri karaktera jedan za drugim 'c''a''o' da ih izdvoji
        //pa da te karaktere pretvorim u rec i ubacim u niz[] i onda samo izbrojim clanove niza koji su.equals("cao")

        for (int i = 0; i < recenica.length(); i++) {
            if (recenica.charAt(i) == rec.charAt(0)) {
                trazenaRec += recenica.charAt(i);
                for (int j = i + 1, k = 1; k < rec.length(); j++, k++) {
                    if (recenica.charAt(j) == rec.charAt(k)) {

                        trazenaRec += recenica.charAt(j);
                    }
                }
            }
        }
        brojReci = trazenaRec.length() / rec.length();

        return brojReci;
    }

    //6. Implementirati metodu int[] pomeriNule(int[] niz) koja vraća niz u kome su sve nule pomerene na kraj niza.
    //Npr. {1, 0, 0, 2, 3} -> {1, 2, 3, 0, 0}

    public static int[] pomeriNule(int[] niz) {
        int privremenoSkladiste;
        Arrays.sort(niz);
        for (int i = 0; i < niz.length; i++) {
            for (int j = i + 1; j < niz.length; j++) {
                if (niz[j] != 0) {
                    privremenoSkladiste = niz[i]; //nula ide u privremenoSkladiste
                    niz[i] = niz[j]; // na mesto nule ide prvi broj razlicit od nule
                    niz[j] = privremenoSkladiste; // nula ide na mesto j-tog broja
                    break;
                }
            }
        }

        return niz;
    }

    //7. Implementirati metodu int[] izbaciDuplikate(int[] niz) koja vraća niz bez duplikata.
    //Npr. {1, 2, 3, 3} -> {1, 2, 3}, {3, 4, 3, 4, 3, 4, 5} -> {3, 4, 5}

    public static int[] izbaciDuplikate(int[] niz) {
        Arrays.sort(niz);
        int[] rezultat = new int[niz.length];
        rezultat[0] = niz[0];
        int k = 1;
        boolean active = true;
        for (int i = 0; active; ) {
            if (i == niz.length - 1)
                active = false;
            for (int j = i + 1; j < niz.length; j++) {
                if (j == niz.length - 1)
                    active = false;
                if (niz[i] != niz[j]) {
                    rezultat[k] = niz[j];
                    k++;
                    i = j;
                    break;
                }
            }
        }
        
        return rezultat;
    }




}



