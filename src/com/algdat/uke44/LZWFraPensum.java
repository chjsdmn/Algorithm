package com.algdat.uke44;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWFraPensum {

    public static void main(String[] args) {
        System.out.println(komprimer("ABBABABAC")); // [65, 66, 66, 256, 259, 67]
        System.out.println(komprimer("AAAAAAAAAAA")); // [65, 256, 257, 258, 65]
        System.out.println(dekomprimer(komprimer("ABBABABAC")));
        System.out.println(dekomprimer(komprimer("AAAAAAAAAAA")));
    }

    public static List<Integer> komprimer(String melding)
    {
        char c = melding.charAt(0);     // første tegn i meldingen
        String s = String.valueOf(c);   // tegnstrengen med c som innhold
        int kode = c;                   // tallkoden til c
        int nestekode = 256;            // første ledige tallkode

        Map<String,Integer> ordbok = new HashMap<>();  // en ordbok
        List<Integer> resultat = new ArrayList<>();    // resultatliste

        for (int i = 1; i < melding.length(); i++)  // resten av meldingen
        {
            c = melding.charAt(i);                    // neste tegn i meldingen
            Integer ordkode = ordbok.get(s + c);       // søker etter s + c

            if (ordkode == null)                      // s + c er ikke i ordboken
            {
                ordbok.put(s + c, nestekode++);         // legger s + c i ordboken
                s = String.valueOf(c);                  // setter s = c
                resultat.add(kode);
                kode = c;                               // kode blir tallkoden til c
            }
            else                                      // s + c er i ordboken
            {
                kode = ordkode;                         // kode = ordkoden til s + c
                s = s + c;                              // setter s = s + c
            }
        }
        resultat.add(kode);                         // alle tegn er behandlet

        return resultat;
    }

    public static String dekomprimer(List<Integer> koder)
    {
        int kode = koder.get(0);                        // første tallkode er < 256
        String t;                                       // foreløpig udefinert
        String s = String.valueOf((char)kode);          // ord med ett tegn
        char c;                                         // foreløpig udefinert
        StringBuilder resultat = new StringBuilder(s);  // til å lagre resultatet
        int nestekode = 256;                            // nestekode lik 256

        Map<Integer,String> ordbok = new HashMap<>();   // en ordbok

        for (int i = 1; i < koder.size(); i++)          // resten av tallene
        {
            kode = koder.get(i);                          // neste tall
            t = s;                                        // t settes lik s

            if (kode < nestekode)                         // kode er i ordboken
            {
                s = kode < 256 ? String.valueOf((char)kode) // ny verdi på s
                        : ordbok.get(kode);
                c = s.charAt(0);                            // c lik første tegn i s
            }
            else                                          // kode er ikke i ordboken
            {
                c = t.charAt(0);                            // c lik første tegn i t
                s = t + c;                                  // s lik t + c
            }

            resultat.append(s);                           // lagrer s
            ordbok.put(nestekode, t + c);                 // legger inn i ordboken
            nestekode++;                                  // øker nestekode med 1
        }

        return resultat.toString();
    }
}
